package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Memory
    private TextView numDisplay;
    private double firstNumber =0;
    private String operator = "";
    private boolean newInput = true;

    private void onNumberClick(String number){
        String currentText = numDisplay.getText().toString();

        if (newInput || currentText.equals("0")){
            numDisplay.setText(number);
            newInput = false;
        } else {
            numDisplay.setText(currentText + number);
        }

    }

    private void onClearClick() {
        numDisplay.setText("0");
        firstNumber = 0;
        operator = "";
        newInput = true;
    }

    private void onOperatorClick(String op){
        if (numDisplay.getText().toString().equals("Error")){ //If last equals was an error.
            return;
        }
        firstNumber = Double.parseDouble(numDisplay.getText().toString());
        operator = op;
        newInput = true;
    }

    private void onEqualsClick(){
        double secondNumber = Double.parseDouble(numDisplay.getText().toString());
        double result = 0;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        } else if (operator.equals("/")) {
            if (secondNumber == 0) {
                numDisplay.setText("Error");
                newInput = true;
                return;
            }

            result = firstNumber / secondNumber;

        }

        //numDisplay.setText(String.valueOf(result)); improved display
        if (result == (int) result) {
            numDisplay.setText(String.valueOf((int) result));
        } else {
            numDisplay.setText(String.valueOf(result));
        }
        newInput = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numDisplay = findViewById(R.id.numDisplay);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn10 = findViewById(R.id.btn10);
        Button btn11 = findViewById(R.id.btn11);
        Button btn12 = findViewById(R.id.btn12);
        Button btn13 = findViewById(R.id.btn13);
        Button btn14 = findViewById(R.id.btn14);
        Button btn15 = findViewById(R.id.btn15);

        btn0.setOnClickListener(view -> onClearClick());
        btn1.setOnClickListener(view -> onNumberClick("0"));
        btn2.setOnClickListener(view -> onEqualsClick());
        btn3.setOnClickListener(view -> onOperatorClick("+"));
        btn4.setOnClickListener(view -> onNumberClick("1"));
        btn5.setOnClickListener(view -> onNumberClick("2"));
        btn6.setOnClickListener(view -> onNumberClick("3"));
        btn7.setOnClickListener(view -> onOperatorClick("-"));
        btn8.setOnClickListener(view -> onNumberClick("4"));
        btn9.setOnClickListener(view -> onNumberClick("5"));
        btn10.setOnClickListener(view -> onNumberClick("6"));
        btn11.setOnClickListener(view -> onOperatorClick("*"));
        btn12.setOnClickListener(view -> onNumberClick("7"));
        btn13.setOnClickListener(view -> onNumberClick("8"));
        btn14.setOnClickListener(view -> onNumberClick("9"));
        btn15.setOnClickListener(view -> onOperatorClick("/"));

//        btn1.setOnClickListener(v -> {
//                    numDisplay.setText("0");
//                });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}