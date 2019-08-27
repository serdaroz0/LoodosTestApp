package serdar.oz.loodostestapp.ui.main;

import serdar.oz.loodostestapp.apiresponses.trending.Trending;
import serdar.oz.loodostestapp.ui.base.BasePresenter;
import serdar.oz.loodostestapp.ui.base.BaseView;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void noResultView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();

        void notifyMovieData(Trending trendingList);

        void onMovieItemClicked(long mId, android.view.View view);


    }

    interface Presenter extends BasePresenter {

        void getTrendList();

        void startDetailActivity(long mId, android.view.View view);

        void loadMoreTrendingData();


    }
}
