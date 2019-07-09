package serdar.oz.loodostestapp.main;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.loodostestapp.Constants;
import serdar.oz.loodostestapp.model.FilmList;
import serdar.oz.loodostestapp.services.RetrofitClient;
import serdar.oz.loodostestapp.services.SearchApi;
import serdar.oz.loodostestapp.util.Util;

import static serdar.oz.loodostestapp.Constants.GRID_SPAN_COUNT;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private Context context;
    private FilmList filmList;
    private GridLayoutManager gridLayoutManager;

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
    public void setAdapter(RecyclerView recyclerView) {
        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(context, GRID_SPAN_COUNT, RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        }
        FilmListAdapter filmListAdapter = new FilmListAdapter(context, filmList.getSearch());
        recyclerView.setAdapter(filmListAdapter); // set the Adapter to RecyclerView
    }


    @Override
    public void getFilmListWithQuery(String query, RecyclerView recyclerView) {
        Util.showProgress(context);
        SearchApi searchApi = RetrofitClient.getApiClient().create(SearchApi.class);
        Call<FilmList> call = searchApi.getFilmList(query, Constants.API_KEY);
        call.enqueue(new Callback<FilmList>() {
            @Override
            public void onResponse(Call<FilmList> call, Response<FilmList> response) {
                filmList = null;
                if (response.isSuccessful())
                    filmList = response.body();
                if (filmList != null && filmList.getSearch() != null && filmList.getSearch().size() > 0) {
                    setAdapter(recyclerView);
                    mView.showResultView();
                } else
                    mView.noResultView();
            }

            @Override
            public void onFailure(Call<FilmList> call, Throwable t) {
                mView.showErrorMessage(t.getMessage());
                mView.noResultView();
            }
        });
        Util.hideProgress();
    }


}