package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText input;
    private RadioButton bdt, usd;
    private double value;
    private double answer;
    private Converter cc = new Converter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.edtInput);
        usd = findViewById(R.id.rbusd);
        bdt = findViewById(R.id.rbbdt);
    }

    public void convert(View view) {
       try {
           value = Double.parseDouble(input.getText().toString());
           if(bdt.isChecked()){
               answer = cc.bdttousd(value);
               input.setText(answer + " ");
           }
           else {
               answer = cc.usdtobdt(value);
               input.setText(answer +"  ");
           }
       }
       catch (Exception e){
           Toast.makeText(getApplicationContext(), "Empty input",Toast.LENGTH_LONG).show();
       }

    }
}