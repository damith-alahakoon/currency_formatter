package com.damith.currencyformatter;

import android.widget.EditText;

import java.util.Locale;

public class CurrencyBuilder {
    private Locale languType = Locale.ENGLISH;
    private int decimalP = 2;
    private boolean showSymbol=false;

    public CurrencyBuilder setLocale(Locale languType) {
        this.languType = languType;
        return this;
    }

    public CurrencyBuilder setDecimalPlace(int decimalP) {
        this.decimalP = decimalP;
        return this;
    }
    public CurrencyBuilder setSymbol(boolean showSymbol) {
        this.showSymbol = showSymbol;
        return this;
    }

    public CurrencyWatcher create(EditText editText) {
        return new CurrencyWatcher (editText, decimalP, languType,showSymbol);
    }


}
