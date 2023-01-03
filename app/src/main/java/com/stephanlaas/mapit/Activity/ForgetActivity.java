package com.stephanlaas.mapit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stephanlaas.mapit.R;
import com.stephanlaas.mapit.databinding.ActivityForgetBinding;

public class ForgetActivity extends AppCompatActivity {

    private ActivityForgetBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityForgetBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.btnBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}