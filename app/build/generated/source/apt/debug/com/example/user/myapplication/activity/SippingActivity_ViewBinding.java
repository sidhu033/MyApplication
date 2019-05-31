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

public class SippingActivity_ViewBinding implements Unbinder {
  private SippingActivity target;

  private View view7f0a004d;

  @UiThread
  public SippingActivity_ViewBinding(SippingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SippingActivity_ViewBinding(final SippingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnnext, "method 'btnPurchase'");
    view7f0a004d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnPurchase(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0a004d.setOnClickListener(null);
    view7f0a004d = null;
  }
}
