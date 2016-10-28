package com.fragmentwithdatatransaction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by aalishan on 27/10/16.
 */
public class FragmentDetailVIew extends Fragment {
    private View mRootView;
    static FragmentDetailVIew fragmentDetailVIew;
    private MovieModel movieModel;
    private ImageView ivMovieImage;
    private TextView tvMovieName;
    private TextView tvRating;
    private TextView tvCategory;
    private TextView tvMoviYear;

    public static Fragment newInstance() {
        // Bundle bundle=new Bundle();
        // bundle.putString("arg1",arg1);
        // bundle.putInt("arg2",arg2);
        fragmentDetailVIew = new FragmentDetailVIew();
        //fragment.setArguments(bundle);
        return fragmentDetailVIew;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            movieModel = getArguments().getParcelable("Item_clicked");
            if (movieModel != null) {
                tvMovieName.setText(movieModel.getTitle());
                tvRating.setText(String.valueOf(movieModel.getRating()));
//                tvCategory.setText((CharSequence) movieModel.getGenre());
                tvMoviYear.setText(String.valueOf(movieModel.getReleaseYear()));
              //  Bitmap bitmap = BitmapFactory.decodeFile(new File(movieModel.getImage()));
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_item_detail, null);
        ivMovieImage = (ImageView) mRootView.findViewById(R.id.iv_image);
        tvMovieName = (TextView) mRootView.findViewById(R.id.tv_movie_name);
        tvRating = (TextView) mRootView.findViewById(R.id.tv_rating);
        tvCategory = (TextView) mRootView.findViewById(R.id.tv_category);
        tvMoviYear = (TextView) mRootView.findViewById(R.id.tv_year);
        return mRootView;
    }
}
