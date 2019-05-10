package com.sh.tmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh.tmovie.JsonResponse.MoviesResponse;
import com.sh.tmovie.R;
import com.sh.tmovie.model.entity.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.sh.tmovie.utilis.Constants.SMALL_IMAGE_URL_PREFIX;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements AdapterView.OnItemClickListener {

    Context context;
    List<MoviesResponse> moviesList;

    public MovieAdapter(Context ctx,List<MoviesResponse> moviesList) {
        this.context = ctx;
        this.moviesList = moviesList;
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
        MoviesResponse movies = moviesList.get(position);
        viewHolder.titleTextView.setText(movies.getResults().get(position).getmTitle());
        viewHolder.userRatingTextView.setText("Rating : " + String.format("%1$,.2f", movies.getResults().get(position).getmVoteAverage()));
        if(movies.getResults().get(position).getmPosterPath() != null) {
            String poster = SMALL_IMAGE_URL_PREFIX + movies.getResults().get(position).getmPosterPath();
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
