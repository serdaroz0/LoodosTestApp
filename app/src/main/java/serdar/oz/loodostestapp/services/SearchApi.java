package serdar.oz.loodostestapp.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import serdar.oz.loodostestapp.model.MovieList;

public interface SearchApi {
    @GET("?")
    Call<MovieList> getMovieList(@Query("s") String name, @Query("apikey") String apikey);
}
