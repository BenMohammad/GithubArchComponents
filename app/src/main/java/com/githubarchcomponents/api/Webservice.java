package com.githubarchcomponents.api;

import com.githubarchcomponents.db.User;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Webservice {

    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String userId);
}
