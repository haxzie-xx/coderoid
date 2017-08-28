package com.aeiton.androidworkshop;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopupFragment extends Fragment {

    TextView btnToast, btnSnack, btnDialog, btnProgress;
    FrameLayout parent;

    public PopupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_popup, container, false);

        parent = (FrameLayout) v.findViewById(R.id.parent);

        btnDialog = (TextView) v.findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Alert Dialog")
                        .setMessage("This is an Alert Dialog")
                        .setPositiveButton("GOT IT !",null)
                        .setCancelable(true)
                        .show();
            }
        });

        btnSnack = (TextView) v.findViewById(R.id.btn_snack);
        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(parent,"This is a Snackbar !",Snackbar.LENGTH_SHORT).show();
            }
        });

        btnToast = (TextView) v.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Toast is ready !",Toast.LENGTH_SHORT).show();
            }
        });

        btnProgress = (TextView) v.findViewById(R.id.progress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog pd = new ProgressDialog(getContext());
                pd.setTitle("Progress Dialog");
                pd.setMessage("Loading infinity...");
                pd.setCancelable(true);
                pd.show();
            }
        });
        return v;
    }

}
