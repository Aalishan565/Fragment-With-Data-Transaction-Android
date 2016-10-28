package com.fragmentwithdatatransaction;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by aalishan on 27/10/16.
 */
public class FragmentItemList extends Fragment implements IMovieDownloadListener {
    private View mRootView;
    private ListView mListMovies;
    private ProgressDialog mProgressDialog;
    private MovieAdapter mMovieAdapter;
    MovieModel movieModels;
    public static final String MOVIES_URL = "http://api.androidhive.info/json/movies.json";
    static FragmentItemList fragmentItemList;

    public static Fragment newInstance() {
        // Bundle bundle=new Bundle();
        // bundle.putString("arg1",arg1);
        // bundle.putInt("arg2",arg2);
        fragmentItemList = new FragmentItemList();
        //fragment.setArguments(bundle);
        return fragmentItemList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_movie_list, null);
        mListMovies = (ListView) mRootView.findViewById(R.id.lv_movies);
        movieModels = new MovieModel();
        mListMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                movieModels = (MovieModel) mListMovies.getAdapter().getItem(position);
                b.putParcelable("Item_clicked", movieModels);
                ((MainActivity) getActivity()).detailFragment(b);


            }
        });

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MovieDataDownloadingAsyncTask(this).execute(MOVIES_URL);
    }

    @Override
    public void onMovieDownloadingSuccess(List<MovieModel> movieModels) {
        mMovieAdapter = new MovieAdapter(getActivity(), movieModels);
        mListMovies.setAdapter(mMovieAdapter);
        mProgressDialog.dismiss();
    }

    @Override
    public void onMovieDownloadingFailure() {
        mProgressDialog.dismiss();
    }
}
