package com.example.bottomnavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);
        setListeners();
    }

    private void setListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        TextView textview = findViewById(R.id.textView);
        //If item is Checked make it unchecked
        if (item.isChecked())
            item.setChecked(false);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                //Check the Item
                textview.setText("Home View");
                item.setChecked(true);
                break;
            case R.id.navigation_contacts:
                //Check the Item
                textview.setText("Contacts View");
                item.setChecked(true);
                break;
            case R.id.navigation_music:
                //Check the Item
                textview.setText("Music View");
                item.setChecked(true);
                break;
        }
        return true;
    }
}


