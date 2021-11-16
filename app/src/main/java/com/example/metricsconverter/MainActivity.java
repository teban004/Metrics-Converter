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

    EditText inputTemperature;
    TextView outputTemperature;
    Button swapBtnTemperature;
    TextView inputTitleTemperature;
    TextView outputTitleTemperature;
    Boolean convertTemperatureFromFahrenheit = true;

    EditText inputLength;
    TextView outputLength;
    Button swapBtnLength;
    TextView inputTitleLength;
    TextView outputTitleLength;
    Boolean convertLengthFromInches = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.etxtInputTemperature);
        outputTemperature = findViewById(R.id.txtvOutputTemperature);
        swapBtnTemperature = findViewById(R.id.btnSwapTemperature);

        inputTemperature.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                double inputValue, calculatedValue;
                if(inputTemperature.getText() != null) {
                    try {
                        inputValue = Float.parseFloat(inputTemperature.getText().toString());

                        if(convertTemperatureFromFahrenheit)
                            calculatedValue = (inputValue - 32) * 5/9; // formula to convert Fahrenheit to Celsius
                        else
                            calculatedValue = (inputValue * 9 / 5) + 32; // formula to convert Celsius to Fahrenheit

                        // round value to two decimals
                        calculatedValue = Math.round(calculatedValue * 100.0) / 100.0;

                        // set the result in the output field
                        outputTemperature.setText(String.valueOf(calculatedValue));
                    } catch (Exception ex) {
                        Toast toast = Toast.makeText(getApplicationContext(), "An exception occurred when calculating temperature value.", Toast.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        inputLength = findViewById(R.id.etxtInputLength);
        outputLength = findViewById(R.id.txtvOutputLength);
        swapBtnLength = findViewById(R.id.btnSwapLength);

        inputLength.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                double inputValue, calculatedValue;
                if(inputLength.getText() != null) {
                    try {
                        inputValue = Float.parseFloat(inputLength.getText().toString());

                        if(convertLengthFromInches)
                            calculatedValue = inputValue * 2.54; // formula to convert Fahrenheit to Celsius
                        else
                            calculatedValue = inputValue / 2.54; // formula to convert Celsius to Fahrenheit

                        // round value to two decimals
                        calculatedValue = Math.round(calculatedValue * 100.0) / 100.0;

                        // set the result in the output field
                        outputLength.setText(String.valueOf(calculatedValue));
                    } catch (Exception ex) {
                        Toast toast = Toast.makeText(getApplicationContext(), "An exception occurred when calculating length value.", Toast.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

    }

    public void swapTemperatureUnits(View view) {
        String tempText; // temp variable used to swap values
        inputTitleTemperature = findViewById(R.id.txtvInputTitleTemperature);
        inputTemperature = findViewById(R.id.etxtInputTemperature);
        outputTitleTemperature = findViewById(R.id.txtvOutputTitleTemperature);
        outputTemperature = findViewById(R.id.txtvOutputTemperature);

        convertTemperatureFromFahrenheit ^= true; // switch the value of convertTemperatureFromFahrenheit with an XOr-equals true

        // swap the values
        tempText = inputTitleTemperature.getText().toString();
        inputTitleTemperature.setText(outputTitleTemperature.getText().toString());
        outputTitleTemperature.setText(tempText);
        inputTemperature.setText(outputTemperature.getText().toString());

    }

    public void swapLengthUnits(View view) {
        String tempText; // temp variable used to swap values
        inputTitleTemperature = findViewById(R.id.txtvInputTitleLength);
        inputTemperature = findViewById(R.id.etxtInputLength);
        outputTitleTemperature = findViewById(R.id.txtvOutputTitleLength);
        outputTemperature = findViewById(R.id.txtvOutputLength);

        convertLengthFromInches ^= true; // switch the value of convertLengthFromInches with an XOr-equals true

        // swap the values
        tempText = inputTitleTemperature.getText().toString();
        inputTitleTemperature.setText(outputTitleTemperature.getText().toString());
        outputTitleTemperature.setText(tempText);
        inputTemperature.setText(outputTemperature.getText().toString());

    }

}