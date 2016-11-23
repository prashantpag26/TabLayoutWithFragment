package com.indianic.tablayoutwithfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by indianic on 23/11/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    private List<Movie> moviesList;
    private UpdateInterface updateInterface;
    private Context context;

    @Override
    public void onClick(View view) {
        final Utils utils = new Utils(context);
        int i = utils.getInt("int");
        utils.putInt("int", i + 1);
        updateInterface.updateData();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.firstLine);
            genre = (TextView) view.findViewById(R.id.secondLine);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }


    public MyAdapter(List<Movie> moviesList, Onefragment onefragment) {
        this.moviesList = moviesList;
        updateInterface = onefragment;
        context = onefragment.getActivity();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.icon.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}