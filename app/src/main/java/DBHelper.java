import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.DoubleSummaryStatistics;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Login.db";

    public DBHelper( Context context) {
        super(context,"Login.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table  if exists users");


    }

    public Boolean insertData(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=MyDB.insert("users",null,contentValues);
        if(result==-1)return false;
        else
            return true;
    }
    public Boolean checkusernamepassword(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username=? and password=?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username=?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return  false;

    }
}
