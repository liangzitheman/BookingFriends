package com.example.ubuntu.bookingfriends.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.example.ubuntu.bookingfriends.model.Book;
import com.example.ubuntu.bookingfriends.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzi on 2017/8/14.
 */

public class DataBaseManager {

    /**
     * 数据库名
     */
    public static final String DB_NAME = "DataBase.db";
    /**
     * 数据库版本
     */
    public static final int VERSION = 1;

    private static DataBaseManager dataBaseManager;
    private SQLiteDatabase db;

    /**
     * 将构造方法私有化
     */
    private DataBaseManager(Context context) {
        DataBaseOpenHelper dbHelper = new DataBaseOpenHelper(context,
                DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * 获取DataBaseManager的实例。
     */
    public synchronized static DataBaseManager getInstance(Context context) {
        if (dataBaseManager == null) {
            dataBaseManager = new DataBaseManager(context);
        }
        return dataBaseManager;
    }




    /**
     * 将User实例存到数据库表UserList。
     */
    public int addUser(User user) {
        int result = -1;
        if (user != null) {
            ContentValues values = new ContentValues();
            values.put("AccountName", user.getAccountName());
            values.put("Nickname", user.getNickname());
            values.put("Email", user.getEmail());
            values.put("Phone", user.getPhone());
            values.put("Address", user.getAddress());
            values.put("Password", user.getPassword());

            result = (int) db.insert("UserList", null, values);
        }
        return result;
    }


    /**
     * 将User实例存到数据库表UserList。
     */
    public boolean updateUser(User user) {
        boolean result = false;
        if (user != null) {
            ContentValues values = new ContentValues();
            values.put("Password", user.getPassword());
            int row = db.update("UserList", values,"AccountName=?", new String[]{user.getAccountName()});
            if (row >0){
                result = true;
            }

        }
        return result;
    }




    /**
     * 根据User 的AccountName 和 Password 来查询UserList中是否存在该用户。
     * 返回1代表合法
     * 返回-1代表非法
     */
    public int findUserByNameAndPwd(String AccountName,String Password) {
        int result = -1;
        Cursor cursor = db.query("UserList", null, "AccountName=? and Password=?",
                new String[]{AccountName,Password}, null, null, null);
        if (cursor.moveToFirst()) {
            result = 1;
            cursor.close();
            return result;
        }//如果查询到已经存在该账户，则返回1
        cursor.close();
        return result;
    }


    /**
     * 根据User 的AccountName来查询UserList中是否存在该用户。
     * 返回1代表已经存在
     * 返回-1代表不存在
     */
    public int findUserByName(String AccountName) {
        int result = -1;
        Cursor cursor = db.query("UserList", null, "AccountName=?",
                new String[]{AccountName}, null, null, null);
        if (cursor.moveToFirst()) {
            result = 1;
            cursor.close();
            return result;
        }//如果查询到已经存在该账户，则返回1
        cursor.close();
        return result;
    }


    /**
     * 根据User 的AccountName 和 Password 来查询UserList中是否存在该用户。
     * 返回1代表合法
     * 返回-1代表非法
     */
    public void deleteUserDatabyname(String AccountName) {
        db.delete("UserList", "AccountName=?", new String[] {AccountName});
    }



    /**
     * 将Book实例存储到数据库表BookList。
     * 判断是否有重复的Name和SharedID，若没有则插入表格
     * 若有，则返回-1
     */
    public int addBook(Book book) {
        int id = -1;
        if (book != null) {
            if(!TextUtils.isEmpty(book.getName())&&!TextUtils.isEmpty(String.valueOf(book.getSharedID()))) {
                Cursor cursor = db.query("BookList", null, "Name=? and SharedID=?",
                        new String[]{book.Name, String.valueOf(book.getSharedID())}, null, null, null);
                if (cursor.moveToFirst()) {
                    cursor.close();
                    return id;
                }//如果有重复，则返回-1
                cursor.close();
            }
            if(!TextUtils.isEmpty(book.getName())&&TextUtils.isEmpty(String.valueOf(book.getSharedID()))){
                Cursor cursor = db.query("BookList",null,"Name=? and SharedID is null",new String[]{book.getName()},null,null,null);
                if (cursor.moveToFirst()) {
                    cursor.close();
                    return id;
                }//如果有重复，则返回-1
                cursor.close();
            }
            ContentValues values = new ContentValues();
            values.put("Name", book.getName());
            values.put("Author", book.getAuthor());
            values.put("Label1", book.getLabel1());
            values.put("Label2", book.getLabel2());
            values.put("Label3", book.getLabel3());
            values.put("SharedID", book.getSharedID());
            values.put("Description", book.getDescription());



            id= (int) db.insert("BookList", null, values);
        }
        return id;
    }



    /**
     * 从表BookList中读取所有书本信息。
     */
    public List<Book> loadBookList() {
        List<Book> list = new ArrayList<Book>();
        Cursor cursor = db
                .query("BookList", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setID(cursor.getInt(cursor.getColumnIndex("ID")));
                book.setName(cursor.getString(cursor.getColumnIndex("Name")));
                book.setAuthor(cursor.getString(cursor.getColumnIndex("Author")));
                book.setLabel1(cursor.getString(cursor.getColumnIndex("Label1")));
                book.setLabel2(cursor.getString(cursor.getColumnIndex("Label2")));
                book.setLabel3(cursor.getString(cursor.getColumnIndex("Label3")));
                book.setSharedID(cursor.getInt(cursor.getColumnIndex("SharedID")));
                book.setDescription(cursor.getString(cursor.getColumnIndex("Description")));


                list.add(book);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return list;
    }



    /**
     *根据ID来更新数据库表格BookList中的某本书的Description。
     */
    public void updateBook(String Description,int updateRow){
        ContentValues values = new ContentValues();
        values.put("Description",Description);
        db.update("BookList", values,"ID=?", new String[] { Integer.toString(updateRow) });
    }



    /**
     * 从表格BookList中根据Id删除某条记录。
     */
    public void deleteBook(int deleterow){
        db.delete("BookList", "Id=?", new String[] { Integer.toString(deleterow) });
    }

}

