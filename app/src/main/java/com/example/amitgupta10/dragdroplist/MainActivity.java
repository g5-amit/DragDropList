package com.example.amitgupta10.dragdroplist;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context mContext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        // Setup RecyclerView
        RecyclerView movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,3, GridLayoutManager.HORIZONTAL,true);

        movieRecyclerView.setLayoutManager(linearLayoutManager);

        // Setup Adapter
        MovieAdapter movieAdapter = new MovieAdapter(this, getMovies());
        movieRecyclerView.setAdapter(movieAdapter);

        // Setup ItemTouchHelper
        ItemTouchHelper.Callback callback = new MovieTouchHelper(movieAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(movieRecyclerView);
    }

    private List<Movie> getMovies(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry Potter"));
        movieList.add(new Movie("Twilight"));
        movieList.add(new Movie("Star Wars"));
        movieList.add(new Movie("Star Trek"));
        movieList.add(new Movie("Galaxy Quest"));
        movieList.add(new Movie("Harry Potter1"));
        movieList.add(new Movie("Twilight1"));
        movieList.add(new Movie("Star Wars1"));
        movieList.add(new Movie("Star Trek1"));
        movieList.add(new Movie("Galaxy Quest1"));
        movieList.add(new Movie("Harry Potter2"));
        movieList.add(new Movie("Twilight2"));
        movieList.add(new Movie("Star Wars2"));
        movieList.add(new Movie("Star Trek2"));
        movieList.add(new Movie("Galaxy Quest2"));
        movieList.add(new Movie("Harry Potter3"));
        movieList.add(new Movie("Twilight3"));
        movieList.add(new Movie("Star Wars3"));
        movieList.add(new Movie("Star Trek3"));
        movieList.add(new Movie("Galaxy Quest3"));
        return movieList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}