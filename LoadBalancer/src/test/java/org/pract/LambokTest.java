package org.pract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LambokTest {

    @NoArgsConstructor
    @Getter
    @Setter
    class Student{
        private String name;
        private int rollno;
    }

    @Test
    void getterSetterTest() {
        Student s = new Student();
        s.setName("alpha");
        Assertions.assertEquals( s.getName(), "alpha");
    }
}
