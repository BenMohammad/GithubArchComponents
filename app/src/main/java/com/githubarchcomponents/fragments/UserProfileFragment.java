package com.githubarchcomponents.fragments;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.githubarchcomponents.R;
import com.githubarchcomponents.db.User;
import com.githubarchcomponents.repositories.UserRepository;
import com.githubarchcomponents.viewmodels.UserProfileViewModel;

import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

public class UserProfileFragment extends Fragment {

    public static final String UID_KEY = "uid";
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private UserProfileViewModel viewModel;

    @BindView(R.id.fragment_user_profile_image)
    ImageView imageview;

    @BindView(R.id.fragment_user_profile_username)
    TextView username;

    @BindView(R.id.fragment_user_profile_company)
    TextView company;

    @BindView(R.id.fragment_user_profile_website)
    TextView website;

    public UserProfileFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();
    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel() {
        String userlogin = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserProfileViewModel.class);
        viewModel.init(userlogin);
        viewModel.getUser().observe(this, user -> updateUI(user));

    }

    private void updateUI(@Nullable User user) {
        if(user != null) {
            Glide.with(this).load(user.getAvatar_url()).apply(RequestOptions.circleCropTransform()).into(imageview);
            this.username.setText(user.getName());
            this.company.setText(user.getCompany());
            this.website.setText(user.getBlog());

        }    }
}
