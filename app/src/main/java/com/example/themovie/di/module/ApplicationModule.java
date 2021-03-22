package com.example.themovie.di.module;

import com.example.themovie.api.TheMovieApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.themovie.utils.Constants.BASE_URL;
import static com.example.themovie.utils.Constants.THE_MOVIE_API_KEY;

@Module
public class ApplicationModule {

    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    }

    @Provides
    public Call.Factory provideCallFactory(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", THE_MOVIE_API_KEY)
                    .build();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return builder.addInterceptor(httpLoggingInterceptor).build();
    }

    @Provides
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    public RxJava3CallAdapterFactory provideRxJava3CallAdapterFactory() {
        return RxJava3CallAdapterFactory.create();
    }

    @Provides
    public Retrofit provideRetrofit(
            Call.Factory httpLoggingInterceptor,
            GsonConverterFactory gsonConverterFactory,
            RxJava3CallAdapterFactory rxJava3CallAdapterFactory
    ) {

        Retrofit.Builder builder = new Retrofit.Builder();

        return builder.baseUrl(BASE_URL)
                .callFactory(httpLoggingInterceptor)
                .addCallAdapterFactory(rxJava3CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public TheMovieApi provideTheMovieApi(Retrofit retrofit) {
        return retrofit.create(TheMovieApi.class);
    }

}
