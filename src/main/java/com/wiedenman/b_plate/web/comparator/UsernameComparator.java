package com.wiedenman.b_plate.web.comparator;

import com.wiedenman.b_plate.web.model.User;

import java.util.Comparator;

public class UsernameComparator implements Comparator<User> {

    public int compare(User o1, User o2) {
        return o1.getUsername().compareTo(o2.getUsername());
    }
}
