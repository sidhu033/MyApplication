// Generated code from Butter Knife. Do not modify!
package com.example.user.myapplication.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.user.myapplication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MenusAdapter$MenusHolder_ViewBinding implements Unbinder {
  private MenusAdapter.MenusHolder target;

  @UiThread
  public MenusAdapter$MenusHolder_ViewBinding(MenusAdapter.MenusHolder target, View source) {
    this.target = target;

    target.img = Utils.findRequiredViewAsType(source, R.id.img, "field 'img'", ImageView.class);
    target.txtImgName = Utils.findRequiredViewAsType(source, R.id.txtImgName, "field 'txtImgName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MenusAdapter.MenusHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img = null;
    target.txtImgName = null;
  }
}
