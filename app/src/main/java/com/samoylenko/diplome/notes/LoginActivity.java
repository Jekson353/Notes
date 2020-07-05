package com.samoylenko.diplome.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private final String PIN_DELETE = "delete";
    private final String PIN_ADD = "add";

    public StringBuffer sb = new StringBuffer("");
    public TextView pincode;
    private Button pin1;
    private Button pin2;
    private Button pin3;
    private Button pin4;
    private Button pin5;
    private Button pin6;
    private Button pin7;
    private Button pin8;
    private Button pin9;
    private Button pin0;
    private Button delete;
    private View key1;
    private View key2;
    private View key3;
    private View key4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pincode = findViewById(R.id.pincode);
        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);
        pin3 = findViewById(R.id.pin3);
        pin4 = findViewById(R.id.pin4);
        pin5 = findViewById(R.id.pin5);
        pin6 = findViewById(R.id.pin6);
        pin7 = findViewById(R.id.pin7);
        pin8 = findViewById(R.id.pin8);
        pin9 = findViewById(R.id.pin9);
        pin0 = findViewById(R.id.pin0);
        key1 = findViewById(R.id.pin_key_1);
        key2 = findViewById(R.id.pin_key_2);
        key3 = findViewById(R.id.pin_key_3);
        key4 = findViewById(R.id.pin_key_4);


        View.OnClickListener btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button tbn = findViewById(v.getId());
                pincode.setText(valueResult(tbn.getText().toString(), PIN_ADD));
            }
        };

        Button delete = findViewById(R.id.pin_del);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tbn = findViewById(R.id.pincode);
                pincode.setText(valueResult(tbn.getText().toString(), PIN_DELETE));
            }
        });

        pin1.setOnClickListener(btn);
        pin2.setOnClickListener(btn);
        pin3.setOnClickListener(btn);
        pin4.setOnClickListener(btn);
        pin5.setOnClickListener(btn);
        pin6.setOnClickListener(btn);
        pin7.setOnClickListener(btn);
        pin8.setOnClickListener(btn);
        pin9.setOnClickListener(btn);
        pin0.setOnClickListener(btn);
    }

    public StringBuffer valueResult(String value, String options) {
        int key;

        switch (options) {
            case PIN_ADD: {
                key = sb.length();
                if (key < 4) {
                    sb.insert(key, value);
                    keyView(sb.length());
                    if (sb.length()==4){

                        
                        if (App.getKeystore().hasPin()){
                            if (App.getKeystore().checkPin("sdfs")){
                                Toast.makeText(this, "Пин верный", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(this, "Пин НЕ верный", Toast.LENGTH_LONG).show();
                            }

                        }else {
                            Toast.makeText(this, "Пин не установлен", Toast.LENGTH_LONG).show();
                        }
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        LoginActivity.this.finish();
//                        startActivity(intent);
                    }
                    return sb;
                }
                return sb;
            }
            case PIN_DELETE: {
                key = sb.length();
                if (key>0){
                    keyViewDel(key);
                    sb.delete(key-1, key);
                    return sb;
                }else{
                    sb.delete(0, sb.length());
                    return sb;
                }
            }
            default:
                return sb;
        }
    }

    private void keyView(Integer key) {
        if (key == 1) {
            key1.setBackgroundResource(R.drawable.shape_oval);
        } else if (key == 2) {
            key2.setBackgroundResource(R.drawable.shape_oval);
        } else if (key == 3) {
            key3.setBackgroundResource(R.drawable.shape_oval);
        } else if (key == 4) {
            key4.setBackgroundResource(R.drawable.shape_oval);
        }
    }

    private void keyViewDel(Integer key) {
        if (key == 1) {
            key1.setBackgroundResource(R.drawable.shape_oval_grey);
        } else if (key == 2) {
            key2.setBackgroundResource(R.drawable.shape_oval_grey);
        } else if (key == 3) {
            key3.setBackgroundResource(R.drawable.shape_oval_grey);
        } else if (key == 4) {
            key4.setBackgroundResource(R.drawable.shape_oval_grey);
        }
    }
}
