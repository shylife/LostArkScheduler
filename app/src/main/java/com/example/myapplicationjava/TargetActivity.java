package com.example.myapplicationjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class TargetActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton baltan, viakiss, kukusaitn, abrelshud, chk_target;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_target);

        rg = (RadioGroup) findViewById(R.id.targetGroup);
        baltan = (RadioButton) findViewById(R.id.radioButton);
        viakiss = (RadioButton) findViewById(R.id.radioButton2);
        kukusaitn = (RadioButton) findViewById(R.id.radioButton3);
        abrelshud = (RadioButton) findViewById(R.id.radioButton4);
        rg.check(baltan.getId());
        chk_target = baltan;

        //리스너
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
                    case R.id.radioButton:chk_target = baltan;break;
                    case R.id.radioButton2:chk_target = viakiss;break;
                    case R.id.radioButton3:chk_target = kukusaitn;break;
                    case R.id.radioButton4:chk_target = abrelshud;break;
                }
            }
        });
    }

    public void gOnClick(View v){
        Intent finish_intent = new Intent();
        String target = chk_target.getText().toString();
        finish_intent.putExtra("target", target);
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
