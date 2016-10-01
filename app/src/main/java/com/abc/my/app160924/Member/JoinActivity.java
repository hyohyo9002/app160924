package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.my.app160924.MainActivity;
import com.abc.my.app160924.R;
import com.abc.my.app160924.util.Retval;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw, et_name, et_email, et_addr, et_phone;
    Button bu_submit, bu_cancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id= (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bu_submit = (Button) findViewById(R.id.bu_submit);
        bu_cancel = (Button) findViewById(R.id.bu_cancel);
        bu_submit.setOnClickListener(this);
        bu_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MemberDTO member = new MemberDTO();
        member.setId(et_id.getText().toString());
        member.setPw(et_pw.getText().toString());
        member.setName(et_name.getText().toString());
        member.setEmail(et_email.getText().toString());
        member.setAddr(et_addr.getText().toString());
        member.setPhone(et_phone.getText().toString());
        switch(v.getId()){
            case R.id.bu_submit:
                Retval val = service.join(member);
                if(val.getMassage().equals("SUCCESS")) {
                    Toast.makeText(JoinActivity.this,
                            "회원가입 성공!! 로그인 바랍니다.",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(JoinActivity.this,
                            "회원가입 실패!! 재시도 바랍니다.",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bu_cancel:
                startActivity(new Intent(JoinActivity.this, MainActivity.class));
                break;
        }
    }
}
