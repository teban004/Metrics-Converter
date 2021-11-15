package com.example.metricsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button convert;
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.etxtInput);
        output = findViewById(R.id.txtvOutput);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                float inputValue, calculatedValue;
                if(input.getText() != null) {
                    try {
                        inputValue = Float.parseFloat(input.getText().toString());
                        calculatedValue = (inputValue * 9 / 5) + 32;
                        output.setText(String.valueOf(calculatedValue));
                    } catch (Exception ex) {
                        Toast toast = Toast.makeText(getApplicationContext(), "An exception occurred when calculating Fahrenheit value.", Toast.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );



    }
}