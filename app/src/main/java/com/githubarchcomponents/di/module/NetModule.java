package com.githubarchcomponents.di.module;

import com.githubarchcomponents.api.Webservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private static String BASE_URL = "https://api.github.com/";

    @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    Webservice provideWebservice(Retrofit restAdapter) {
        return restAdapter.create(Webservice.class);
    }
}
