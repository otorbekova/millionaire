package com.example.abc.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abc.MainActivity;
import com.example.abc.R;

public class Win_Result extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win__result);
        button = findViewById(R.id.menu_n);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Win_Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}