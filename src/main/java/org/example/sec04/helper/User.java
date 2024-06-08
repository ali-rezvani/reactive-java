package org.example.sec04.helper;

import lombok.Data;
import lombok.ToString;
import org.example.common.Util;

@Data
@ToString
public class User {
    private int userId;
    private String username;

    public User(int userId) {
        this.userId = userId;
        this.username= Util.faker().name().username();
    }
}
