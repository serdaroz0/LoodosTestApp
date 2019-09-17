package serdar.oz.movieapp.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.movieapp.R;
import serdar.oz.movieapp.apiresponses.trending.TrendDetail;
import serdar.oz.movieapp.constants.NetworkConstants;
import serdar.oz.movieapp.util.GlideUtil;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private final List<TrendDetail> trendingList;
    private final IMovieAdapter iMovieAdapter;


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivPoster)
        ImageView ivPoster;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvYear)
        TextView tvYear;
        @BindView(R.id.cvMovie)
        CardView cvMovie;
        @BindView(R.id.progressBar)
        ProgressBar progressBar;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

    public MovieListAdapter(Context context, List<TrendDetail> trendingList, IMovieAdapter iMovieAdapter) {
        this.trendingList = trendingList;
        this.iMovieAdapter = iMovieAdapter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        TrendDetail trend = trendingList.get(position);
        try {
            if (trend.getmPosterPath() != null && !trend.getmPosterPath().isEmpty())
                GlideUtil.loadImage(trend.getmPosterPath(), holder.ivPoster, holder.progressBar);
            Glide.with(context).applyDefaultRequestOptions(GlideUtil.glideOptions(context)).load(NetworkConstants.PHOTO_URL + trend.getmPosterPath()).into(holder.ivPoster);
            holder.tvTitle.setText(trend.getmTitle());
            holder.tvType.setText(trend.getmOverview());
            holder.tvYear.setText(trend.getmOriginalLanguage().toUpperCase());
            holder.cvMovie.setOnClickListener(view -> iMovieAdapter.onMovieItemClicked(trend.getmId(), holder.ivPoster));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (trendingList == null) ? 0 : trendingList.size();
    }
}
