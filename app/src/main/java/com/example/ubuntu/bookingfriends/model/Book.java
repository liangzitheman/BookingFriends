package com.example.ubuntu.bookingfriends.model;


/**
 * Created by liangzi on 17-7-7.
 */
public class Book{
    /**
     * ID : 1
     * Name : the lost horizon
     * Author : He Wei
     * Label1 : 文学，传记，小说...
     * Label2 : 文学，传记，小说...
     * Label3 : 文学，传记，小说...
     * SharedID : 1
     * Description : 娓娓道来的心事，适合闲暇时光，在不需要加班的周末的午后，从厚重的窗帘里溜进来慵懒的阳光，正如慵懒的你
     */
    public int ID;

    public String Name;

    public String Author;

    public String Label1;

    public String Label2;

    public String Label3;

    public int SharedID;

    public String Description;

    public Book(){
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }


    public String getLabel1() {
        return Label1;
    }

    public void setLabel1(String Label) {
        this.Label1 = Label;
    }

    public String getLabel2() {
        return Label2;
    }

    public void setLabel2(String Label) {
        this.Label2 = Label;
    }

    public String getLabel3() {
        return Label3;
    }

    public void setLabel3(String Label) {
        this.Label3 = Label;
    }


    public int getSharedID() {
        return SharedID;
    }

    public void setSharedID(int SharedID) {
        this.SharedID = SharedID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
