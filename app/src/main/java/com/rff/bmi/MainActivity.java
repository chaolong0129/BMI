package com.rff.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews() {
        edweight = findViewById(R.id.edWeight);
        edheight = findViewById(R.id.edHeight);
        result = findViewById(R.id.result);
        Button btnHelp = findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("Help")
                .setMessage("The Body Mass Index (BMI) or Quetelet index is a value derived from the mass (weight) and height of an individual.")
                .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    public void bmi(View view)
    {
        String w = edweight.getText().toString();
        String h = edheight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("MainActivity","BMI : " + bmi);
        Toast.makeText(this, "Your BMI is " + bmi, Toast.LENGTH_LONG).show();
        result.setText("Your BMI is " + bmi);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI")
                .setMessage("Your BMI is : " + bmi)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edheight.setText("");
                        edweight.setText("");
                    }
                })
                .show();
    }

    public void help(View view)
    {

    }
}
