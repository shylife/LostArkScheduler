package com.example.myapplicationjava;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class ActivityText extends AppCompatActivity {


    private DatePickerDialog.OnDateSetListener callbackMethod;

    TextView vTarget, vDate, vTime, vPeo;
    Button bt_set_date, bt_set_time, bt_set_peo, bt_set_target;
    Calendar cal;

    Button bt_get_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        vTarget = (TextView) findViewById(R.id.editTextTarget);
        vDate = (TextView) findViewById(R.id.editTextDate);
        vTime = (TextView) findViewById(R.id.editTextTime);
        vPeo  = (TextView) findViewById(R.id.editTextPeople);
        bt_set_date = (Button) findViewById(R.id.date);
        bt_get_date = (Button) findViewById(R.id.vDateEnter);
        bt_set_target = (Button) findViewById(R.id.target);
        cal = Calendar.getInstance();

//      vDate.setText(cal.get(Calendar.YEAR) +"-"+ (cal.get(Calendar.MONTH)+1) +"-"+ cal.get(Calendar.DATE));
//      vTime.setText(cal.get(Calendar.HOUR_OF_DAY) +":"+ (cal.get(Calendar.MINUTE)));
//      vPeo.setText ("현재 인원");
    }



    ActivityResultLauncher<Intent> Day_setActResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();
                int mYear = intent.getIntExtra("mYear",1234);
                int mMonth = intent.getIntExtra("mMonth",1234);
                int mDay = intent.getIntExtra("mDay",1234);
                vDate.setText(mYear +"-"+ (mMonth+1) +"-"+ mDay);
            }
        });
    ActivityResultLauncher<Intent> Time_setActResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();
                int hour = intent.getIntExtra("hour",12);
                int min = intent.getIntExtra("min",12);
                vTime.setText(hour +":"+ min);
            }
        });
    ActivityResultLauncher<Intent> Target_setActResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    String who = intent.getStringExtra("target");
                    vTarget.setText(who);
                    //Toast.makeText(this, who, Toast.LENGTH_SHORT).show();
                }
            });
    ActivityResultLauncher<Intent> People_setActResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    String people = intent.getStringExtra("people");
                    vPeo.setText(people +"명");
                    //Toast.makeText(this, who, Toast.LENGTH_SHORT).show();
                }
            });
    public void at_OnClick(View v){
        // launcher 이용해서 화면 시작하기
        Intent intent = new Intent(this, TempActivity.class);
        Day_setActResultLauncher.launch(intent);
    }
    public void tOnClick(View v){
        Intent intent = new Intent(this, TimeActivity.class);
        Time_setActResultLauncher.launch(intent);
    }
    public void gOnClick(View v){
        Intent intent = new Intent(this, TargetActivity.class);
        Target_setActResultLauncher.launch(intent);
    }
    public void pOnClick(View v){
        Intent intent = new Intent(this, PeopleActivity.class);
        People_setActResultLauncher.launch(intent);
    }
    public void fin_OnClick(View v){
        Intent finish_intent = new Intent();
//      finish_intent.putExtra("mYear", mYear);
//      finish_intent.putExtra("mMonth", mMonth);
//      finish_intent.putExtra("mDay", mDay);

        setResult(RESULT_OK, finish_intent);
        finish();
    }
}
