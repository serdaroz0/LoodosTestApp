package serdar.oz.loodostestapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import serdar.oz.loodostestapp.Constants;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return retrofit;
    }


}
