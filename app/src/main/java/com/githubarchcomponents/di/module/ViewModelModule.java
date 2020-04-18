package com.githubarchcomponents.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.githubarchcomponents.di.key.ViewModelKey;
import com.githubarchcomponents.viewmodels.FactoryViewModel;
import com.githubarchcomponents.viewmodels.UserProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel.class)
    abstract ViewModel bindUserProfileViewModel(UserProfileViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
