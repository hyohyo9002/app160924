package com.abc.my.app160924.Member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public static final String DB_NAME ="hanbit.db";
    public static final int DB_VERSION= 1;
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileImg";
    public static final String TABLE_NAME = "member";

    public MemberDAO (Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        //위치값, 만들려는 db의 이름, 팩토리 기본값null, 버전
        this.getWritableDatabase(); // 입력가능한 DB로 만들어라
        Log.d("DB가 만들어지면 이 글이 보일것임.", "성공!!");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "create table if not exists member ("
                +"id text primary key,"
                +"pw   text,"
                +"name text,"
                +"email text,"
                +"addr text,"
                +"phone text,"
                +"profileImg text)");
        db.execSQL( "insert into member(id, pw, name, email, addr, phone, profileImg)"
                    +"values"
                    +"('hong1','1','홍일동','hong1@gmail.com','서울','010-1111-1111','default.jpg');");
        db.execSQL( "insert into member(id, pw, name, email, addr, phone, profileImg)"
                +"values"
                +"('hong2','1','홍이동','hong1@gmail.com','서울','010-1111-1111','default.jpg');");
        db.execSQL( "insert into member(id, pw, name, email, addr, phone, profileImg)"
                +"values"
                +"('hong3','1','홍삼동','hong1@gmail.com','서울','010-1111-1111','default.jpg');");
        db.execSQL( "insert into member(id, pw, name, email, addr, phone, profileImg)"
                +"values"
                +"('hong4','1','홍사동','hong1@gmail.com','서울','010-1111-1111','default.jpg');");
        db.execSQL( "insert into member(id, pw, name, email, addr, phone, profileImg)"
                +"values"
                +"('hong5','1','홍오동','hong1@gmail.com','37.5597680,126.9423080','010-1111-1111','default.jpg');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values(null,'android_6.0.0',1);");
        db.execSQL("insert into Android values(null,'android_6.0.1',2);");
        this.onCreate(db);
    }

//DML (CREATE)
public void insert(MemberDTO param){
    Log.i("insert ","진입");
    String sql = "insert into "+TABLE_NAME
            +String.format("(%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
            +String.format(" values('%s','%s','%s','%s','%s','%s','%s')"
            ,param.getId(),param.getPw(),param.getName(),param.getEmail(),param.getAddr(),param.getPhone(),param.getProfileImg());
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql);
    db.close();

}
//DML (READ)
public ArrayList<MemberDTO> selectList(){
    Log.i("selectList ","진입");
    String sql ="select "+
            String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
            +" from member;";
    SQLiteDatabase db  = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(sql,null);
    ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
    if(cursor != null){
        Log.i("DAO list 조회결과","success");
        cursor.moveToFirst(); //처음커서로 가면서 복사하듯이 블럭을 잡아라
    }
    do{
        MemberDTO temp = new MemberDTO();
        temp.setId(cursor.getString(0));
        temp.setPw(cursor.getString(1));
        temp.setName(cursor.getString(2));
        temp.setEmail(cursor.getString(3));
        temp.setAddr(cursor.getString(4));
        temp.setPhone(cursor.getString(5));
        temp.setProfileImg(cursor.getString(6));
        list.add(temp);
    }while(cursor.moveToNext());

    return list;
}
    public ArrayList<MemberDTO> selectListByName(MemberDTO param){
        Log.i("selectListByName ","진입");
        String sql ="select "+
                String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +String.format(" from %s where %s = '%s';",TABLE_NAME,NAME,param.getName());
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        if(cursor != null){
            Log.i("ByName 조회결과","success");
            cursor.moveToFirst(); //처음커서로 가면서 복사하듯이 블럭을 잡아라
        }
        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
            list.add(temp);
        }while(cursor.moveToNext());

        return list;
    }
    public MemberDTO selectOne(MemberDTO param){
        Log.i("selectOne id 조회 ","진입");
        String sql ="select "+
                String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +String.format(" from %s where %s = '%s';",TABLE_NAME,ID,param.getId());
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        MemberDTO temp = null;
        if(cursor.moveToNext()){
            Log.i("DAO ID 조회결과","ID 존재함");
            temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
        }
        return temp;
    }
    public int  count(){
        Log.i("=========count : ","진입");
        String sql ="select count(*) as count from member;";
        SQLiteDatabase db  = this.getReadableDatabase();
       int count = 0;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            Log.i("DAO ID 조회결과","ID 존재함");
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }

//DML (UPDATE)
public void update(MemberDTO param){
    Log.i("=========update : ","진입");
    String sql ="update member set "+
            String.format("%s = '%s'",PW,param.getPw())
            +String.format("%s = '%s'",EMAIL,param.getEmail())
            +String.format("%s = '%s'",ADDR, param.getAddr())
            +String.format("%s = '%s'",PHOTO, param.getProfileImg())
            +String.format(" where %s = '%s';",ID ,param.getId());
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql);
    db.close();
}

//DML (DELETE)
public void delete(MemberDTO param){
    Log.i("=========delete : ","진입");
    String sql ="delete from member "
            +String.format(" where %s = '%s';",ID ,param.getId());
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql);
    db.close();
}

}
