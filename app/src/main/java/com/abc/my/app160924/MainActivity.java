package com.abc.my.app160924;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abc.my.app160924.Calc.CalcActivity;
import com.abc.my.app160924.Member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bu_calc, bu_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu_calc = (Button) findViewById(R.id.bu_calc);
        bu_contacts = (Button) findViewById(R.id.bu_contacts);
        bu_calc.setOnClickListener(this);
        bu_contacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bu_calc:
                startActivity(new Intent(MainActivity.this, CalcActivity.class));
                break;
            case R.id.bu_contacts:
                Toast.makeText(MainActivity.this,"주소록가기",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }
}
