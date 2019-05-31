package com.example.user.myapplication;


public enum ModelObject {

    RED(R.string.redoxer, R.layout.view_red),       //1st slider dots color
    BLUE(R.string.redoxer, R.layout.redoxer_2),     //2nd slider dots color
    GREEN(R.string.redoxer, R.layout.redoxer_3);    //3rd slider dots color


    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;

    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }


}
