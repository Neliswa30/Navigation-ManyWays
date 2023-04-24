package com.MeLiCwa.manywaysnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText emailAddress, userName, name ,Password;
    FirebaseAuth auth;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            finish();
        }
        emailAddress = (EditText) findViewById(R.id.editTxtEmailAddress_SignUp);
        Password = (EditText) findViewById(R.id.editTxtPassword_Signup);
        btnSignUp = (Button) findViewById(R.id.SignUpbtn);
        userName = (EditText) findViewById(R.id.editTxtUsername);
        name = (EditText) findViewById(R.id.editTxtName);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailAddress.getText().toString();
                String password = Password.getText().toString();

                try {
                    if (!password.isEmpty()&&!email.isEmpty()) {
                        auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    SignUpActivity.this,
                                                    "Authentication Failed",
                                                    Toast.LENGTH_LONG).show();
                                            Log.v("Error", task.getResult().toString());
                                        } else if(password.length() < 6){
                                            Toast.makeText(
                                                    SignUpActivity.this,
                                                    "Your Password has less than 6 characters",
                                                    Toast.LENGTH_LONG).show();
                                        }else {
                                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(
                                SignUpActivity.this,
                                "Fill All Fields, Then Sign Up",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}