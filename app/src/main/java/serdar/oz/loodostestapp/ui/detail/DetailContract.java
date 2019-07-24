package serdar.oz.loodostestapp.ui.detail;

import serdar.oz.loodostestapp.ui.base.BasePresenter;
import serdar.oz.loodostestapp.ui.base.BaseView;


public interface DetailContract {

    interface View extends BaseView {

        void initListeners();

        void onActivityPause();

        void onActivityDestroy();

        void loadPoster(String link);


        void loadPlaceholder();
    }

    interface Presenter extends BasePresenter {

        void getPosterData();
    }
}
