package serdar.oz.loodostestapp.main;

import android.content.Context;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.loodostestapp.Constants;
import serdar.oz.loodostestapp.model.FilmList;
import serdar.oz.loodostestapp.services.RetrofitClient;
import serdar.oz.loodostestapp.services.SearchApi;
import serdar.oz.loodostestapp.util.Util;


public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;
    private final Context context;
    private FilmList filmList;


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
    public void getFilmListWithQuery(String query) {
        Util.showProgress(context);
        SearchApi searchApi = RetrofitClient.getApiClient().create(SearchApi.class);
        Call<FilmList> call = searchApi.getFilmList(query, Constants.API_KEY);
        call.enqueue(new Callback<FilmList>() {
            @Override
            public void onResponse(@NonNull Call<FilmList> call, @NonNull Response<FilmList> response) {
                /*For every response we need to clear list first than add*/
                filmList = null;
                if (response.isSuccessful())
                    filmList = response.body();
                if (filmList != null && filmList.getSearch() != null && filmList.getSearch().size() > 0) {
                    mView.setAdapter(filmList);
                    mView.showResultView();
                } else
                    mView.noResultView();
            }

            @Override
            public void onFailure(@NonNull Call<FilmList> call, @NonNull Throwable t) {
                mView.showErrorMessage(t.getMessage());
                mView.noResultView();
            }
        });
        Util.hideProgress();
    }


}