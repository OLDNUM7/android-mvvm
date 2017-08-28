package com.oldnum7.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/25/17:49
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class User  extends BaseObservable {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
}
