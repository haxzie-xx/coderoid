package com.aeiton.androidworkshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleCalculator extends Fragment {

    Button plus, minus;
    Integer num = 0;
    TextView answer;
    public SimpleCalculator() {
        // Required empty public constructor
    }

    public static SimpleCalculator getInstance(){
        SimpleCalculator instance = new SimpleCalculator();
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_simple_calculator, container, false);

        plus = (Button) v.findViewById(R.id.plus);
        minus = (Button) v.findViewById(R.id.minus);
        answer = (TextView) v.findViewById(R.id.number);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                answer.setText(num.toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num>0){
                    num--;
                    answer.setText(num.toString());
                }
            }
        });


        return v;
    }

}
