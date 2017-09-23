package com.example.amitgupta10.dragdroplist;

/**
 * Created by amit.gupta10 on 06/04/16.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> mMovies;

    public MovieAdapter(Context context, List<Movie> movies){
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void remove(int position) {
        mMovies.remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition){
        Collections.swap(mMovies, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView movieNameTextView;

        public ViewHolder(View view){
            super(view);
            movieNameTextView = (TextView) view.findViewById(R.id.movie_name);
        }

        public void bindMovie(Movie movie){
            this.movieNameTextView.setText(movie.getName());
        }
    }
}
