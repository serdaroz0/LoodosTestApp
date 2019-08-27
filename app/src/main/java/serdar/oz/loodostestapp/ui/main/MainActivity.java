package serdar.oz.loodostestapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.constants.GlobalConstants;
import serdar.oz.loodostestapp.apiresponses.trending.TrendDetail;
import serdar.oz.loodostestapp.apiresponses.trending.Trending;
import serdar.oz.loodostestapp.ui.base.BaseActivity;
import serdar.oz.loodostestapp.ui.main.adapter.IMovieAdapter;
import serdar.oz.loodostestapp.ui.main.adapter.MovieListAdapter;

public class MainActivity extends BaseActivity implements MainContract.View, IMovieAdapter {
    private static final String TAG = "MainActivity";
    @BindView(R.id.svSearch)
    SearchView svSearch;
    @BindView(R.id.rvSearchItems)
    RecyclerView rvSearchItems;
    @BindView(R.id.llNoResult)
    LinearLayout llNoResult;
    @BindView(R.id.llRecycler)
    LinearLayout llRecycler;
    private MainPresenter mPresenter;
    private MovieListAdapter movieListAdapter;
    private List<TrendDetail> trendingList = new ArrayList<>();
    private RecyclerView.OnScrollListener onScrollChangeListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (!recyclerView.canScrollVertically(1)) {
                mPresenter.loadMoreTrendingData();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this, this);
        mPresenter.created();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, GlobalConstants.GRID_SPAN_COUNT, RecyclerView.VERTICAL, false);
        rvSearchItems.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        rvSearchItems.setItemAnimator(new DefaultItemAnimator());
        mPresenter.getTrendList();
        movieListAdapter = new MovieListAdapter(this, trendingList, this);
        rvSearchItems.setAdapter(movieListAdapter); // set the Adapter to RecyclerView
        rvSearchItems.addOnScrollListener(onScrollChangeListener);
        View v = llRecycler.getChildAt(llRecycler.getChildCount() - 1);
        ProgressBar progressBar = new ProgressBar(this);
        if (v != progressBar)
            llRecycler.addView(progressBar);
    }

    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }


    @Override
    public void noResultView() {
        llNoResult.setVisibility(View.VISIBLE);
        rvSearchItems.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initListeners() {
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*If the limit is less than 2 character, an error message is return because a lot of results are returned than api*/
                //mPresenter.onQueryChanged(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public void showResultView() {
        llNoResult.setVisibility(View.GONE);
        rvSearchItems.setVisibility(View.VISIBLE);
    }

    @Override
    public void notifyMovieData(Trending trending) {
        trendingList.addAll(trending.getmTrendDetails());
        movieListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onMovieItemClicked(long mId, View view) {
        mPresenter.startDetailActivity(mId, view);
    }

    @Override
    public void onMovieClicked(long mId , View view) {
        onMovieItemClicked(mId, view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rvSearchItems.removeOnScrollListener(onScrollChangeListener);
    }
}
