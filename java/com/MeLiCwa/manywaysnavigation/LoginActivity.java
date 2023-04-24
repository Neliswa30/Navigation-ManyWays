package com.MeLiCwa.manywaysnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseAuth mFirebaseAuth;
    Button loginBtn, SignUpbtn;
    EditText emailAdd, password;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailAdd = findViewById(R.id.editTxtEmailAddress);
        password = findViewById(R.id.editTxtPassword);
        loginBtn = findViewById(R.id.Loginbtn);
        SignUpbtn = findViewById(R.id.SignUpbtn);
        forgotPassword = findViewById(R.id.textView);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailAdd.getText().toString();
                String password = LoginActivity.this.password.getText().toString();
                if (email.isEmpty()) {
                    emailAdd.setError("Please Enter Your Email Address");
                    emailAdd.requestFocus();
                } else if (password.isEmpty()) {
                    LoginActivity.this.password.setError("Please Enter Your Password");
                    LoginActivity.this.password.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Fields Is Empty, Add Content", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty() && password.isEmpty()) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Error Occurred, Please Login", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intToHome = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword.setOnClickListener(view -> {
            Intent intToForgot = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
            startActivity(intToForgot);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}