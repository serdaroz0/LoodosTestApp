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
import serdar.oz.loodostestapp.model.FilmList;
import serdar.oz.loodostestapp.util.Util;


public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {
    private final Context context;
    private final List<FilmList.Type> filmList;

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

    FilmListAdapter(Context context, List<FilmList.Type> filmList) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (filmList == null) ? 0 : filmList.size();
    }

}
