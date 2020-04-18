package com.githubarchcomponents.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.githubarchcomponents.converter.DateConverter;
import com.githubarchcomponents.db.dao.UserDao;

@Database(entities = {User.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {


    private static volatile MyDatabase INSTANCE;

    public abstract UserDao userDao();
}
