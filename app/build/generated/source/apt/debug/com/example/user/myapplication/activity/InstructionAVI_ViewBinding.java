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

public class InstructionAVI_ViewBinding implements Unbinder {
  private InstructionAVI target;

  private View view7f0a0066;

  @UiThread
  public InstructionAVI_ViewBinding(InstructionAVI target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InstructionAVI_ViewBinding(final InstructionAVI target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnskip, "method 'pinSubmit'");
    view7f0a0066 = view;
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


    view7f0a0066.setOnClickListener(null);
    view7f0a0066 = null;
  }
}
