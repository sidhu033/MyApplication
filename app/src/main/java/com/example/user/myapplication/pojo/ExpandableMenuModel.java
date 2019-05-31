package com.example.user.myapplication.pojo;

import android.graphics.Color;
import android.widget.ExpandableListView;

import com.example.user.myapplication.MenuVo;
import com.example.user.myapplication.activity.ScrollingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableMenuModel
{

    String iconName = "";
    int iconNameColor ;

    // int iconImg = -1; // menu icon resource id

    public void setIconNameColor(int iconNameColor) {
        this.iconNameColor = iconNameColor;
    }

    public String getIconName()
    {
        return iconName;
    }
    public void setIconName(String iconName)
    {
        this.iconName = iconName;
    }
  /* public int getIconImg() {
        return iconImg;
    }
    public void setIconImg(int iconImg) {
        this.iconImg = iconImg;
    }*/
}
