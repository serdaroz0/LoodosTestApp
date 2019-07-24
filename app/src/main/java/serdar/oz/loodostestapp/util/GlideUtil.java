package serdar.oz.loodostestapp.util;

import android.content.Context;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import serdar.oz.loodostestapp.R;

public class GlideUtil {
    public static RequestOptions glideOptions(Context context) {
        return new RequestOptions()
                .placeholder(ProgressUtil.createCircularProgressDrawable(context))
                .error(R.drawable.ic_poster_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);
    }


}
