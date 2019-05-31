package com.example.user.myapplication.pojo;

public class HMeterDataObject
{
    private int id;
    private  String mText1;
    private  String mText2;

    public HMeterDataObject(int id,String mText1, String mText2)
    {
        this.id = id;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {

        return id;
    }

    public String getmText1()
    {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText1(String mText1)
    {
        this.mText1 = mText1;
    }

    public void setmText2(String mText2)
    {
        this.mText2 = mText2;
    }
}
