package com.example.ubuntu.bookingfriends.db;

/**
 * Created by ubuntu on 17-8-14.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by liangzi on 2017/8/14.
 */

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_USERLIST = "create table UserList ("
            + "Id integer primary key autoincrement, "
            +"AccountName text,"
            +"Nickname text,"
            +"Email text,"
            +"Phone text,"
            +"Address text,"
            +"Password text)";


    public static final String CREATE_BOOKLIST = "create table BookList ("
            + "Id integer primary key autoincrement, "
            +"Name text,"
            +"Author text,"
            +"Label1 text,"
            +"Label2 text,"
            +"Label3 text,"
            +"SharedID integer,"
            +"Description text)";

    private Context mcontext;

    public DataBaseOpenHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        mcontext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_BOOKLIST);
        db.execSQL(CREATE_USERLIST);
    }

    public void onUpgrade(SQLiteDatabase db,int old_version,int new_version){
        switch (old_version){
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }


    }
}


