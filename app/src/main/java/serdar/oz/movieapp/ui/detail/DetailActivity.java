package serdar.oz.movieapp.ui.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import serdar.oz.movieapp.R;
import serdar.oz.movieapp.apiresponses.movieDetail.MovieDetail;
import serdar.oz.movieapp.constants.GlobalConstants;
import serdar.oz.movieapp.constants.NetworkConstants;
import serdar.oz.movieapp.util.GlideUtil;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    DetailPresenter detailPresenter;
    long mId;
    @BindView(R.id.ivPoster)
    ImageView ivPoster;
    @BindView(R.id.rbStar)
    RatingBar rbStar;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
   /* @BindView(R.id.ibBack)
    ImageButton ibBackButton;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null)
            mId = getIntent().getLongExtra(GlobalConstants.IMDB_ID, 0);
        detailPresenter = new DetailPresenter(this, this, mId);
        detailPresenter.created();
    }

    @Override
    public void initListeners() {
    }

    @Override
    public void loadData(MovieDetail movieDetail) {
        tvTitle.setText(movieDetail.getTitle());
        Glide.with(this).applyDefaultRequestOptions(GlideUtil.glideOptions(this)).load(NetworkConstants.PHOTO_URL + movieDetail.getPosterPath()).into(ivPoster);
        rbStar.setRating(movieDetail.getVoteAverage().floatValue());
    }


    @Override
    public void loadPlaceholder() {
        ivPoster.setImageResource(R.drawable.ic_poster_placeholder);
    }


    @OnClick(R.id.ibBack)
    public void backPressed() {
        detailPresenter.onBackButtonPressed();
    }

    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }
}
