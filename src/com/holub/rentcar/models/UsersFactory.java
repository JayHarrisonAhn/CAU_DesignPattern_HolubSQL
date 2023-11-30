package com.holub.rentcar.models;

import com.holub.rentcar.models.row.Car;
import com.holub.rentcar.models.row.Place;
import com.holub.rentcar.models.row.User;

import java.util.Iterator;

public class UsersFactory extends RowsFactory<User> {
    User create(Iterator column) {
        String userId = column.next().toString();
        String userName = column.next().toString();
        return new User(userId, userName);
    }
}
