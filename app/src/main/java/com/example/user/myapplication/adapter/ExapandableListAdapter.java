package com.example.user.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.user.myapplication.R;
import com.example.user.myapplication.pojo.ExpandableMenuModel;
import com.example.user.myapplication.pojo.MenuModel;

import java.util.HashMap;
import java.util.List;

public class ExapandableListAdapter extends BaseExpandableListAdapter
{
    private Context context;
    private List<ExpandableMenuModel> listDataHeader;                     //header Titles
    private HashMap<ExpandableMenuModel, List<String>> listDataChild;   // child data in format of header title, child title
    ExpandableListView expandableListView;

    //intitlization of titles
    public ExapandableListAdapter(Context context, List<ExpandableMenuModel> listDataHeader, HashMap<ExpandableMenuModel, List<String>> listChildData, ExpandableListView expandableListView)
    {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
        this.expandableListView = expandableListView;
    }

    @Override
    public int getGroupCount()
    {
        int i = listDataHeader.size();              //size of header title
        Log.d("GROUPCOUNT", String.valueOf(i));
        return this.listDataHeader.size();

    }
    //return child count
    @Override
    public int getChildrenCount(int groupPosition)
    {
        int childCount = 0;
        if (groupPosition != 2)
        {
            childCount = this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
        }
        return childCount;
    }
    //get group postition
    @Override
    public Object getGroup(int groupPosition)
    {
        return this.listDataHeader.get(groupPosition);
    }

    //get child postition
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        Log.d("CHILD", listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition).toString());
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {

        ExpandableMenuModel headerTitle = (ExpandableMenuModel) getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = infalInflater.inflate(R.layout.list_header,null);         //inflate listhead

            TextView lblListHeader = (TextView) convertView.findViewById(R.id.submenu);     //setting submenus
            lblListHeader.setText(headerTitle.getIconName());
            return convertView;
        }
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChildb, View convertView   , ViewGroup parent)
    {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_submenu, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.submenu);
        txtListChild.setText(childText);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition  , int childPosition)
    {
          return true;
    }
}
