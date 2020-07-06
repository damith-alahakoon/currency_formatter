package com.damith.currencyformatter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyWatcher implements TextWatcher {

    private Locale languType = Locale.ENGLISH;
    private int decimalP = 2;
    private EditText editText;
    String current = "0.0";
    private boolean showSymbol = false;


    public CurrencyWatcher(EditText editText, int decimalP, Locale languType, boolean showSymbol) {
        this.editText = editText;
        this.decimalP = decimalP;
        this.languType = languType;
        this.showSymbol = showSymbol;

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (!s.toString ().equals (current)) {

            String cleanString = s.toString ().replaceAll ("\\D", "");


            String formatted = "0";
            try {
                editText.removeTextChangedListener (this);
                Double parsed = 0.00;
                Double real_value = 0.00;
                parsed = Double.parseDouble (cleanString);
                NumberFormat nf = NumberFormat.getCurrencyInstance (languType);
                if (showSymbol) {

                } else {
                    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols ();
                    decimalFormatSymbols.setCurrencySymbol ("");
                    ((DecimalFormat) nf).setDecimalFormatSymbols (decimalFormatSymbols);
                }


                if (decimalP == 0) {
                    nf.setMinimumFractionDigits (0);
                    real_value = Double.parseDouble (cleanString) / 1;
                } else if (decimalP == 1) {
                    nf.setMinimumFractionDigits (1);
                    real_value = Double.parseDouble (cleanString) / 10;
                } else if (decimalP == 2) {
                    nf.setMinimumFractionDigits (2);
                    real_value = Double.parseDouble (cleanString) / 100;
                } else if (decimalP == 3) {
                    nf.setMinimumFractionDigits (3);
                    real_value = Double.parseDouble (cleanString) / 1000;
                } else if (decimalP == 4) {
                    nf.setMinimumFractionDigits (4);
                    real_value = Double.parseDouble (cleanString) / 10000;
                }
                current = formatted;


                formatted = nf.format (real_value);

                editText.setText (formatted);
                editText.setSelection (formatted.length ());
                if (formatted.equals ("0")) {
                    editText.setFocusable (true);
                    editText.requestFocus ();
                }
                editText.addTextChangedListener (this);


            } catch (NumberFormatException e) {
                editText.setText ("");
                editText.addTextChangedListener (this);

                e.printStackTrace ();
            }


        }


    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
