package com.MeLiCwa.manywaysnavigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity {
private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch switchkm = view.findViewById(R.id.switch1);
        Switch switchmiles = view.findViewById(R.id.switchMiles);

        switchmiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchmiles.setChecked(true);
                switchkm.setChecked(false);
                Map setMap=new HashMap();
                setMap.put("set","mile");
                FirebaseFirestore.getInstance().collection("Settings").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).set(setMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(SettingsActivity.this, "Your settings have been updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SettingsActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        switchkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchkm.setChecked(false);
                switchkm.setChecked(true);

                Map setMap=new HashMap();
                setMap.put("set","km");
                FirebaseFirestore.getInstance().collection("Settings").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).set(setMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(SettingsActivity.this, "Your settings have been updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SettingsActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
