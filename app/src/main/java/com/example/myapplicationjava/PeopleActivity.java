package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class PeopleActivity extends AppCompatActivity {

    RadioButton chk_people;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_people);

        RadioGroup peo_case = (RadioGroup) findViewById(R.id.peo_case);
        RadioButton case1 = (RadioButton) findViewById(R.id.peo1);
        RadioButton case2 = (RadioButton) findViewById(R.id.peo2);
        RadioButton case3 = (RadioButton) findViewById(R.id.peo3);
        RadioButton case4 = (RadioButton) findViewById(R.id.peo4);
        RadioButton case5 = (RadioButton) findViewById(R.id.peo5);
        RadioButton case6 = (RadioButton) findViewById(R.id.peo6);
        RadioButton case7 = (RadioButton) findViewById(R.id.peo7);
        RadioButton case8 = (RadioButton) findViewById(R.id.peo8);
        peo_case.check(case1.getId());
        chk_people = case1;

        peo_case.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.peo1:chk_people = case1;break;
                    case R.id.peo2:chk_people = case2;break;
                    case R.id.peo3:chk_people = case3;break;
                    case R.id.peo4:chk_people = case4;break;
                    case R.id.peo5:chk_people = case5;break;
                    case R.id.peo6:chk_people = case6;break;
                    case R.id.peo7:chk_people = case7;break;
                    case R.id.peo8:chk_people = case8;break;
                }
            }
        });
    }
    public void pOnClick(View v){
        Intent finish_intent = new Intent();
        String people = chk_people.getText().toString();
        finish_intent.putExtra("people", people);
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