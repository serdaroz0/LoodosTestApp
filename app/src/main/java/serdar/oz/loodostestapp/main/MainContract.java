package serdar.oz.loodostestapp.main;

import androidx.recyclerview.widget.RecyclerView;

import serdar.oz.loodostestapp.base.BasePresenter;
import serdar.oz.loodostestapp.base.BaseView;


public interface MainContract {
    interface View extends BaseView {
        void bindViews();

        void noResultView();

        void showErrorMessage(String message);

        void initListeners();

        void showResultView();
    }

    interface Presenter extends BasePresenter {

        void setAdapter(RecyclerView recyclerView);

        void getFilmListWithQuery(String query, RecyclerView recyclerView);


    }
}
