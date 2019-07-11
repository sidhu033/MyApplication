package com.example.user.myapplication.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.MenuVo;
import com.example.user.myapplication.R;
import com.example.user.myapplication.activity.ForgotPin;
import com.example.user.myapplication.activity.HealthMone;
import com.example.user.myapplication.activity.MainActivity;
import com.example.user.myapplication.activity.Pin;
import com.example.user.myapplication.activity.PurchaseActivity;
import com.example.user.myapplication.activity.PurchaseActivity1;
import com.example.user.myapplication.activity.ScrollingActivity;
import com.example.user.myapplication.activity.Setting;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenusHolder>
{

    private List<MenuVo> mMenuList;
    private Activity mActivity;
    private LinearLayout main;
    int resource;
    LayoutInflater li;
    AlertDialog.Builder builder;

    public MenusAdapter(List<MenuVo> mMenuList, Activity mActivity )
    {
        this.mMenuList = mMenuList;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public MenusHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        //bind layout menes
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_menu2, viewGroup, false);
        return new MenusHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenusHolder viewHolder, final int position)
    {
       MenuVo menuVo = mMenuList.get(position);
       viewHolder.img.setImageResource(menuVo.img);
       viewHolder.txtImgName.setText(menuVo.imgName);

        builder = new AlertDialog.Builder(mActivity);
        viewHolder.txtImgName.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
              if(position==0)
               {
                   builder = new AlertDialog.Builder(mActivity,R.style.MyDialogTheme);
                   builder.setMessage("Do You Have Device ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i)
                       {
                           mActivity.startActivity(new Intent(mActivity.getApplicationContext(), Pin.class));

                       }
                   }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i)
                       {
                           dialogInterface.cancel();
                           Intent intent = new Intent(mActivity.getApplicationContext(), MainActivity.class);
                           intent.putExtra("isDevice",true);

                            mActivity.startActivity(intent);
                       }
                   });
                   AlertDialog alert = builder.create();
                   alert.setTitle("You Cannot Take Treatment Without Device");
                   alert.show();
               }
               else if(position ==1)
               {
                   Intent intent = new Intent(new Intent(mActivity.getApplicationContext(), HealthMone.class));
                   mActivity.startActivity(intent);

               }
               else if(position == 4)
              {
                  Intent settingintent = new Intent(mActivity.getApplicationContext(),Setting.class);
                  mActivity.startActivity(settingintent);
              }
           }
       });

    }

    @Override
    public int getItemCount()
    {
          return mMenuList.size();

    }



    public class MenusHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img ;
        @BindView(R.id.txtImgName)
        TextView txtImgName;

        public MenusHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
          //  itemView.setOnClickListener(this);

            txtImgName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {

                   /* switch(view.getid())
                    {
                        case r.id.treatment:
                            intent intent = new intent(mactivity, pin.class);
                            mactivity.startactivity(intent);
                            break;

                       case r.id.healthtips:
                            intent in = new intent(mactivity,forgotpin.class);
                           mactivity.startactivity(in);
                            break;
                    }
*/
                    /* Intent intent = new Intent(mActivity,Pin.class);
                     mActivity.startActivity(intent);*/
                }
            });

           /* main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   //ScrollingActivity.setSingleEvent();
                }
            });*/
        }
    }
}
