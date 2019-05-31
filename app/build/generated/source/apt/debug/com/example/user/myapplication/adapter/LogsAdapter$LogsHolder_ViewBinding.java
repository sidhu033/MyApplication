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

public class LogsAdapter$LogsHolder_ViewBinding implements Unbinder {
  private LogsAdapter.LogsHolder target;

  @UiThread
  public LogsAdapter$LogsHolder_ViewBinding(LogsAdapter.LogsHolder target, View source) {
    this.target = target;

    target.rrSys = Utils.findRequiredViewAsType(source, R.id.rrSys, "field 'rrSys'", TextView.class);
    target.rrDys = Utils.findRequiredViewAsType(source, R.id.rrDys, "field 'rrDys'", TextView.class);
    target.rrHr = Utils.findRequiredViewAsType(source, R.id.rrHr, "field 'rrHr'", TextView.class);
    target.llSys = Utils.findRequiredViewAsType(source, R.id.llSys, "field 'llSys'", TextView.class);
    target.llDys = Utils.findRequiredViewAsType(source, R.id.llDys, "field 'llDys'", TextView.class);
    target.llHr = Utils.findRequiredViewAsType(source, R.id.llHr, "field 'llHr'", TextView.class);
    target.imgCheck = Utils.findRequiredViewAsType(source, R.id.imgCheck, "field 'imgCheck'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LogsAdapter.LogsHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rrSys = null;
    target.rrDys = null;
    target.rrHr = null;
    target.llSys = null;
    target.llDys = null;
    target.llHr = null;
    target.imgCheck = null;
  }
}
