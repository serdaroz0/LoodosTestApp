package serdar.oz.movieapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.movieapp.R;
import serdar.oz.movieapp.apiresponses.trending.TrendDetail;
import serdar.oz.movieapp.apiresponses.trending.Trending;
import serdar.oz.movieapp.constants.GlobalConstants;
import serdar.oz.movieapp.ui.base.BaseActivity;
import serdar.oz.movieapp.ui.main.adapter.IMovieAdapter;
import serdar.oz.movieapp.ui.main.adapter.MovieListAdapter;

public class MainActivity extends BaseActivity implements MainContract.View, IMovieAdapter {
    private static final String TAG = "MainActivity";
    @BindView(R.id.rvSearchItems)
    RecyclerView rvTrendingItems;
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
        rvTrendingItems.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        rvTrendingItems.setItemAnimator(new DefaultItemAnimator());
        mPresenter.getTrendList();
        movieListAdapter = new MovieListAdapter(this, trendingList, this);
        rvTrendingItems.setAdapter(movieListAdapter); // set the Adapter to RecyclerView
        rvTrendingItems.addOnScrollListener(onScrollChangeListener);
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
    public void emptyView() {
        llNoResult.setVisibility(View.VISIBLE);
        rvTrendingItems.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initListeners() {
    }

    @Override
    public void showResultView() {
        llNoResult.setVisibility(View.GONE);
        rvTrendingItems.setVisibility(View.VISIBLE);
    }

    @Override
    public void notifyMovieData(Trending trending) {
        mPresenter.checkIfContains(trending, trendingList);
        movieListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onMovieItemClicked(long mId, View view) {
        mPresenter.startDetailActivity(mId, view);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        rvTrendingItems.removeOnScrollListener(onScrollChangeListener);
    }
}
