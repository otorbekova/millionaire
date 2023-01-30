package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.Splash.Menu;
import com.example.abc.Splash.SplashScreen;
import com.example.abc.Value.MMV;
import com.example.abc.Value.QuestionClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button start, prav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        prav = findViewById(R.id.prav);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Menu.class);
                startActivity(intent1);
            }
        });

        prav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Rools.class);
                startActivity(intent);

            }
        });
    }

}
