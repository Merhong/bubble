package lom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Dog {
    private String name;
    private int age;
}

public class LomTest {
    public static void main(String[] args) {
        Dog d = new Dog("강아지",10);
        d.setName("개");
        System.out.println(d.getName());
    }
}