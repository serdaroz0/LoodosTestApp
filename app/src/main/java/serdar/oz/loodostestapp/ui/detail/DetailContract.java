package serdar.oz.loodostestapp.ui.detail;

import serdar.oz.loodostestapp.apiresponses.movieDetail.MovieDetail;
import serdar.oz.loodostestapp.ui.base.BasePresenter;
import serdar.oz.loodostestapp.ui.base.BaseView;


public interface DetailContract {

    interface View extends BaseView {

        void initListeners();

        void onActivityPause();

        void onActivityDestroy();

        void loadData(MovieDetail movieDetail);

        void loadPlaceholder();

    }

    interface Presenter extends BasePresenter {

        void getPosterData();

        void onBackButtonPressed();

    }
}
