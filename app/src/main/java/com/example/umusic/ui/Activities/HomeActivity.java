package com.example.umusic.ui.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.umusic.R;
import com.example.umusic.ui.Artists.Artists;
import com.example.umusic.ui.Tracks.Tracks;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomBar =  findViewById(R.id.bottom_bar);
        bottomBar.setSelectedItemId(R.id.tab_tracks);
        bottomBar.setOnNavigationItemSelectedListener(new HomeBottomMenu());
    }



    class HomeBottomMenu implements BottomNavigationView.OnNavigationItemSelectedListener {
        public HomeBottomMenu( )
        {
            buildFragment(new Tracks());
        }

        private void buildFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.tab_tracks:
                    buildFragment(new Tracks());
                    return true;
                case R.id.tab_artists:
                    buildFragment(new Artists());
                    return true;
            }
            return false;
        }
    }
}
