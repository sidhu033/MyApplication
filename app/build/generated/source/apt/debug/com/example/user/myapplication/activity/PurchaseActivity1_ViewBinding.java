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

public class PurchaseActivity1_ViewBinding implements Unbinder {
  private PurchaseActivity1 target;

  private View view7f0a0040;

  private View view7f0a00fa;

  private View view7f0a00fb;

  private View view7f0a0048;

  @UiThread
  public PurchaseActivity1_ViewBinding(PurchaseActivity1 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PurchaseActivity1_ViewBinding(final PurchaseActivity1 target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnPlace, "method 'btnNext'");
    view7f0a0040 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnNext(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.itemadd, "method 'btnNext'");
    view7f0a00fa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnNext(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.itemremove, "method 'btnNext'");
    view7f0a00fb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnNext(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnfloatingcart, "method 'btnNext'");
    view7f0a0048 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnNext(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0a0040.setOnClickListener(null);
    view7f0a0040 = null;
    view7f0a00fa.setOnClickListener(null);
    view7f0a00fa = null;
    view7f0a00fb.setOnClickListener(null);
    view7f0a00fb = null;
    view7f0a0048.setOnClickListener(null);
    view7f0a0048 = null;
  }
}
