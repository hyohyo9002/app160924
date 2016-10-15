package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.my.app160924.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw;
    Button bu_login, bu_join;
    MemberService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id= (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bu_login = (Button) findViewById(R.id.bu_login);
        bu_join = (Button) findViewById(R.id.bu_join);
        bu_login.setOnClickListener(this);
        bu_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = et_id.getText().toString();
        String pw = et_pw.getText().toString();
        MemberDTO param = new MemberDTO();

        switch (v.getId()){
            case R.id.bu_login :
                param.setId(id);
                param.setPw(pw);
                MemberDTO result = service.getOne(param);
                if(result == null){
                    Toast.makeText(LoginActivity.this,
                           "는 존재하지 않는 아이디 입니다.",
                            Toast.LENGTH_LONG).show();
                }else if(result.getId().equals(param.getPw())){
                    Toast.makeText(LoginActivity.this,
                            "비밀번호가 일치하지 않습니다.",
                            Toast.LENGTH_LONG).show();
                }else{
                    startActivity(new Intent(LoginActivity.this, ListActivity.class));
                }
                break;
            case R.id.bu_join :
                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }
    }
}
