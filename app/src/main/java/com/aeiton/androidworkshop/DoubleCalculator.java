package com.aeiton.androidworkshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoubleCalculator extends Fragment {


    Button plus, minus, multiply, divide;
    EditText num1, num2;
    TextView answer;

    public DoubleCalculator() {
        // Required empty public constructor
    }

    public static DoubleCalculator getInstance(){
        return new DoubleCalculator();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_double_calculator, container, false);

        plus = (Button) v.findViewById(R.id.plus);
        minus = (Button) v.findViewById(R.id.minus);
        multiply = (Button) v.findViewById(R.id.multiply);
        divide = (Button) v.findViewById(R.id.divide);
        num1 = (EditText) v.findViewById(R.id.number1);
        num2 = (EditText) v.findViewById(R.id.number2);
        answer = (TextView) v.findViewById(R.id.answer);

        Toast.makeText(getContext(),"Find the bug in calculator and fix it. Tip: validate the inputs and set limits",Toast.LENGTH_SHORT).show();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float a = Float.valueOf(num1.getText().toString());
                float b = Float.valueOf(num2.getText().toString());

                answer.setText(calculator(a,b,1).toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float a = Float.valueOf(num1.getText().toString());
                float b = Float.valueOf(num2.getText().toString());

                answer.setText(calculator(a,b,2).toString());
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float a = Float.valueOf(num1.getText().toString());
                float b = Float.valueOf(num2.getText().toString());

                answer.setText(calculator(a,b,3).toString());
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float a = Float.valueOf(num1.getText().toString());
                float b = Float.valueOf(num2.getText().toString());

                answer.setText(calculator(a,b,4).toString());
            }
        });

        return v;
    }

    public Float calculator(float a, float b, int ch){
        switch (ch){
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                return a/b;
            default:
                Toast.makeText(getContext(),"Invalid Number",Toast.LENGTH_SHORT).show();
        }

        return null;
    }
}
