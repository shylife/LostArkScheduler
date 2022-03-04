package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TempActivity extends AppCompatActivity {

    int mYear =0, mMonth=0, mDay=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_temp);

        Calendar calendar = new GregorianCalendar();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePicker datePicker = findViewById(R.id.vDatePicker);
        datePicker.init(mYear, mMonth, mDay, mOnDateChangedListener);


    }
    DatePicker.OnDateChangedListener mOnDateChangedListener = new DatePicker.OnDateChangedListener(){
        @Override
        public void onDateChanged(DatePicker datePicker, int yy, int mm, int dd){
            mYear = yy;
            mMonth = mm;
            mDay = dd;
        }
    };

    public void mOnClick(View v){
        Intent finish_intent = new Intent();
        finish_intent.putExtra("mYear", mYear);
        finish_intent.putExtra("mMonth", mMonth);
        finish_intent.putExtra("mDay", mDay);

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
