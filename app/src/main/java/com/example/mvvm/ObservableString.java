package com.example.mvvm;

import android.databinding.ObservableField;

/**
 * Representing Observable behavior for standard @{@link String} class
 */
public class ObservableString extends ObservableField<String> {

    public ObservableString() {
        super();
        set("");
    }

    public ObservableString(String value) {
        super();
        set(value);
    }
}
