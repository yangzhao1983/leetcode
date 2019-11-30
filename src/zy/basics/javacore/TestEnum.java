package zy.basics.javacore;

import java.util.EnumSet;

/**
 * Created by kaiser_zhao on 2019/1/2.
 *
 * Do investigation of enumset
 *
 * 1. Create a enum
 * 2. Create enumset, capable of holding values of the given enumerated type
 */
public class TestEnum {
    public static void main(String...strings){
        EnumSet<Week> days = EnumSet.noneOf(Week.class);

        // size == 0
        System.out.println(days.size());

        days.add(Week.MONDAY);
        days.add(Week.TUESDAY);
        days.add(Week.WEDNESDAY);
        days.add(Week.THURSDAY);
        days.add(Week.FRIDAY);
        days.add(Week.SATURDAY);
        days.add(Week.SUNDAY);
        days.add(Week.MONDAY);

        System.out.println(days.size());
    }
}

enum Week{MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY, SUNDAY}
