package com.githubarchcomponents.di.module;

import com.githubarchcomponents.fragments.UserProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();
}
