package com.aeiton.androidworkshop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    Button simple, bgcolor, custom;


    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_button, container, false);

            simple = (Button) rootView.findViewById(R.id.simple_button);
            simple.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"Simple button",Toast.LENGTH_LONG).show();
                }
            });

        bgcolor = (Button) rootView.findViewById(R.id.bg_button);
        bgcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"bg color button",Toast.LENGTH_LONG).show();
            }
        });

        custom = (Button) rootView.findViewById(R.id.custom_bg);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"custom bg button",Toast.LENGTH_LONG).show();
            }
        });


        return rootView;
    }

}
