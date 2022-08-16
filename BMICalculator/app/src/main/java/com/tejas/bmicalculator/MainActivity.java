package com.tejas.bmicalculator;

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
        setContentView(R.layout.activity_main);        // This line shows xml file connected.

        EditText edtWeightInput, edtHeightFt,edtHeightIn;
        TextView textResult;
        Button btnCalculate;                 // Declaring the variables for particular view.
        LinearLayout layout1Main;

        edtWeightInput = findViewById(R.id.edtWeightInput);            // this connect the variable to particular xml component
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);                 // R.id.view : taking resources of view form resource folder
        textResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        layout1Main = findViewById(R.id.layout1Main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {              // when user click on button then below function is run.
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeightInput.getText().toString());        // it take editable value and convert into int value.
                // class Integer having method parseInt which convert string value into integer value.

                int h_ft = Integer.parseInt(edtHeightFt.getText().toString());
                int h_in = Integer.parseInt(edtHeightIn.getText().toString());

                // logic for the BMI Calculation :

                int totalIn = h_ft*12 + h_in;

                double totalCm = totalIn*2.54;

                double totalMeter = totalCm*0.01;

                double bmi = wt/(totalMeter*totalMeter);

                if (bmi > 25) {
                    textResult.setText("You're OverWeight");
                    layout1Main.setBackgroundColor(getResources().getColor(R.color.overweight));          // getting colour from resources folder
                }else if(bmi<18){
                    textResult.setText("You're Underweight");
                    layout1Main.setBackgroundColor(getResources().getColor(R.color.underweight));
                }else {
                    textResult.setText("You're Healthy!");
                    layout1Main.setBackgroundColor(getResources().getColor(R.color.healthy));


                    // Note : R.color : taking colour from resources folder.
                    // getResources ().getColor() : providing resource of colour
                }
            }
        });

        






    }
}