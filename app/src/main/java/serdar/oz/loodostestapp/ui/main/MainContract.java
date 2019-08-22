package serdar.oz.loodostestapp.ui.main;

import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.ui.base.BasePresenter;
import serdar.oz.loodostestapp.ui.base.BaseView;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void noResultView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();

        void notifyMovieData(MovieList movieList);

        void onMovieItemClicked(String imdbId, android.view.View view);

    }

    interface Presenter extends BasePresenter {

        void getMovieListWithQuery(String query);

        void startDetailActivity(String imdbId, android.view.View view);



    }
}
