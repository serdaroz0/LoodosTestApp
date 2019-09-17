package serdar.oz.movieapp.ui.detail;

import serdar.oz.movieapp.apiresponses.movieDetail.MovieDetail;
import serdar.oz.movieapp.ui.base.BasePresenter;
import serdar.oz.movieapp.ui.base.BaseView;


public interface DetailContract {

    interface View extends BaseView {

        void initListeners();

        void loadData(MovieDetail movieDetail);

        void loadPlaceholder();

    }

    interface Presenter extends BasePresenter {

        void getPosterData();

        void onBackButtonPressed();

    }
}
