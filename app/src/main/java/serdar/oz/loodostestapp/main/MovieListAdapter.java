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
import serdar.oz.loodostestapp.model.FilmList;
import serdar.oz.loodostestapp.util.Util;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private final List<FilmList.Type> filmList;
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

    MovieListAdapter(Context context, List<FilmList.Type> filmList) {
        this.filmList = filmList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.film_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        FilmList.Type film = filmList.get(position);
        try {
            if (film.getPoster() != null && !film.getPoster().isEmpty())
                Glide.with(context).applyDefaultRequestOptions(Util.glideOptions(context)).load(film.getPoster()).into(holder.ivPoster);
            holder.tvTitle.setText(film.getTitle());
            holder.tvType.setText(film.getYear());
            holder.tvYear.setText(film.getType().toUpperCase());
            iMovieAdapter = new IMovieAdapter() {
                @Override
                public void onMovieClicked() {

                }
            };
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (filmList == null) ? 0 : filmList.size();
    }

    @OnClick(R.id.cvMovie)
    private void onMovieClick() {
        iMovieAdapter.onMovieClicked();
    }
}
