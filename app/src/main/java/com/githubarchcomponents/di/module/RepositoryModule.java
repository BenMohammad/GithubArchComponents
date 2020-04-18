package com.githubarchcomponents.di.module;

import com.githubarchcomponents.api.Webservice;
import com.githubarchcomponents.db.dao.UserDao;
import com.githubarchcomponents.repositories.UserRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(Webservice webservice, UserDao userDao, Executor executor) {
        return new UserRepository(webservice, userDao, executor);
    }
}
