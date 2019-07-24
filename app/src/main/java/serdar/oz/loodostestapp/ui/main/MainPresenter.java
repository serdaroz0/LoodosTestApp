package serdar.oz.loodostestapp.ui.main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.constants.NetworkConstants;
import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.services.RetrofitClient;
import serdar.oz.loodostestapp.services.SearchApi;
import serdar.oz.loodostestapp.ui.detail.DetailActivity;
import serdar.oz.loodostestapp.util.ProgressUtil;

import static serdar.oz.loodostestapp.constants.GlobalConstants.IMDB_ID;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;
    private final Context context;
    private MovieList movieList;


    MainPresenter(Context context, MainContract.View mView) {
        this.mView = mView;
        this.context = context;
    }

    @Override
    public void created() {
        mView.bindViews();
        mView.initListeners();
    }


    @Override
    public void getMovieListWithQuery(String query) {
        ProgressUtil.showProgress(context);
        SearchApi searchApi = RetrofitClient.getApiClient().create(SearchApi.class);
        Call<MovieList> call = searchApi.getMovieList(query, NetworkConstants.API_KEY);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(@NonNull Call<MovieList> call, @NonNull Response<MovieList> response) {
                /*For every response we need to clear list first than add*/
                movieList = null;
                if (response.isSuccessful())
                    movieList = response.body();
                if (movieList != null && movieList.getSearch() != null && movieList.getSearch().size() > 0) {
                    mView.notifyMovieData(movieList);
                    mView.showResultView();
                } else
                    mView.noResultView();
                ProgressUtil.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<MovieList> call, @NonNull Throwable t) {
                mView.showErrorMessage(t.getMessage());
                mView.noResultView();
                ProgressUtil.hideProgress();

            }
        });
    }

    @Override
    public void startDetailActivity(String imdbId, View view) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(IMDB_ID, imdbId);
        String transitionName = context.getString(R.string.movie_poster);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, transitionName);
        context.startActivity(i, transitionActivityOptions.toBundle());
    }


}