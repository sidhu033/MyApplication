// Generated code from Butter Knife. Do not modify!
package com.example.user.myapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.user.myapplication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsertActivity_ViewBinding implements Unbinder {
  private InsertActivity target;

  private View view7f0a0041;

  @UiThread
  public InsertActivity_ViewBinding(InsertActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsertActivity_ViewBinding(final InsertActivity target, View source) {
    this.target = target;

    View view;
    target.rSys = Utils.findRequiredViewAsType(source, R.id.rSys, "field 'rSys'", EditText.class);
    target.rDys = Utils.findRequiredViewAsType(source, R.id.rdys, "field 'rDys'", EditText.class);
    target.rHr = Utils.findRequiredViewAsType(source, R.id.rHr, "field 'rHr'", EditText.class);
    target.lSys = Utils.findRequiredViewAsType(source, R.id.lSys, "field 'lSys'", EditText.class);
    target.ldys = Utils.findRequiredViewAsType(source, R.id.ldys, "field 'ldys'", EditText.class);
    target.lHr = Utils.findRequiredViewAsType(source, R.id.lHr, "field 'lHr'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSave, "method 'save'");
    view7f0a0041 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.save(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    InsertActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rSys = null;
    target.rDys = null;
    target.rHr = null;
    target.lSys = null;
    target.ldys = null;
    target.lHr = null;

    view7f0a0041.setOnClickListener(null);
    view7f0a0041 = null;
  }
}
