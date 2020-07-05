package com.samoylenko.diplome.notes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Login implements Keystore {

    private Context context;
    private SharedPreferences myNoteSharedPref;
    private static String PIN_SALT = "lkjshgd;lksvlkhxckjhsdglhk!!";
    private static String PIN_HASH = "pin_hash";

    // проверяем, первый ли раз открывается программа


    Login(Context context) {
        this.context = context;
    }

    @Override
    public boolean hasPin() {
        myNoteSharedPref = context.getSharedPreferences(PIN_HASH, Context.MODE_PRIVATE);
        // проверяем, первый ли раз открывается программа, установлен ли пин
        if (myNoteSharedPref.contains(PIN_HASH)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkPin(String pin) {
        String pinSalt = myNoteSharedPref.getString(PIN_SALT, "");
        int pinHash = myNoteSharedPref.getInt(PIN_HASH, 0);

        //Integer hash = Integer.parseInt(pinHash);
        Integer inputPin = (pin + pinSalt).hashCode();
        return inputPin.equals(pinHash);
    }

    @Override
    public void saveNew(String pin) {
        SharedPreferences.Editor myNewPin = myNoteSharedPref.edit();
        String newPin = pin+PIN_SALT;
        myNewPin.putInt(PIN_HASH, newPin.hashCode());
        myNewPin.apply();
        //Toast.makeText(this, "Новый пин установлен", Toast.LENGTH_LONG).show();
    }
}
