package com.example.speedycurrencyexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CurrencyResultsActivity extends AppCompatActivity {

    TextView baseCurrency;
    TextView currency1;
    TextView currency2;
    TextView baseCurrency2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_results);

        baseCurrency = findViewById(R.id.base_currency);
        baseCurrency2 = findViewById(R.id.base_currency_2);
        currency1 = findViewById(R.id.currency_1);
        currency2 = findViewById(R.id.currency_2);

        String base_input = getIntent().getStringExtra("base");
        String currency1_input = getIntent().getStringExtra("currency1");
        String currency2_input = getIntent().getStringExtra("currency2");

        baseCurrency.setText(base_input);
        baseCurrency2.setText(base_input);
        currency1.setText(currency1_input);
        currency2.setText(currency2_input);
    }
}
