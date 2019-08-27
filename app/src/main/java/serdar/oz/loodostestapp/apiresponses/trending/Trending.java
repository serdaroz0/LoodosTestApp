
package serdar.oz.loodostestapp.apiresponses.trending;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Trending {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<TrendDetail> mTrendDetails;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_results")
    private Long mTotalResults;

    public Long getmPage() {
        return mPage;
    }

    public void setmPage(Long mPage) {
        this.mPage = mPage;
    }

    public List<TrendDetail> getmTrendDetails() {
        return mTrendDetails;
    }

    public void setmTrendDetails(List<TrendDetail> mTrendDetails) {
        this.mTrendDetails = mTrendDetails;
    }

    public Long getmTotalPages() {
        return mTotalPages;
    }

    public void setmTotalPages(Long mTotalPages) {
        this.mTotalPages = mTotalPages;
    }

    public Long getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(Long mTotalResults) {
        this.mTotalResults = mTotalResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trending)) return false;
        Trending trending = (Trending) o;
        return Objects.equals(getmPage(), trending.getmPage()) &&
                Objects.equals(getmTrendDetails(), trending.getmTrendDetails()) &&
                Objects.equals(getmTotalPages(), trending.getmTotalPages()) &&
                Objects.equals(getmTotalResults(), trending.getmTotalResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getmPage(), getmTrendDetails(), getmTotalPages(), getmTotalResults());
    }

    @Override
    public String toString() {
        return "Trending{" +
                "mPage=" + mPage +
                ", mTrendDetails=" + mTrendDetails +
                ", mTotalPages=" + mTotalPages +
                ", mTotalResults=" + mTotalResults +
                '}';
    }


}
