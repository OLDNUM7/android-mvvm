package com.oldnum7.mvvm;

import android.view.View;
import android.widget.Toast;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/25/18:23
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class MyHandler {
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "点击事件", Toast.LENGTH_LONG).show();
    }
}
