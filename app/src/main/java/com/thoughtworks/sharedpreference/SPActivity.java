package com.thoughtworks.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class SPActivity extends AppCompatActivity {
    private EditText editTextView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextView = findViewById(R.id.edit_value);
        Button buttonView = findViewById(R.id.value_btn);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValue();
            }
        });

        init();
    }

    private void init() {
        sharedPreferences = getSharedPreferences(getString(R.string.shared_file_id), Context.MODE_PRIVATE);
        Map<String, ?> all = sharedPreferences.getAll();
        editTextView.setText((String) all.get(getString(R.string.edit_key)));
    }

    private void updateValue() {
        String newValue = editTextView.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.edit_key), newValue);
        editor.apply();
    }
}
