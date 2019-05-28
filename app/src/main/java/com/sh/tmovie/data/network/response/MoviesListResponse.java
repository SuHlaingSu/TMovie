package com.sh.tmovie.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.sh.tmovie.data.room.entity.Movies;

import java.util.List;

/**
 * Created by Su Hlaing on 10/5/2019.
 */

public class MoviesListResponse {
    @SerializedName("results")
    private List<Movies> results;
    @SerializedName("total_pages")
    private int total_pages;

    public List<Movies> getResults() {
        return results;
    }

    public void setResults(List<Movies> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
