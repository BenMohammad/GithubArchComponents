package com.githubarchcomponents.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.githubarchcomponents.db.User;
import com.githubarchcomponents.repositories.UserRepository;

import javax.inject.Inject;

public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;
    private UserRepository userRepository;

    @Inject
    public UserProfileViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void init(String userId) {
        if(this.user != null) {
            return;
        }
        user = userRepository.getUser(userId);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
