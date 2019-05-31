// Generated code from Butter Knife. Do not modify!
package com.example.user.myapplication.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.user.myapplication.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LogActivity_ViewBinding implements Unbinder {
  private LogActivity target;

  @UiThread
  public LogActivity_ViewBinding(LogActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LogActivity_ViewBinding(LogActivity target, View source) {
    this.target = target;

    target.recLogs = Utils.findRequiredViewAsType(source, R.id.recLogs, "field 'recLogs'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LogActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recLogs = null;
  }
}
