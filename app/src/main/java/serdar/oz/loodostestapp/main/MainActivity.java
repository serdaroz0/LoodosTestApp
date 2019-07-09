package serdar.oz.loodostestapp.main;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.base.BaseActivity;
import serdar.oz.loodostestapp.util.Util;

import static serdar.oz.loodostestapp.Constants.QUERY_MIN_LIMIT;

public class MainActivity extends BaseActivity implements MainContract.View {
    private static final String TAG = "MainActivity";
    @BindView(R.id.svSearch)
    SearchView svSearch;
    @BindView(R.id.rvSearchItems)
    RecyclerView rvSearchItems;
    @BindView(R.id.llNoResult)
    LinearLayout llNoResult;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.created();
        /*Service response is coming very fast, I open showProgress() method so we can see the progress design.*/
        Util.showProgress(MainActivity.this);
        new Handler().postDelayed(Util::hideProgress, 1200);

    }

    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }


    @Override
    public void noResultView() {
        llNoResult.setVisibility(View.VISIBLE);
        rvSearchItems.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initListeners() {
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.e(TAG, "onClick: " + "clicked");
                /*If the limit is less than 2 character, an error message is return because a lot of results are returned than api*/
                if (s.length() > QUERY_MIN_LIMIT)
                    mainPresenter.getFilmListWithQuery(s, rvSearchItems);
                else
                    noResultView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public void showResultView() {
        llNoResult.setVisibility(View.GONE);
        rvSearchItems.setVisibility(View.VISIBLE);
    }

}
