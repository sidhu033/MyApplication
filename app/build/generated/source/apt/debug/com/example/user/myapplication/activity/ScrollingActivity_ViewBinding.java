// Generated code from Butter Knife. Do not modify!
package com.example.user.myapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.user.myapplication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScrollingActivity_ViewBinding implements Unbinder {
  private ScrollingActivity target;

  @UiThread
  public ScrollingActivity_ViewBinding(ScrollingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScrollingActivity_ViewBinding(ScrollingActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recMenus = Utils.findRequiredViewAsType(source, R.id.recMenus, "field 'recMenus'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScrollingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.recMenus = null;
  }
}
