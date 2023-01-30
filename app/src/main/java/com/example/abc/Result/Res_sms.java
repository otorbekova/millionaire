package com.example.abc.Result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abc.MainActivity;
import com.example.abc.R;

public class Res_sms extends AppCompatActivity {
    private TextView kol_t, dol;
    private Button button;
    public static final String INPUT_KEY = "input_key";
    public static final String INPUT_KEY2 = "input_key2";
    private String text, t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        if (getIntent() != null) { //если интент не пустой то
            kol_t = findViewById(R.id.kol);
            Intent intent = getIntent();
            text = intent.getStringExtra(INPUT_KEY); // Присваиваем результат переменной text по ключу INPUT_KEY
            t1 = intent.getStringExtra(INPUT_KEY2);
        }
        kol_t.setText(text);//выводим на TextView
        dol.setText(t1);

        button.setOnClickListener(new View.OnClickListener() { // Возвращаемся на главную менюшку
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Res_sms.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void init() { //Для инициализации  вюшек
        dol = findViewById(R.id.d);
        button = findViewById(R.id.menu_m);
    }
}