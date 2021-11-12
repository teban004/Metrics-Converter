package com.example.metricsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button convert;
    EditText input;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = findViewById(R.id.btnConvert);
        input = findViewById(R.id.etxtInput);
        result = findViewById(R.id.txtvResult);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inputValue, calculatedValue;
                inputValue = Double.parseDouble(input.getText().toString());
                calculatedValue = (inputValue - 32) * 5 / 9;
                result.setText(String.valueOf(calculatedValue));
            }
        });

    }
}