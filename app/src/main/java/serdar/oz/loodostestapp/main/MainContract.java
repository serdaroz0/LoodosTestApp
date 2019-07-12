package serdar.oz.loodostestapp.main;

import serdar.oz.loodostestapp.base.BasePresenter;
import serdar.oz.loodostestapp.base.BaseView;
import serdar.oz.loodostestapp.model.MovieList;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void noResultView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();

        void notifyMovieData(MovieList movieList);
    }

    interface Presenter extends BasePresenter {


        void getMovieListWithQuery(String query);


    }
}
