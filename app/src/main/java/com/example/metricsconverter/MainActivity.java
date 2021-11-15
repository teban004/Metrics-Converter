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
    Boolean convertFromCelsius = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.etxtInput);
        output = findViewById(R.id.txtvOutput);
        swapBtn = findViewById(R.id.btnSwap);

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
                        if(convertFromCelsius)
                            calculatedValue = (inputValue * 9 / 5) + 32;
                        else
                            calculatedValue = (inputValue - 32) * 5/9;
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
        String tempText;
        inputTitle = findViewById(R.id.txtvInputTitle);
        input = findViewById(R.id.etxtInput);
        outputTitle = findViewById(R.id.txtvOutputTitle);
        output = findViewById(R.id.txtvOutput);

        // switch the value of convertFromCelsius with an XOr-equals true
        convertFromCelsius ^= true;

        tempText = inputTitle.getText().toString();
        inputTitle.setText(outputTitle.getText().toString());
        outputTitle.setText(tempText);
        input.setText(output.getText().toString());

    }
}