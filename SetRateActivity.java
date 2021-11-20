package it.cnr.iit.intentusageexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetRateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_rate);
        final EditText setRate = findViewById(R.id.inputRate);
        final TextView viewRate = findViewById(R.id.currentRateView);
        Button backButton = findViewById(R.id.back_to_convert_button);
        final Intent callBackIntent = new Intent(this, MainActivity.class);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double rateValue = Double.parseDouble(setRate.getText().toString());
                callBackIntent.putExtra("conversionRate", rateValue);
                startActivity(callBackIntent);
            }
        });


    }
}
