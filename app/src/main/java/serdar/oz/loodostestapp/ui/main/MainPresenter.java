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
import serdar.oz.loodostestapp.apiresponses.trending.Trending;
import serdar.oz.loodostestapp.network.MovieApi;
import serdar.oz.loodostestapp.network.RetrofitClient;
import serdar.oz.loodostestapp.ui.detail.DetailActivity;
import serdar.oz.loodostestapp.util.ProgressUtil;

import static serdar.oz.loodostestapp.constants.GlobalConstants.IMDB_ID;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;
    private final Context context;
    private Trending trendList;


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
    public void getTrendList() {
        ProgressUtil.showProgress(context);
        MovieApi movieApi = RetrofitClient.getApiClient().create(MovieApi.class);
        Call<Trending> call = movieApi.getTrendingList(NetworkConstants.MOVIE, NetworkConstants.WEEK, NetworkConstants.API_KEY);
        call.enqueue(new Callback<Trending>() {
            @Override
            public void onResponse(@NonNull Call<Trending> call, @NonNull Response<Trending> response) {
                if (response.isSuccessful())
                    trendList = response.body();
                if (trendList != null) {
                    mView.notifyMovieData(trendList);
                    mView.showResultView();
                } else
                    mView.noResultView();
                ProgressUtil.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<Trending> call, @NonNull Throwable t) {
                mView.showErrorMessage(t.getMessage());
                mView.noResultView();
                ProgressUtil.hideProgress();

            }
        });
    }

    @Override
    public void loadMoreTrendingData() {

    }

    @Override
    public void startDetailActivity(long mId, View view) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(IMDB_ID, mId);
        String transitionName = context.getString(R.string.movie_poster);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, transitionName);
        context.startActivity(i, transitionActivityOptions.toBundle());
    }


}