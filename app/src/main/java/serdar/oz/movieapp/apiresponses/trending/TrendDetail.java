
package serdar.oz.movieapp.apiresponses.trending;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class TrendDetail {

    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("genre_ids")
    private List<Long> mGenreIds;
    @SerializedName("id")
    private Long mId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("vote_count")
    private Long mVoteCount;

    public Boolean getmAdult() {
        return mAdult;
    }

    public void setmAdult(Boolean mAdult) {
        this.mAdult = mAdult;
    }

    public String getmBackdropPath() {
        return mBackdropPath;
    }

    public void setmBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    public List<Long> getmGenreIds() {
        return mGenreIds;
    }

    public void setmGenreIds(List<Long> mGenreIds) {
        this.mGenreIds = mGenreIds;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
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

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public Double getmPopularity() {
        return mPopularity;
    }

    public void setmPopularity(Double mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Boolean getmVideo() {
        return mVideo;
    }

    public void setmVideo(Boolean mVideo) {
        this.mVideo = mVideo;
    }

    public Double getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(Double mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public Long getmVoteCount() {
        return mVoteCount;
    }

    public void setmVoteCount(Long mVoteCount) {
        this.mVoteCount = mVoteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrendDetail)) return false;
        TrendDetail trendDetail = (TrendDetail) o;
        return Objects.equals(getmAdult(), trendDetail.getmAdult()) &&
                Objects.equals(getmBackdropPath(), trendDetail.getmBackdropPath()) &&
                Objects.equals(getmGenreIds(), trendDetail.getmGenreIds()) &&
                Objects.equals(getmId(), trendDetail.getmId()) &&
                Objects.equals(getmOriginalLanguage(), trendDetail.getmOriginalLanguage()) &&
                Objects.equals(getmOriginalTitle(), trendDetail.getmOriginalTitle()) &&
                Objects.equals(getmOverview(), trendDetail.getmOverview()) &&
                Objects.equals(getmPopularity(), trendDetail.getmPopularity()) &&
                Objects.equals(getmPosterPath(), trendDetail.getmPosterPath()) &&
                Objects.equals(getmReleaseDate(), trendDetail.getmReleaseDate()) &&
                Objects.equals(getmTitle(), trendDetail.getmTitle()) &&
                Objects.equals(getmVideo(), trendDetail.getmVideo()) &&
                Objects.equals(getmVoteAverage(), trendDetail.getmVoteAverage()) &&
                Objects.equals(getmVoteCount(), trendDetail.getmVoteCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getmAdult(), getmBackdropPath(), getmGenreIds(), getmId(), getmOriginalLanguage(), getmOriginalTitle(), getmOverview(), getmPopularity(), getmPosterPath(), getmReleaseDate(), getmTitle(), getmVideo(), getmVoteAverage(), getmVoteCount());
    }

    @Override
    public String toString() {
        return "TrendDetail{" +
                "mAdult=" + mAdult +
                ", mBackdropPath='" + mBackdropPath + '\'' +
                ", mGenreIds=" + mGenreIds +
                ", mId=" + mId +
                ", mOriginalLanguage='" + mOriginalLanguage + '\'' +
                ", mOriginalTitle='" + mOriginalTitle + '\'' +
                ", mOverview='" + mOverview + '\'' +
                ", mPopularity=" + mPopularity +
                ", mPosterPath='" + mPosterPath + '\'' +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mVideo=" + mVideo +
                ", mVoteAverage=" + mVoteAverage +
                ", mVoteCount=" + mVoteCount +
                '}';
    }

}
