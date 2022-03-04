package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class TimeActivity extends AppCompatActivity {

    int hour = 0, min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_time);

        Calendar calendar = new GregorianCalendar();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        TimePicker timePicker = findViewById(R.id.vTimeEnter);

        timePicker.setIs24HourView(false);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int cg_hour, int cg_min) {
                hour = cg_hour;
                min = cg_min;
            }
        });
    }

    public void tOnClick(View v){
        Intent finish_intent = new Intent();
        finish_intent.putExtra("hour", hour);
        finish_intent.putExtra("min", min);

        setResult(RESULT_OK, finish_intent);
        finish();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if( event.getAction() == MotionEvent.ACTION_OUTSIDE ){
            return false;
        }
        return true;
    }
}



/*

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

            }
        });
    }

 */
