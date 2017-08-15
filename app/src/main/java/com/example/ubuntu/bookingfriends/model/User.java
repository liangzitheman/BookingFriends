package com.example.ubuntu.bookingfriends.model;



/**
 * Created by liangzi on 17-7-7.
 */
public class User{
    /**
     * ID : 1
     * AccountName : HeWei
     * Nickname : the son of wind
     * Email : csdn@bolg.com
     * Phone : 17765456789
     * Address : 浦东新区科员路278号
     * Password : ##￥￥￥%@
     */
    public int ID;

    public String  AccountName;

    public String  Nickname;

    public String Email;

    public String Phone;

    public String Address;

    public String Password;

    public User(){
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}

