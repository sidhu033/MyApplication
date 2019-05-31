package com.example.user.myapplication.pojo;

/**
 * Created by anupamchugh on 22/12/17.
 */

public class MenuModel
{

    public boolean hasChildren, isGroup;

    public MenuModel( boolean isGroup, boolean hasChildren, String url)
    {
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}
