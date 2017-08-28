package com.aeiton.androidworkshop;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    EditText etxt_url;
    Button go;
    WebView wv;
    ProgressBar pb;


    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view, container, false);

        etxt_url = (EditText) v.findViewById(R.id.etxt_url);
        go = (Button) v.findViewById(R.id.btn);
        wv = (WebView) v.findViewById(R.id.webview);
        pb = (ProgressBar) v.findViewById(R.id.progress);

        wv.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                etxt_url.setText(url);
                pb.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pb.setVisibility(View.GONE);
            }
        });
//        wv.loadUrl("http://google.co.in");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = etxt_url.getText().toString();
                if (!url.matches("")) {
                    if (!url.contains("http://"))
                        url = "http://" + url;
                    wv.loadUrl(url);
                }
            }
        });

        return v;
    }

}
