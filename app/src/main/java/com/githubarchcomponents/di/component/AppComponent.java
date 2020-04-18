package com.githubarchcomponents.di.component;

import android.app.Activity;
import android.app.Application;

import com.githubarchcomponents.App;
import com.githubarchcomponents.di.module.ActivityModule;
import com.githubarchcomponents.di.module.AppModule;
import com.githubarchcomponents.di.module.DatabaseModule;
import com.githubarchcomponents.di.module.FragmentModule;
import com.githubarchcomponents.di.module.NetModule;
import com.githubarchcomponents.di.module.RepositoryModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, DatabaseModule.class, NetModule.class, RepositoryModule.class, ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
