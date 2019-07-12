package serdar.oz.loodostestapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

import serdar.oz.loodostestapp.R;


public class Util {

    private static ProgressDialog progressDialog;


    private static void startProgressAnimation(ProgressDialog pd) {
        Objects.requireNonNull(pd.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        AnimationDrawable ad = (AnimationDrawable) (pd.findViewById(R.id.ivLoading)).getBackground();
        ad.start();
    }

    private static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static RequestOptions glideOptions(Context context) {
        return new RequestOptions()
                .placeholder(Util.createCircularProgressDrawable(context))
                .error(R.drawable.ic_poster_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);
    }

    private static CircularProgressDrawable createCircularProgressDrawable(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(8f);
        circularProgressDrawable.setCenterRadius(64f);
        circularProgressDrawable.setColorSchemeColors(Color.WHITE);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    public static void hideProgress() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    public static void showProgress(Context context) {
        if (progressDialog == null) {
            createProgress(context);
        } else {
            if (!progressDialog.getContext().getClass().equals(context.getClass())) {
                progressDialog.dismiss();
                createProgress(context);
            } else
                progressDialog.show();
        }
        Util.startProgressAnimation(progressDialog);
    }

    private static void createProgress(Context context) {
        progressDialog = Util.createProgressDialog(context);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
    }

}
