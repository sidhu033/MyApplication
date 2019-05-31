// Generated code from Butter Knife. Do not modify!
package com.example.user.myapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.user.myapplication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Pin_ViewBinding implements Unbinder {
  private Pin target;

  private View view7f0a0050;

  @UiThread
  public Pin_ViewBinding(Pin target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Pin_ViewBinding(final Pin target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnpin, "method 'pinSubmit'");
    view7f0a0050 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pinSubmit(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0a0050.setOnClickListener(null);
    view7f0a0050 = null;
  }
}
