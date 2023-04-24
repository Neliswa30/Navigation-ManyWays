package com.MeLiCwa.manywaysnavigation.ui.favorites;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.MeLiCwa.manywaysnavigation.FavPlaces;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FavoritesFragment extends AppCompatActivity {

    TextView textfav;
    private List<FavPlaces> lstFavouritePlaces;
    private ArrayAdapter<FavPlaces> adapter;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference favouritePlacesRef = database.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
    private FavPlaces favouritePlaceSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    //.add(R.id.nav_host_fragment_container, FavoritesFragment.class, null)
                    .commit();
        }
    }
}

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);

        textfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (favouritePlaceSelected != null) {
                    favouritePlacesRef.child("FavouritePlaceData").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataInfo : snapshot.getChildren()) {
                                FavPlaces checkFP = dataInfo.getValue(FavPlaces.class);
                                if (favouritePlaceSelected.getPlaceName() == checkFP.getAddress()
                                        && favouritePlaceSelected.getPlaceName() == checkFP.getAddress()) {
                                    dataInfo.getRef().removeValue();
                                }
                            }

                            Intent i = new Intent(FavoritesFragment.this, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(FavoritesFragment.this, favouritePlaceSelected.getText() + " has been removed from your favourites", Toast.LENGTH_SHORT).show();
                            finish();
                            finishActivity(0);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(FavoritesFragment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(FavoritesFragment.this, "Please select a place", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/
