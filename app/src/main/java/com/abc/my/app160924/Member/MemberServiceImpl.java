package com.abc.my.app160924.Member;

import android.content.Context;
import android.util.Log;

import com.abc.my.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService  {
    /*DAO에 대한 정보를 가지고와*/
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i("=== SERVICE에서 받은 ID : ",param.getId());
        Log.i("=== SERVICE에서 받은 PW : ",param.getPw());
        MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if(member == null){
            member.setId("NONE");
            return member;
        }else if(member.getPw().equals(param.getPw())){
            return member;
        }else{
            member.setId("NO_MATCH");
            return member;
        }

    }

    @Override
    public Retval join(MemberDTO param) {
        Log.i("SERVICE에서 받은 ID : ",param.getId());
        Log.i("SERVICE에서 받은 PW : ",param.getPw());
        Log.i("SERVICE에서 받은 name : ",param.getName());
        Log.i("SERVICE에서 받은 addr : ",param.getAddr());
        Log.i("SERVICE에서 받은 email : ",param.getEmail());
        Log.i("SERVICE에서 받은 phone : ",param.getPhone());
        return dao.insert(param);
    }
}
