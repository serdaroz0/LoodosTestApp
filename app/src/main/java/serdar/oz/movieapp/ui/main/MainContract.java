package serdar.oz.movieapp.ui.main;

import serdar.oz.movieapp.apiresponses.trending.Trending;
import serdar.oz.movieapp.ui.base.BasePresenter;
import serdar.oz.movieapp.ui.base.BaseView;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void emptyView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();

        void notifyMovieData(Trending trendingList);

    }

    interface Presenter extends BasePresenter {

        void getTrendList();

        void startDetailActivity(long mId, android.view.View view);

        void loadMoreTrendingData();


    }
}
