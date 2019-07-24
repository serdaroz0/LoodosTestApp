package serdar.oz.loodostestapp.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import serdar.oz.loodostestapp.model.FilmList;

public interface SearchApi {
    @GET("?")
    Call<FilmList> getFilmList(@Query("s") String name, @Query("apikey") String apikey);
}
