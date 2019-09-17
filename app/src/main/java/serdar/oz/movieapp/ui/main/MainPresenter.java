package serdar.oz.movieapp.ui.main;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.movieapp.R;
import serdar.oz.movieapp.apiresponses.trending.TrendDetail;
import serdar.oz.movieapp.apiresponses.trending.Trending;
import serdar.oz.movieapp.constants.NetworkConstants;
import serdar.oz.movieapp.network.MovieApi;
import serdar.oz.movieapp.network.RetrofitClient;
import serdar.oz.movieapp.ui.detail.DetailActivity;
import serdar.oz.movieapp.util.ProgressUtil;

import static serdar.oz.movieapp.constants.GlobalConstants.IMDB_ID;

public class MainPresenter implements MainContract.Presenter {
    private long lastPage = 1;
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
        serviceRequestTrendList(lastPage);
    }

    @Override
    public void loadMoreTrendingData() {
        serviceRequestTrendList(lastPage);
    }

    @Override
    public void startDetailActivity(long mId, View view) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(IMDB_ID, mId);
        String transitionName = context.getString(R.string.movie_poster);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, transitionName);
        context.startActivity(i, transitionActivityOptions.toBundle());
    }

    private void serviceRequestTrendList(long pageNumber) {
        ProgressUtil.showProgress(context);
        MovieApi movieApi = RetrofitClient.getApiClient().create(MovieApi.class);
        Call<Trending> call = movieApi.getTrendingList(NetworkConstants.ALL, NetworkConstants.WEEK, NetworkConstants.API_KEY, pageNumber);
        call.enqueue(new Callback<Trending>() {
            @Override
            public void onResponse(@NonNull Call<Trending> call, @NonNull Response<Trending> response) {
                if (response.isSuccessful())
                    trendList = response.body();
                if (trendList != null) {
                    /*update lastPage for next page*/
                    lastPage = trendList.getmPage() + 1;
                    mView.notifyMovieData(trendList);
                    mView.showResultView();
                } else
                    mView.emptyView();
                ProgressUtil.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<Trending> call, @NonNull Throwable t) {
                mView.showErrorMessage(t.getMessage());
                mView.emptyView();
                ProgressUtil.hideProgress();

            }
        });
    }

    void checkIfContains(Trending trending, List<TrendDetail> trendingList) {
        for (TrendDetail detail : trending.getmTrendDetails()) {
            if (!trendingList.contains(detail))
                trendingList.add(detail);
            else
                trendingList.remove(detail);
        }
    }
}