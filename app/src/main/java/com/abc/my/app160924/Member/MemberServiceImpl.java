package com.abc.my.app160924.Member;

import android.content.Context;

import java.util.ArrayList;

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
    public void regist(MemberDTO member) {
        dao.insert(member);
    }

    @Override
    public ArrayList<MemberDTO> getlist() {

        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> getListByName(MemberDTO member) {
        return dao.selectListByName(member);
    }

    @Override
    public MemberDTO getOne(MemberDTO member) {
        return dao.selectOne(member);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO member) {
        dao.update(member);
    }

    @Override
    public void unregist(MemberDTO member) {
        dao.delete(member);
    }
}
