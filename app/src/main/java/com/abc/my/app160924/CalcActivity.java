package com.abc.my.app160924;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_num_1,et_num_2;
    Button bu_plus,bu_minus,bu_multi,bu_div,bu_remainder,bu_equal;
    TextView tv_result;
    int result;
    CalcService service = new CalcServiceImpl();
    CalcDTO cal = new CalcDTO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et_num_1 = (EditText) findViewById(R.id.et_num_1);
        et_num_2 = (EditText) findViewById(R.id.et_num_2);
        bu_plus = (Button) findViewById(R.id.bu_plus);
        bu_minus = (Button) findViewById(R.id.bu_minus);
        bu_multi = (Button) findViewById(R.id.bu_multi);
        bu_div = (Button) findViewById(R.id.bu_div);
        bu_remainder = (Button) findViewById(R.id.bu_remainder);
        bu_equal = (Button) findViewById(R.id.bu_equal);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bu_div.setOnClickListener(this);
        bu_equal.setOnClickListener(this);
        bu_minus.setOnClickListener(this);
        bu_multi.setOnClickListener(this);
        bu_plus.setOnClickListener(this);
        bu_remainder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(et_num_1.getText().toString());
        int num2 = Integer.parseInt(et_num_2.getText().toString());
        cal.setNum1(num1);
        cal.setNum2(num2);
        switch(v.getId()) {
            case R.id.bu_plus :
                result = service.plus(cal).getResult();
                break;
            case R.id.bu_minus :
                result = num1 - num2;
                break;
            case R.id.bu_multi :
                result = num1 * num2;
                break;
            case R.id.bu_div :
                result = num1 / num2;
                break;
            case R.id.bu_remainder :
                result = num1 % num2;
                break;
            case R.id.bu_equal :
                tv_result.setText("계산 결과 :" + result);
                break;
        }
    }
}
