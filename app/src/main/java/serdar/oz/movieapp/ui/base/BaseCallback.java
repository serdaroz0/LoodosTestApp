package serdar.oz.movieapp.ui.base;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.movieapp.network.basecallback.CallbackInterface;

public class BaseCallback<T> implements Callback<T>, CallbackInterface {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccessfulResponse(response);
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
    }
}
