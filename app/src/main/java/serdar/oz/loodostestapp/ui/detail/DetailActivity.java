package serdar.oz.loodostestapp.ui.detail;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.constants.GlobalConstants;
import serdar.oz.loodostestapp.util.GlideUtil;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
    DetailPresenter detailPresenter;
    String imdbId;
    @BindView(R.id.ivPoster)
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null)
            imdbId = getIntent().getStringExtra(GlobalConstants.IMDB_ID);
        else
            imdbId = null;
        detailPresenter = new DetailPresenter(this, this, imdbId);
        detailPresenter.created();

    }

    @Override
    public void initListeners() {

    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityDestroy() {

    }

    @Override
    public void loadPoster(String link) {
        Log.e(getClass().getName(), "loadPoster: " + link);
        Glide.with(this).applyDefaultRequestOptions(GlideUtil.glideOptions(this)).load(link).into(ivPoster);
    }

    @Override
    public void loadPlaceholder() {
        ivPoster.setImageResource(R.drawable.ic_poster_placeholder);
    }

    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }
}
