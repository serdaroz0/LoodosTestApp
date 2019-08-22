package serdar.oz.loodostestapp.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
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
import serdar.oz.loodostestapp.ui.base.BaseActivity;
import serdar.oz.loodostestapp.constants.GlobalConstants;
import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.ui.main.adapter.IMovieAdapter;
import serdar.oz.loodostestapp.ui.main.adapter.MovieListAdapter;
import serdar.oz.loodostestapp.util.KeyboardUtil;
import serdar.oz.loodostestapp.util.ProgressUtil;

public class MainActivity extends BaseActivity implements MainContract.View, IMovieAdapter {
    private static final String TAG = "MainActivity";
    @BindView(R.id.svSearch)
    SearchView svSearch;
    @BindView(R.id.rvSearchItems)
    RecyclerView rvSearchItems;
    @BindView(R.id.llNoResult)
    LinearLayout llNoResult;
    private MainPresenter mainPresenter;
    private MovieListAdapter movieListAdapter;
    private List<MovieList.Type> movieList = new ArrayList<>();
    private RecyclerView.OnScrollListener onScrollChangeListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            KeyboardUtil.hideKeyboard(MainActivity.this);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.created();
        /*Service response is coming very fast, I open showProgress() method so we can see the progress design.*/
        ProgressUtil.showProgress(MainActivity.this);
        new Handler().postDelayed(ProgressUtil::hideProgress, 1200);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, GlobalConstants.GRID_SPAN_COUNT, RecyclerView.VERTICAL, false);
        rvSearchItems.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        rvSearchItems.setItemAnimator(new DefaultItemAnimator());
        movieListAdapter = new MovieListAdapter(this, movieList, this);
        rvSearchItems.setAdapter(movieListAdapter); // set the Adapter to RecyclerView
        rvSearchItems.addOnScrollListener(onScrollChangeListener);
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
                if (query.length() > GlobalConstants.QUERY_MIN_LIMIT)
                    mainPresenter.getMovieListWithQuery(query);
                else
                    noResultView();
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
    public void notifyMovieData(MovieList movieModel) {
        movieList.clear();
        movieList.addAll(movieModel.getSearch());
        movieListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMovieItemClicked(String imdbId, View view) {
        mainPresenter.startDetailActivity(imdbId, view);
    }


    @Override
    public void onMovieClicked(String imdbId, View view) {
        onMovieItemClicked(imdbId, view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rvSearchItems.removeOnScrollListener(onScrollChangeListener);
    }
}
