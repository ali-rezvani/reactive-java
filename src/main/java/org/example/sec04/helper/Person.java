package org.example.sec04.helper;

import lombok.Data;
import lombok.ToString;
import org.example.common.Util;

@Data
@ToString
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name= Util.faker().name().fullName();
        this.age=Util.faker().random().nextInt(1,30);
    }
}
