package com.example.metricsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button convert;
    EditText input;
    TextView output;
    Button swapBtn;
    TextView inputTitle;
    TextView outputTitle;
    Boolean convertFromFahrenheit = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.etxtInputTemperature);
        output = findViewById(R.id.txtvOutputTemperature);
        swapBtn = findViewById(R.id.btnSwapTemperature);

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

                        if(convertFromFahrenheit)
                            calculatedValue = (inputValue - 32) * 5/9; // formula to convert Fahrenheit to Celsius
                        else
                            calculatedValue = (inputValue * 9 / 5) + 32; // formula to convert Celsius to Fahrenheit

                        // round value to two decimals
                        calculatedValue = Math.round(calculatedValue * 100.0f) / 100.0f;

                        // set the result in the output field
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

    public void swapUnits(View view) {
        String tempText; // temp variable used to swap values
        inputTitle = findViewById(R.id.txtvInputTitleTemperature);
        input = findViewById(R.id.etxtInputTemperature);
        outputTitle = findViewById(R.id.txtvOutputTitleTemperature);
        output = findViewById(R.id.txtvOutputTemperature);

        convertFromFahrenheit ^= true; // switch the value of convertFromCelsius with an XOr-equals true

        // swap the values
        tempText = inputTitle.getText().toString();
        inputTitle.setText(outputTitle.getText().toString());
        outputTitle.setText(tempText);
        input.setText(output.getText().toString());

    }
}