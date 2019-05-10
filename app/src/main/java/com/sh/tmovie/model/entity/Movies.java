package com.sh.tmovie.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")

public class Movies {
    @PrimaryKey()

    @ColumnInfo(name = "id") @SerializedName(value="id") public Integer mId;
    @ColumnInfo(name = "vote_count") @SerializedName(value="vote_count") public Integer mVoteCount;
    @ColumnInfo(name = "video") @SerializedName(value="video") public Boolean mVideo;
    @ColumnInfo(name = "vote_average") @SerializedName(value="vote_average") public Float mVoteAverage;
    @ColumnInfo(name = "title") @SerializedName(value="title") public String mTitle;
    @ColumnInfo(name = "popularity") @SerializedName(value="popularity") public Float mPopularity;
    @ColumnInfo(name = "poster_path") @SerializedName(value="poster_path") public String mPosterPath;
    @ColumnInfo(name = "original_language") @SerializedName(value="original_language") public String mOriginalLanguage;
    @ColumnInfo(name = "original_title") @SerializedName(value="original_title") public String mOriginalTitle;
    @ColumnInfo(name = "backdrop_path") @SerializedName(value="backdrop_path") public String mBackdropPath;
    @ColumnInfo(name = "adult") @SerializedName(value="adult") public Boolean mAdult;
    @ColumnInfo(name = "overview") @SerializedName(value="overview") public String mOverview;
    @ColumnInfo(name = "release_date") @SerializedName(value="release_date") public String mReleaseDate;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getmVoteCount() {
        return mVoteCount;
    }

    public void setmVoteCount(Integer mVoteCount) {
        this.mVoteCount = mVoteCount;
    }

    public Boolean getmVideo() {
        return mVideo;
    }

    public void setmVideo(Boolean mVideo) {
        this.mVideo = mVideo;
    }

    public Float getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(Float mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Float getmPopularity() {
        return mPopularity;
    }

    public void setmPopularity(Float mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getmOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setmOriginalLanguage(String mOriginalLanguage) {
        this.mOriginalLanguage = mOriginalLanguage;
    }

    public String getmOriginalTitle() {
        return mOriginalTitle;
    }

    public void setmOriginalTitle(String mOriginalTitle) {
        this.mOriginalTitle = mOriginalTitle;
    }

    public String getmBackdropPath() {
        return mBackdropPath;
    }

    public void setmBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    public Boolean getmAdult() {
        return mAdult;
    }

    public void setmAdult(Boolean mAdult) {
        this.mAdult = mAdult;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }
}
