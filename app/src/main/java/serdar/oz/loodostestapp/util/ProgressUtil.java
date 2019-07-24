package serdar.oz.loodostestapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import serdar.oz.loodostestapp.R;

public class ProgressUtil {

    private static ProgressDialog progressDialog;


    public static CircularProgressDrawable createCircularProgressDrawable(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(8f);
        circularProgressDrawable.setCenterRadius(64f);
        circularProgressDrawable.setColorSchemeColors(Color.WHITE);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }


    private static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
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
        AnimationUtil.startProgressAnimation(progressDialog);
    }

    private static void createProgress(Context context) {
        progressDialog = createProgressDialog(context);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
    }
}
