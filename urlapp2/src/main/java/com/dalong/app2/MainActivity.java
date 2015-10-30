package com.dalong.app2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=(TextView)findViewById(R.id.textView);


        Intent intent=getIntent();
        String name="";
        String age="";
        if(intent!=null){
            /**************通过intent启动*******************/
            name=intent.getStringExtra("name");
            age=intent.getStringExtra("age");
            String action = intent.getAction();

            /**************通过scheme 启动*******************/
            if(Intent.ACTION_VIEW.equals(action)){
                Uri uri = intent.getData();
                if(uri != null){
                     name = uri.getQueryParameter("name");
                     age= uri.getQueryParameter("age");
                }
            }
            textView.setText(name+"\n"+age);
        }
    }

}
