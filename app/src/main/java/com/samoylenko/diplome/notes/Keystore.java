package com.samoylenko.diplome.notes;

public interface Keystore {
    boolean hasPin();
    boolean checkPin(String pin);
    void saveNew(String pin);
}
