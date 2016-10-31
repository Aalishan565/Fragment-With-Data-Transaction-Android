package com.fragmentwithdatatransaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by aalishan on 28/10/16.
 */
public class MovieAdapter extends BaseAdapter {
    private List<MovieModel> movieModelList;
    private Context ctx;
    private LayoutInflater inflater;

    public MovieAdapter(Context ctx, List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return movieModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_item, null);
            viewHolder.ivMovieImage = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.tvMovieName = (TextView) convertView.findViewById(R.id.tv_movie_name);
            viewHolder.tvRating = (TextView) convertView.findViewById(R.id.tv_rating);
            viewHolder.tvCategory = (TextView) convertView.findViewById(R.id.tv_category);
            viewHolder.tvMoviYear = (TextView) convertView.findViewById(R.id.tv_year);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(movieModelList.get(position).getImage(), viewHolder.ivMovieImage);
        viewHolder.tvMovieName.setText(movieModelList.get(position).getTitle());
        viewHolder.tvRating.setText(" " + movieModelList.get(position).getRating());
        viewHolder.tvCategory.setText(" " + movieModelList.get(position).getGenre());
        viewHolder.tvMoviYear.setText(" " + movieModelList.get(position).getReleaseYear());
        return convertView;
    }

    class ViewHolder {
        ImageView ivMovieImage;
        TextView tvMovieName;
        TextView tvRating;
        TextView tvCategory;
        TextView tvMoviYear;

    }
}
