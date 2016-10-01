package com.abc.my.app160924.Member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO {
    public MemberDTO select(MemberDTO param){
        Log.i("=========DAO에서 받은 ID : ",param.getId());
        Log.i("=========DAO에서 받은 PW : ",param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("hong");
        member.setPw("1");
        member.setName("홍길동");
        /*임시값으로 넣어놨다..DB는 아직*/
        return member;
    }
    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
}
