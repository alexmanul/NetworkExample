package com.example.networkexample.network;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRepository<T> {

    private final ObservableTransformer schedulersTransformer = observable ->
            observable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

    private final Retrofit retrofit;

    public BaseRepository() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        loggingInterceptor.level(level);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://dummy.restapiexample.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    @SuppressWarnings("unchecked")
    public <Observable> ObservableTransformer<Observable, Observable> applySchedulers() {
        return schedulersTransformer;
    }
}
