package damith.currencyformatter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.damith.currencyformatter.CurrencyBuilder;
import com.damith.currencyformatter.CurrencyWatcher;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        EditText editText_number=findViewById (R.id.editText_number);

        //String default_cost = String.format(Locale.US, "%,." + 2 + "f", 0.00);

        //editText_number.setText(""+default_cost);
        editText_number.addTextChangedListener(new CurrencyBuilder ()
                .setDecimalPlace (2)
                .setLocale(Locale.FRANCE)
                .setSymbol(false)
                .create (editText_number));



    }
}