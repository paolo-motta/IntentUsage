package it.cnr.iit.intentusageexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//CODICE PROGETTO
import android.provider.Telephony;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.DoubleBuffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convertButton = findViewById(R.id.convert_button);
        Button goToSetRateActivityButton = findViewById(R.id.go_to_set_rate_button);
        final TextView resultField = findViewById(R.id.resultField);
        final EditText inputField = findViewById(R.id.inputField);
        final Intent goToSetRate = new Intent(this, SetRateActivity.class);

        goToSetRateActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToSetRate);
            }
        });
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double inputValue = Double.parseDouble(inputField.getText().toString());
                Double convertRate = 1936.27;
                Bundle extra = getIntent().getExtras();
                if(extra.get("conversionRate")!=null)
                    convertRate = Double.parseDouble(extra.get("conversionRate").toString());
                Double result= inputValue/convertRate;
                resultField.setText(result.toString());
            }
        });
    }
}
