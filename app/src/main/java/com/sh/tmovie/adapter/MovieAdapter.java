package com.sh.tmovie.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh.tmovie.R;
import com.sh.tmovie.data.room.entity.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.sh.tmovie.utilis.Constants.SMALL_IMAGE_URL_PREFIX;

public class MovieAdapter extends PagedListAdapter<Movies,MovieAdapter.ViewHolder> implements AdapterView.OnItemClickListener {

    Context context;
    List<Movies> moviesList;

   /* public MovieAdapter(Context ctx,List<Movies> moviesList) {
        this.context = ctx;
        this.moviesList = moviesList;
    }*/

    public MovieAdapter(@NonNull DiffUtil.ItemCallback<Movies> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movies movies = moviesList.get(position);
        viewHolder.titleTextView.setText(movies.getmTitle());
        viewHolder.userRatingTextView.setText("Rating : " + String.format("%1$,.2f", movies.getmVoteAverage()));
        if(movies.getmPosterPath() != null) {
            String poster = SMALL_IMAGE_URL_PREFIX + movies.getmPosterPath();
            Picasso.get().load(poster).into(viewHolder.imageView);
        }
       /* GlideApp.with(context)
                .load(movies.getPoster_path())
                //.placeholder(R.drawable.placeholder)
                .override(600, 600)
                .into(viewHolder.imageView);*/
       /* Picasso.get()
                .load(movies.getResult().getPoster_path())
               // .placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(viewHolder.imageView);
*/

    }

    private  static DiffUtil.ItemCallback<Movies> diff_callback = new DiffUtil.ItemCallback<Movies>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movies oldItem, @NonNull Movies newItem) {
            return oldItem.mOriginalTitle == newItem.mOriginalTitle;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Movies oldItem, @NonNull Movies newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView userRatingTextView;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView =  itemView.findViewById(R.id.thumbnail);
            titleTextView= itemView.findViewById(R.id.title);
            userRatingTextView = itemView.findViewById(R.id.userrating);

        }
    }
}
