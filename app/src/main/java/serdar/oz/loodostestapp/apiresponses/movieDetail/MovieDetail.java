
package serdar.oz.loodostestapp.apiresponses.movieDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class MovieDetail {

    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("belongs_to_collection")
    private Object mBelongsToCollection;
    @SerializedName("budget")
    private Long mBudget;
    @SerializedName("genres")
    private List<Genre> mGenres;
    @SerializedName("homepage")
    private String mHomepage;
    @SerializedName("id")
    private Long mId;
    @SerializedName("imdb_id")
    private String mImdbId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("poster_path")
    private Object mPosterPath;
    @SerializedName("production_companies")
    private List<ProductionCompany> mProductionCompanies;
    @SerializedName("production_countries")
    private List<ProductionCountry> mProductionCountries;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("revenue")
    private Long mRevenue;
    @SerializedName("runtime")
    private Long mRuntime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguages;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("tagline")
    private String mTagline;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("vote_count")
    private Long mVoteCount;

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public Object getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        mBelongsToCollection = belongsToCollection;
    }

    public Long getBudget() {
        return mBudget;
    }

    public void setBudget(Long budget) {
        mBudget = budget;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public void setHomepage(String homepage) {
        mHomepage = homepage;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setImdbId(String imdbId) {
        mImdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public Object getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(Object posterPath) {
        mPosterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return mProductionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        mProductionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return mProductionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        mProductionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public Long getRevenue() {
        return mRevenue;
    }

    public void setRevenue(Long revenue) {
        mRevenue = revenue;
    }

    public Long getRuntime() {
        return mRuntime;
    }

    public void setRuntime(Long runtime) {
        mRuntime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return mSpokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        mSpokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTagline() {
        return mTagline;
    }

    public void setTagline(String tagline) {
        mTagline = tagline;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public Long getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Long voteCount) {
        mVoteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDetail)) return false;
        MovieDetail that = (MovieDetail) o;
        return Objects.equals(mAdult, that.mAdult) &&
                Objects.equals(mBackdropPath, that.mBackdropPath) &&
                Objects.equals(mBelongsToCollection, that.mBelongsToCollection) &&
                Objects.equals(mBudget, that.mBudget) &&
                Objects.equals(mGenres, that.mGenres) &&
                Objects.equals(mHomepage, that.mHomepage) &&
                Objects.equals(mId, that.mId) &&
                Objects.equals(mImdbId, that.mImdbId) &&
                Objects.equals(mOriginalLanguage, that.mOriginalLanguage) &&
                Objects.equals(mOriginalTitle, that.mOriginalTitle) &&
                Objects.equals(mOverview, that.mOverview) &&
                Objects.equals(mPopularity, that.mPopularity) &&
                Objects.equals(mPosterPath, that.mPosterPath) &&
                Objects.equals(mProductionCompanies, that.mProductionCompanies) &&
                Objects.equals(mProductionCountries, that.mProductionCountries) &&
                Objects.equals(mReleaseDate, that.mReleaseDate) &&
                Objects.equals(mRevenue, that.mRevenue) &&
                Objects.equals(mRuntime, that.mRuntime) &&
                Objects.equals(mSpokenLanguages, that.mSpokenLanguages) &&
                Objects.equals(mStatus, that.mStatus) &&
                Objects.equals(mTagline, that.mTagline) &&
                Objects.equals(mTitle, that.mTitle) &&
                Objects.equals(mVideo, that.mVideo) &&
                Objects.equals(mVoteAverage, that.mVoteAverage) &&
                Objects.equals(mVoteCount, that.mVoteCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mAdult, mBackdropPath, mBelongsToCollection, mBudget, mGenres, mHomepage, mId, mImdbId, mOriginalLanguage, mOriginalTitle, mOverview, mPopularity, mPosterPath, mProductionCompanies, mProductionCountries, mReleaseDate, mRevenue, mRuntime, mSpokenLanguages, mStatus, mTagline, mTitle, mVideo, mVoteAverage, mVoteCount);
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mBelongsToCollection=" + mBelongsToCollection +
                ", mBudget=" + mBudget +
                ", mGenres=" + mGenres +
                ", mHomepage='" + mHomepage + '\'' +
                ", mId=" + mId +
                ", mImdbId='" + mImdbId + '\'' +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath=" + mPosterPath +
                ", mProductionCompanies=" + mProductionCompanies +
                ", mProductionCountries=" + mProductionCountries +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mRevenue=" + mRevenue +
                ", mRuntime=" + mRuntime +
                ", mSpokenLanguages=" + mSpokenLanguages +
                ", mStatus='" + mStatus + '\'' +
                ", mTagline='" + mTagline + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mVideo=" + mVideo +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                '}';
    }
}
