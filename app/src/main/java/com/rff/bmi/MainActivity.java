package com.rff.bmi;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
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

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edweight;
    private EditText edheight;
    private TextView result;

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
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
                .setTitle(R.string.help)
                .setMessage(R.string.bmi_info)
                .setPositiveButton(R.string.ok, null)
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
        Toast.makeText(this, getString(R.string.your_bmi_is) + bmi, Toast.LENGTH_LONG).show();
        result.setText(getString(R.string.your_bmi_is) + bmi);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("BMI", bmi);
        startActivity(intent);
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI")
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edheight.setText("");
                        edweight.setText("");
                    }
                })
                .show();*/
    }

    public void help(View view)
    {

    }
}
