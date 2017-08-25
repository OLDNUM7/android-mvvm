package com.oldnum7.mvvm;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/25/17:49
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
