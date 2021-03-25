package com.grove.skill.controller.switchtype;

import org.springframework.stereotype.Component;

@Component
public class SwitchWithoutBreak {

    public void start(int num) {
        switch (num) {
            case 1 :
                System.out.println(1);
            case 2 :
                System.out.println(2);
            case 3 :
                System.out.println(3);
            default:
                System.out.println("default");
        }
    }

}
