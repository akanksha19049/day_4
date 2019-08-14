package com.example.day_4;
//how to get refrence from gui elemnts and get asigned values from gui2
//activity lifecycle

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String ROTATE_COUNT="rotate_count";
    private static final String tag="LifeCycleEvents";
    private int rotate_count=0;
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=(TextView)findViewById(R.id.myTextView);
        Log.d(tag, "Inside onCreate: "+rotate_count);
        //Log.i(tag,"on create method is called");
        if(savedInstanceState!=null)
        {
            rotate_count=savedInstanceState.getInt(ROTATE_COUNT);
            Log.d(tag, "onCreate: "+rotate_count);
        }
        else
        {
            rotate_count=0;
        }
    }
    public void onSaveInstancState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("ROTATE_SCORE",rotate_count);
        Log.d(tag,"onSAveInstance()");
    }



    public void onStart()
    {
        super.onStart();
        Log.i(tag,"onstart()");

    }
    public void onRestart()
    {
        super.onRestart();
        Log.i(tag,"onRestart()");

    }
    public void onResume()
    {
        super.onResume();
        Log.i(tag,"onResume()");

    }
    public void onPause()
    {
        super.onPause();
        Log.i(tag,"onPause()");

    }
    public void onStop()
    {
        super.onStop();
        rotate_count++;
        Log.d(tag,"onStop()");
       //we are not restoring any state
        //so rotatecount will not be updated while orientation
    }

    public void onDestroy()
    {
        super.onDestroy();
        if(isFinishing()==true)
            Log.d(tag,"onDestroy()");

    }
}
