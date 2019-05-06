package com.example.speedycurrencyexchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputCurrencyActivity extends AppCompatActivity {
    String base;
    String currency1;
    String currency2;
    EditText base_input;
    EditText currency1_input;
    EditText currency2_input;
    Button continueButton;

    private static final String BASE_KEY = "Base_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_currency);

        base_input = findViewById(R.id.base_input);
        currency1_input = findViewById(R.id.currency_1_input);
        currency2_input = findViewById(R.id.currency_2_input);
        continueButton = findViewById(R.id.continue_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                base = base_input.getText().toString();
                currency1 = currency1_input.getText().toString();
                currency2 = currency2_input.getText().toString();

                Intent sendCurrencyInput = new Intent(InputCurrencyActivity.this, CurrencyResultsActivity.class);

                sendCurrencyInput.putExtra("base", base);
                sendCurrencyInput.putExtra("currency1", currency1);
                sendCurrencyInput.putExtra("currency2", currency2);

                InputCurrencyActivity.this.startActivity(sendCurrencyInput);

            }
        });

    }


}
