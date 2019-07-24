package serdar.oz.loodostestapp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.util.Util;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private final List<MovieList.Type> movieList;
    private IMovieAdapter iMovieAdapter;

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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    MovieListAdapter(Context context, List<MovieList.Type> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MovieList.Type movie = movieList.get(position);
        try {
            if (movie.getPoster() != null && !movie.getPoster().isEmpty())
                Glide.with(context).applyDefaultRequestOptions(Util.glideOptions(context)).load(movie.getPoster()).into(holder.ivPoster);
            holder.tvTitle.setText(movie.getTitle());
            holder.tvType.setText(movie.getYear());
            holder.tvYear.setText(movie.getType().toUpperCase());
            iMovieAdapter = new IMovieAdapter() {
                @Override
                public void onAdapterMovieClicked() {

                }
            };
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (movieList == null) ? 0 : movieList.size();
    }

    @OnClick(R.id.cvMovie)
    public void onMovieClick() {
        iMovieAdapter.onAdapterMovieClicked();
    }
}
