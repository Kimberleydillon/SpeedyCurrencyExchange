package com.example.speedycurrencyexchange;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CurrencyResultsActivity extends AppCompatActivity {

    TextView base_currency_tv;
    TextView currency1_tv;
    TextView currency2_tv;
    TextView base_currency2_tv;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    CurrencyViewModel currencyViewModel;
    String base_input;
    String currency1_input;
    String currency2_input;


    private static final String INPUT_PREFS = "InputPref_Key";
    private static final String BASE_KEY = "Base_Key";
    private static final String CURRENCY_1_KEY = "Currency1_Key";
    private static final String CURRENCY_2_KEY = "Currency2_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_results);


        currencyViewModel = ViewModelProviders.of(this).get(CurrencyViewModel.class);

        sharedpreferences = getSharedPreferences(INPUT_PREFS, MODE_PRIVATE);


        base_currency_tv = findViewById(R.id.base_currency_tv);
        base_currency2_tv = findViewById(R.id.base_currency_2_tv);
        currency1_tv = findViewById(R.id.currency_1_tv);
        currency2_tv = findViewById(R.id.currency_2_tv);


        displayBaseAndSymbolsText();

        //Saving Base to Preference
        saveBaseAndSymbolsToPref();
    }

    public void writeInputsToViewModel(View v) {
        currencyViewModel.baseCurrencyInput = base_input;
        base_currency_tv.setText(currencyViewModel.baseCurrencyInput);
        //If first works then duplicate and add first currency and second currency.

    }

    //Hopefully reads sharedpref api and pulls key/value
    public String displayBaseFromPref(Context context) {
        String baseText = sharedpreferences.getString(BASE_KEY, "");
        return baseText;
    }

    public String displayCurrency1FromPref(Context context) {
        String currency1Text = sharedpreferences.getString(CURRENCY_1_KEY, "");
        return currency1Text;
    }

    public String displayCurrency2FromPref(Context context) {
        String currency2Text = sharedpreferences.getString(CURRENCY_2_KEY, "");
        return currency2Text;
    }

    public void displayBaseAndSymbolsText() {
        displayBase();
        displayCurrency1();
        displayCurrency2();
    }


    //TODO perhaps use a switch statement instead of if/else to keep it more DRY.
    public void displayBase() {
        String base_input_intent = getIntent().getStringExtra("base");

        if (base_input_intent == null) {
            displayBaseFromPref(this);
            base_input = displayBaseFromPref(this);
            base_currency_tv.setText(base_input);
            base_currency2_tv.setText(base_input);
        } else {
            base_currency_tv.setText(base_input_intent);
            base_currency2_tv.setText(base_input_intent);
        }
    }

    public void displayCurrency1() {
        String currency1_input_intent = getIntent().getStringExtra("currency1");

        if (currency1_input_intent == null) {
            currency1_input = displayCurrency1FromPref(this);
            currency1_tv.setText(currency1_input);
        } else {
            currency1_tv.setText(currency1_input_intent);
        }
    }

    public void displayCurrency2() {
        String currency2_input_intent = getIntent().getStringExtra("currency2");

        if (currency2_input_intent == null) {
            currency2_input = displayCurrency2FromPref(this);
            currency2_tv.setText(currency2_input);
        } else {
            currency2_tv.setText(currency2_input_intent);
        }
    }

    // TODO: Maybe a for loop to go through each option and feed it into function?
    public void saveBaseAndSymbolsToPref() {
        editor = sharedpreferences.edit();
        String base = base_currency_tv.getText().toString();
        editor.putString(BASE_KEY, base);
        editor.apply();

        String currency1 = currency1_tv.getText().toString();
        editor.putString(CURRENCY_1_KEY, currency1);
        editor.apply();

        String currency2 = currency2_tv.getText().toString();
        editor.putString(CURRENCY_2_KEY, currency2);
        editor.apply();


    }

}
