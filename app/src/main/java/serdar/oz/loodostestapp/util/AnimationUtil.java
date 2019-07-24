package serdar.oz.loodostestapp.util;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;

import java.util.Objects;

import serdar.oz.loodostestapp.R;

public class AnimationUtil {

    public static void startProgressAnimation(ProgressDialog pd) {
        Objects.requireNonNull(pd.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        AnimationDrawable ad = (AnimationDrawable) (pd.findViewById(R.id.ivLoading)).getBackground();
        ad.start();
    }
}
