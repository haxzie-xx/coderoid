package com.aeiton.androidworkshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectionFragment extends Fragment {

    CheckBox cb1, cb2, cb3, cb4;
    Spinner s;

    public SelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        cb1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        cb2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        cb3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        cb4 = (CheckBox) rootView.findViewById(R.id.checkBox4);

        s = (Spinner) rootView.findViewById(R.id.spinner);

        List<String> elements = new ArrayList<String>();
        elements.add("Orange");
        elements.add("PineApple");
        elements.add("Pappaya");
        elements.add("JackFruit");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, elements);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(ad);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked())
                toastMessage();
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb2.isChecked())
                    toastMessage();
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb3.isChecked())
                    toastMessage();
            }
        });

        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb4.isChecked())
                    toastMessage();
            }
        });


        return rootView;
    }


    public void toastMessage(){

        String message = "";

        if (cb1.isChecked()){
            message+=" cb1 ";
        }
        if (cb2.isChecked()){
            message+=" cb2 ";
        }
        if (cb3.isChecked()){
            message+=" cb3 ";
        }
        if (cb4.isChecked()){
            message+=" cb4 ";
        }


        if (!message.matches("")){
            Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
        }

}




}
