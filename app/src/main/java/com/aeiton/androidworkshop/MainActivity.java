package com.aeiton.androidworkshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    boolean doublepressonce = false;



    FragmentManager fragmentManager;
    Fragment fragment;
    Class fragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Setting the default fragment to view in user home
        fragment = new Fragment();
        fragmentClass = HomeFragment.class;
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (doublepressonce) {
                super.onBackPressed();
                return;
            }
            this.doublepressonce = true;
            Toast.makeText(this, "Press again to Exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublepressonce = false;
                }
            }, 1500);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        fragment = new Fragment();
        Class fragmentClass = null;
        fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_home) {
            // Handle the camera action
            fragmentClass = HomeFragment.class;
        } else if (id == R.id.nav_buttons) {

            fragmentClass = ButtonFragment.class;
        } else if (id == R.id.nav_checkbox) {

            fragmentClass = SelectionFragment.class;

        }else if (id == R.id.textviews) {

            fragmentClass = TextViewFragment.class;

        } else if (id == R.id.popup) {

            fragmentClass = PopupFragment.class;
        }else if (id == R.id.webviews) {

            fragmentClass = WebViewFragment.class;
        }else if (id == R.id.list) {

            fragmentClass = ListViewFragment.class;
        }else if (id == R.id.calculator){
            startActivity(new Intent(MainActivity.this,CalculatorAssignment.class));
            return true;
        }else if (id == R.id.recycler){
            startActivity(new Intent(MainActivity.this,CustomRecyclerActivity.class));
            return true;
        }else if (id == R.id.about){
            startActivity(new Intent(MainActivity.this,AboutUsActivity.class));
            return true;
        }else if (id == R.id.feedback){
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"aeitonlabs@email.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Workshop Feedback");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            return true;
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            Log.i("AW","Failed @ fragment transaction exeption");
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
