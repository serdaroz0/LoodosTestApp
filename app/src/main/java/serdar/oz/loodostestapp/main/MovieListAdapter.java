package serdar.oz.loodostestapp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.util.Util;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private final List<MovieList.Type> movieList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView ivPoster;
        final TextView tvTitle;
        final TextView tvType;
        final TextView tvYear;

        private ViewHolder(View v) {
            super(v);
            this.ivPoster = v.findViewById(R.id.ivPoster);
            this.tvTitle = v.findViewById(R.id.tvTitle);
            this.tvType = v.findViewById(R.id.tvType);
            this.tvYear = v.findViewById(R.id.tvYear);
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (movieList == null) ? 0 : movieList.size();
    }

}
