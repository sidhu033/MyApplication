package com.example.user.myapplication;

import android.widget.ExpandableListView;

import com.example.user.myapplication.activity.ScrollingActivity;

import java.util.HashMap;
import java.util.List;

public class MenuVo
{

     public int img;
     public String imgName;

    public MenuVo(int img, String imgName)
    {
        this.img = img;
        this.imgName = imgName;
    }
    public void setImg(int img) {

        this.img = img;
    }

    public int getImg() {

        return img;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }

    public String getImgName() {

        return imgName;
    }


    @Override
    public String toString()
    {
        return "MenuVo{" +
                "img=" + img +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
