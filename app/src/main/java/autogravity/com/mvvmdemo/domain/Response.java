package autogravity.com.mvvmdemo.domain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Response<T> {
    @NonNull public final Status status;
    @Nullable public final T data;
    @Nullable public final String message;

    private Response(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Response<T> success(@NonNull T data) {
        return new Response<>(Status.SUCCESS, data, null);
    }

    public static <T> Response<T> error(String msg, @Nullable T data) {
        return new Response<>(Status.ERROR, data, msg);
    }

    public static <T> Response<T> loading(@Nullable T data) {
        return new Response<>(Status.LOADING, data, null);
    }
}
