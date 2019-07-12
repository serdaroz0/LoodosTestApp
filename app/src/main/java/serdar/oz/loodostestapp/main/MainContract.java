package serdar.oz.loodostestapp.main;

import serdar.oz.loodostestapp.base.BasePresenter;
import serdar.oz.loodostestapp.base.BaseView;
import serdar.oz.loodostestapp.model.FilmList;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void noResultView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();

        void setAdapter(FilmList filmList);
    }

    interface Presenter extends BasePresenter {


        void getFilmListWithQuery(String query);


    }
}
