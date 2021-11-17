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

    Boolean convertTemperatureFromFahrenheit = true;
    Boolean convertLengthFromInches = true;
    Boolean convertWeightFromPounds = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputTemperature = findViewById(R.id.etxtInputTemperature);
        TextView outputTemperature = findViewById(R.id.txtvOutputTemperature);

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

        EditText inputLength = findViewById(R.id.etxtInputLength);
        TextView outputLength = findViewById(R.id.txtvOutputLength);

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
                            calculatedValue = inputValue * 2.54; // formula to convert Inches to Centimeters
                        else
                            calculatedValue = inputValue / 2.54; // formula to convert Centimeters to Inches

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

        EditText inputWeight = findViewById(R.id.etxtInputWeight);
        TextView outputWeight = findViewById(R.id.txtvOutputWeight);

        inputWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                double inputValue, calculatedValue;
                if(inputWeight.getText() != null) {
                    try {
                        inputValue = Float.parseFloat(inputWeight.getText().toString());

                        if(convertWeightFromPounds)
                            calculatedValue = inputValue * 0.45359237; // formula to convert Kilograms to Pounds
                        else
                            calculatedValue = inputValue / 0.45359237; // formula to convert Pounds to Kilograms

                        // round value to two decimals
                        calculatedValue = Math.round(calculatedValue * 100.0) / 100.0;

                        // set the result in the output field
                        outputWeight.setText(String.valueOf(calculatedValue));
                    } catch (Exception ex) {
                        Toast toast = Toast.makeText(getApplicationContext(), "An exception occurred when calculating weight value.", Toast.LENGTH_SHORT);
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
        TextView inputTitleTemperature = findViewById(R.id.txtvInputTitleTemperature);
        EditText inputTemperature = findViewById(R.id.etxtInputTemperature);
        TextView outputTitleTemperature = findViewById(R.id.txtvOutputTitleTemperature);
        TextView outputTemperature = findViewById(R.id.txtvOutputTemperature);

        convertTemperatureFromFahrenheit ^= true; // switch the value of convertTemperatureFromFahrenheit with an XOr-equals true

        // swap the values
        tempText = inputTitleTemperature.getText().toString();
        inputTitleTemperature.setText(outputTitleTemperature.getText().toString());
        outputTitleTemperature.setText(tempText);
        inputTemperature.setText(outputTemperature.getText().toString());

    }

    public void swapLengthUnits(View view) {
        String tempText; // temp variable used to swap values
        TextView inputTitleLength = findViewById(R.id.txtvInputTitleLength);
        EditText inputLength = findViewById(R.id.etxtInputLength);
        TextView outputTitleLength = findViewById(R.id.txtvOutputTitleLength);
        TextView outputLength = findViewById(R.id.txtvOutputLength);

        convertLengthFromInches ^= true; // switch the value of convertLengthFromInches with an XOr-equals true

        // swap the values
        tempText = inputTitleLength.getText().toString();
        inputTitleLength.setText(outputTitleLength.getText().toString());
        outputTitleLength.setText(tempText);
        inputLength.setText(outputLength.getText().toString());

    }

    public void swapWeigthUnits(View view) {
        String tempText; // temp variable used to swap values
        TextView inputTitleWeight = findViewById(R.id.txtvInputTitleWeight);
        EditText inputWeight = findViewById(R.id.etxtInputWeight);
        TextView outputTitleWeight = findViewById(R.id.txtvOutputTitleWeight);
        TextView outputWeight = findViewById(R.id.txtvOutputWeight);

        convertWeightFromPounds ^= true; // switch the value of convertLengthFromInches with an XOr-equals true

        // swap the values
        tempText = inputTitleWeight.getText().toString();
        inputTitleWeight.setText(outputTitleWeight.getText().toString());
        outputTitleWeight.setText(tempText);
        inputWeight.setText(outputWeight.getText().toString());

    }

}