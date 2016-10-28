package com.fragmentwithdatatransaction;

import java.util.List;

/**
 * Created by aalishan on 28/10/16.
 */
public interface IMovieDownloadListener {
    void onMovieDownloadingSuccess(List<MovieModel> movieModels);
    void onMovieDownloadingFailure();
}
