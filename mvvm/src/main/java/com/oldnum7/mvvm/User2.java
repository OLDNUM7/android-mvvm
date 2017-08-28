package com.oldnum7.mvvm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/25/17:49
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class User2 {

    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
    public final ObservableBoolean isStudent = new ObservableBoolean();

}
