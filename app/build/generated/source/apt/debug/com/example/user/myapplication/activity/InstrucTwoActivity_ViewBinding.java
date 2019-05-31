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

public class InstrucTwoActivity_ViewBinding implements Unbinder {
  private InstrucTwoActivity target;

  private View view7f0a003e;

  @UiThread
  public InstrucTwoActivity_ViewBinding(InstrucTwoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InstrucTwoActivity_ViewBinding(final InstrucTwoActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnNextTwo, "method 'btnNextTwo'");
    view7f0a003e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnNextTwo(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0a003e.setOnClickListener(null);
    view7f0a003e = null;
  }
}
