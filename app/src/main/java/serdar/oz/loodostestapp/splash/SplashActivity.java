package serdar.oz.loodostestapp.splash;

import android.animation.Animator;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.base.BaseActivity;
import serdar.oz.loodostestapp.control.NetworkChangeReceiver;
import serdar.oz.loodostestapp.control.TypeWriter;

import static android.content.ContentValues.TAG;
import static serdar.oz.loodostestapp.Constants.SPLASH_DELAY;

public class SplashActivity extends BaseActivity implements SplashContract.View {
    @BindView(R.id.ivSplashIcon)
    ImageView ivSplashIcon;
    @BindView(R.id.tvSplashText)
    TypeWriter tvSplashText;
    private SplashPresenter mSplashPresenter;
    private NetworkChangeReceiver mNetworkChangeReceiver;
    private Animator.AnimatorListener animatorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashPresenter = new SplashPresenter(this, this);
        mSplashPresenter.created();
        mNetworkChangeReceiver = mSplashPresenter.registerReceiver(this, mSplashPresenter.checkNetworkState());
    }


    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }

    @Override
    public void fetchSuccessMessage() {
        Log.e(TAG, "fetchSuccessMessage: " + "succes");
    }

    @Override
    public void fetchFailedMessage() {
        Log.e(TAG, "fetchFailedMessage: " + "fail");

    }

    @Override
    public void onSplashAnimationEnd() {
        mSplashPresenter.startMainActivity();
    }

    @Override
    public void internetErrorLayout() {
        setContentView(R.layout.no_internet_layout);
    }

    @Override
    public void initListeners() {
        animatorListener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                onSplashAnimationEnd();
                Log.e(TAG, "onAnimationEnd: " + " mView.onSplashAnimationEnd()");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };
    }

    @Override
    public void setSplashTextAndStartAnimation(String string) {
        //Add a character every 150ms
        tvSplashText.setText(string);
        tvSplashText.setCharacterDelay(200);
        tvSplashText.animateText(string);
        YoYo.with(Techniques.FadeIn)
                .duration(SPLASH_DELAY)
                .withListener(animatorListener)
                .playOn(ivSplashIcon);

    }


    @Override
    protected void onPause() {
        super.onPause();
        mSplashPresenter.unregisterReceiver(this, mNetworkChangeReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSplashPresenter.unregisterReceiver(this, mNetworkChangeReceiver);
    }
}
