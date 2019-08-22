package serdar.oz.loodostestapp.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.loodostestapp.constants.NetworkConstants;
import serdar.oz.loodostestapp.model.Detail;
import serdar.oz.loodostestapp.services.DetailApi;
import serdar.oz.loodostestapp.services.RetrofitClient;
import serdar.oz.loodostestapp.util.ProgressUtil;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailPresenter implements DetailContract.Presenter {
    private final DetailContract.View mView;
    private final Context context;
    private Detail detail;
    private String imdbId;

    DetailPresenter(Context context, DetailContract.View mView, String imdbId) {
        this.mView = mView;
        this.imdbId = imdbId;
        this.context = context;
    }


    @Override
    public void created() {
        mView.bindViews();
        if (imdbId != null)
            getPosterData();
        else
            mView.loadPlaceholder();

    }

    @Override
    public void getPosterData() {
        ProgressUtil.showProgress(context);
        DetailApi detailApi = RetrofitClient.getApiClient().create(DetailApi.class);
        Call<Detail> call = detailApi.getDetail(imdbId, NetworkConstants.API_KEY);
        call.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(@NonNull Call<Detail> call, @NonNull Response<Detail> response) {
                /*For every response we need to clear list first than add*/
                detail = null;
                if (response.isSuccessful())
                    detail = response.body();
                if (detail != null && detail.getİmdbID() != null && !detail.getİmdbID().isEmpty())
                    mView.loadData(detail);
                else
                    mView.loadPlaceholder();
                ProgressUtil.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<Detail> call, @NonNull Throwable t) {
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
