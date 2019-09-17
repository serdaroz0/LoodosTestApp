package serdar.oz.movieapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import serdar.oz.movieapp.R;
import serdar.oz.movieapp.constants.NetworkConstants;

public class GlideUtil {

    public static void loadImage(String posterPath, ImageView imageView , ProgressBar progressBar) {
        Glide.with(imageView.getContext()).applyDefaultRequestOptions(GlideUtil.glideOptions(imageView.getContext())).load(NetworkConstants.PHOTO_URL + posterPath).listener(
                new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
             progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);
    }


    public static RequestOptions glideOptions(Context context) {
        return new RequestOptions()
                .placeholder(ProgressUtil.createCircularProgressDrawable(context))
                .error(R.drawable.ic_poster_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.NORMAL);
    }


}
