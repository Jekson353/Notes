package com.samoylenko.diplome.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (App.getKeystore().hasPin()){
            if (App.getKeystore().checkPin("sdfs")){
                Toast.makeText(this, "Пин верный", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Пин НЕ верный", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "Пин не установлен", Toast.LENGTH_LONG).show();
        }
    }
}
