package serdar.oz.movieapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static serdar.oz.movieapp.constants.NetworkConstants.BASE_URL;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retrofit;
    }


}
