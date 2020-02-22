package com.example.bottomnavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener{

    AViewFlipper vflipper;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int Images[] = {R.drawable.carimage1,R.drawable.carimage2,
                        R.drawable.carimage3,R.drawable.carimage4};

        vflipper = findViewById(R.id.v_flipper);

        for (int image:Images){
            flipperImages(image);
        }

        bottomNavigationView = findViewById(R.id.nav_view);
        setListeners();
    }

    private void setListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //If item is Checked make it unchecked
        if (item.isChecked())
            item.setChecked(false);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                //Check the Item
                Toast.makeText(this,"Main Activity",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                break;
            case R.id.navigation_contacts:
                //Check the Item
                Toast.makeText(this,"Contact View",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                break;
            case R.id.navigation_music:
                //Check the Item
                Toast.makeText(this,"Music View",Toast.LENGTH_LONG).show();
                item.setChecked(true);
                break;
        }
        return true;
    }

    public void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vflipper.addView(imageView);
        vflipper.setFlipInterval(4000); // 4 seconds
        vflipper.setAutoStart(true);

        //Animation
        vflipper.setInAnimation(this,android.R.anim.slide_in_left);
        //v_flipper.setInAnimation(this,android.R.anim.slide_out_right);
    }
}


