package com.stephanlaas.mapit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.stephanlaas.mapit.R;
import com.stephanlaas.mapit.Utility.LoadingDialog;
import com.stephanlaas.mapit.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mBinding;
    private String email, password;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.btnSignUp.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });

//        mBinding.txtForgetPassword.setOnClickListener(view -> {
//            startActivity(new Intent(LoginActivity.this, ForgetActivity.class));
//        });
        mBinding.btnLogin.setOnClickListener(view -> {
            if (areFieldReady()) {
                login();
            }
        });
    }

    private void login() {
       // loadingDialog.startLoading();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    if (firebaseAuth.getCurrentUser() != null) {

//                        loadingDialog.stopLoading();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

//                    } else {
//
//                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> email) {
//                                if (email.isSuccessful()) {
//                                    loadingDialog.stopLoading();
//                                    Toast.makeText(LoginActivity.this, "Please verify email", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    loadingDialog.stopLoading();
//                                    Toast.makeText(LoginActivity.this, "Error : " + email.getException(), Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    }

                } else {

                    Toast.makeText(LoginActivity.this, "Error : WRONG PASSWORD! " , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean areFieldReady(){

        email = mBinding.edtEmail.getText().toString().trim();
        password = mBinding.edtPassword.getText().toString().trim();

        boolean flag = false;
        View requestView = null;

        if (email.isEmpty()) {
            mBinding.edtEmail.setError("Field is required");
            flag = true;
            requestView = mBinding.edtEmail;
        } else if (password.isEmpty()) {
            mBinding.edtPassword.setError("Field is required");
            flag = true;
            requestView = mBinding.edtPassword;
        } else if (password.length() < 8) {
            mBinding.edtPassword.setError("Minimum 8 characters");
            flag = true;
            requestView = mBinding.edtPassword;
        }

        if (flag) {
            requestView.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}