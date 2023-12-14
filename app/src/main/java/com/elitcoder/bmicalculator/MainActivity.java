package com.elitcoder.bmicalculator;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result;
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.editWeight);
        edtHeightFt = findViewById(R.id.editHeightFt);
        edtHeightIn = findViewById(R.id.editHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        result = findViewById(R.id.result);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Ekhane ejekono kisu nite hoie get and ouput er jonne set ar edtWeight theke getText()
                 korle ta hobe editable format e tai eta ke int korte age string e porinoto korte hobe
                  then Interger.parseInt() diye int e convert korte hobe...
                 */
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htFt = Integer.parseInt(edtHeightFt.getText().toString());
                int htIn = Integer.parseInt((edtHeightIn.getText().toString()));

                int totalIn = htFt*12 + htIn;
                double totalCm = totalIn * 2.54;
                double totalM = totalCm/100;
                double bmi = wt/(Math.pow(totalM,2));

                if(bmi< 18.5){
                    result.setText("OOPS!\nYou are Under-weight!!!\nYou have to gain Weight...");
                    //Runtime color nite hoi evabe:
                    llMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }else if(bmi>=18.5 && bmi <= 24.9){
                    result.setTextColor(getResources().getColor(R.color.black));
                    result.setText("Congratulations!\nYou are Healthy!!!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }else if(bmi>=25 && bmi <= 29.9){
                    result.setText("OOPS!\nYou are Over_weight!!!\nPlease Maintain you diet and exercise daily...");
                    llMain.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }else{
                    result.setText("OOPS!\nYou are at high-risk!!!\nPlease exercise and maintain your diet...");
                    llMain.setBackgroundColor(getResources().getColor(R.color.obsese));
                }

            }
        });

    }
}