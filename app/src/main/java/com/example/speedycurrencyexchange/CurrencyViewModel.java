package com.example.speedycurrencyexchange;

import android.arch.lifecycle.ViewModel;

public class CurrencyViewModel extends ViewModel {
    //Track Base Currency
    public String baseCurrencyInput = "";

    //Track Currency 2
    public String Currency1Input = "";

    //Track Currency 3
    public String Currency2Input = "";

    public String getBaseCurrencyInput() {
        return baseCurrencyInput;
    }

    public void setBaseCurrencyInput(String baseCurrencyInput) {
        this.baseCurrencyInput = baseCurrencyInput;
    }

    public String getCurrency1Input() {
        return Currency1Input;
    }

    public void setCurrency1Input(String currency1Input) {
        Currency1Input = currency1Input;
    }

    public String getCurrency2Input() {
        return Currency2Input;
    }

    public void setCurrency2Input(String currency2Input) {
        Currency2Input = currency2Input;
    }

}
