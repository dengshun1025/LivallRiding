package com.example.dengshun.test.Demo.Adapter;

/**
 *
 * Created by dengshun on 2016/7/25.
 *
 */
public class MyListItem {

    public String getTxt() {
        return txt;
    }

    public int getImgTwoId() {
        return imgTwoId;
    }

    public int getImgOneId() {
        return imgOneId;
    }

    private String txt;
    private int imgOneId;
    private int imgTwoId;

    public MyListItem(int imgOneId,String txt,int imgTwoId){
        this.imgOneId = imgOneId;
        this.txt = txt;
        this.imgTwoId = imgTwoId;
    }
}
