package serdar.oz.movieapp.network.basecallback;

import retrofit2.Response;

public interface CallbackInterface<T> {

    default void onSuccessfulResponse(Response<T> response) {
    }

    default void onBadRequest() {
    }

    default void onServerError(Response response) {
    }

    default void onUnAuthorized() {
    }

    default void onForbidden() {
    }

    default void onFailure(boolean cancelled) {
    }

    default void onEverytime() {
    }
}


