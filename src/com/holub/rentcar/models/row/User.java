package com.holub.rentcar.models.row;

public class User extends Row {
    public String userId;
    public String userName;
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    public Object[] toArray() {
        return new Object[] { userId, userName };
    }
}
