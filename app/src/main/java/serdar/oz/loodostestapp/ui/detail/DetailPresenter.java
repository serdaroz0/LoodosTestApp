package serdar.oz.loodostestapp.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.loodostestapp.apiresponses.movieDetail.MovieDetail;
import serdar.oz.loodostestapp.constants.NetworkConstants;
import serdar.oz.loodostestapp.network.MovieApi;
import serdar.oz.loodostestapp.network.RetrofitClient;
import serdar.oz.loodostestapp.util.ProgressUtil;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailPresenter implements DetailContract.Presenter {
    private final DetailContract.View mView;
    private final Context context;
    private MovieDetail movieDetail;
    private long mId;

    DetailPresenter(Context context, DetailContract.View mView, long mId) {
        this.mView = mView;
        this.mId = mId;
        this.context = context;
    }


    @Override
    public void created() {
        mView.bindViews();
        if (mId != 0)
            getPosterData();
        else
            mView.loadPlaceholder();

    }

    @Override
    public void getPosterData() {
        ProgressUtil.showProgress(context);
        MovieApi movieApi = RetrofitClient.getApiClient().create(MovieApi.class);
        Call<MovieDetail> call = movieApi.getMovieDetail(mId, NetworkConstants.API_KEY);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetail> call, @NonNull Response<MovieDetail> response) {
                /*For every response we need to clear list first than add*/
                movieDetail = null;
                if (response.isSuccessful())
                    movieDetail = response.body();
                if (movieDetail != null && movieDetail.getImdbId() != null && !movieDetail.getImdbId().isEmpty())
                    mView.loadData(movieDetail);
                else
                    mView.loadPlaceholder();
                ProgressUtil.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<MovieDetail> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailureDetail: " + t.getMessage());
                ProgressUtil.hideProgress();
            }
        });
    }

    @Override
    public void onBackButtonPressed() {
        ((Activity) context).onBackPressed();
    }
}
