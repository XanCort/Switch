package com.example.aswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageView2).setVisibility(View.INVISIBLE);

        Switch switchImage = findViewById(R.id.switch1);
        switchImage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                System.out.println("ACTIVADO");
                findViewById(R.id.imageView2).setVisibility(View.VISIBLE);
            }
            else {
                System.out.println("DESACTIVADO");
                findViewById(R.id.imageView2).setVisibility(View.INVISIBLE);
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}