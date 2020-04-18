package com.githubarchcomponents.di.module;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.githubarchcomponents.db.MyDatabase;
import com.githubarchcomponents.db.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MyDatabase.class, "MyDatabase.db")
                .build();

    }

    @Provides
    @Singleton
    UserDao provideUserDao(MyDatabase database) {
        return database.userDao();
    }
}
