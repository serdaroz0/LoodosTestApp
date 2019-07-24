package serdar.oz.loodostestapp.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import serdar.oz.loodostestapp.model.Detail;

public interface DetailApi {
    @GET("?")
    Call<Detail> getDetail(@Query("i") String imdbId, @Query("apikey") String apikey);
}
