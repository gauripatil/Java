import java.util.Random;

enum DaysOfWeek {
    SUN, MON,TUES, WED, THUR, FRI, SAT
}

enum Topping {

    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO;

    public double getPrice() {

        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}


public class EnumDemo {
    public static void main(String[] args) {
        DaysOfWeek weekDay = DaysOfWeek.TUES;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            DaysOfWeek randaomDay = getRandomDay();
//            System.out.printf("Name is %s & ordinal value is %d%n", randaomDay, randaomDay.ordinal());
//
//            if(randaomDay == DaysOfWeek.FRI) {
//                System.out.println("Found Friday!!!");
//            }
            switchDayOfWeek(randaomDay);
        }
        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }


    }

    public static DaysOfWeek getRandomDay() {
        Integer randomInt = new Random().nextInt(7);
        var allDays = DaysOfWeek.values();
        return allDays[randomInt];
    }

    public static void switchDayOfWeek(DaysOfWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case FRI -> System.out.println("Friday is day " + weekDayInteger);
            case MON -> System.out.println("Monday is day " + weekDayInteger);
            case TUES -> System.out.println("Tuesday is day " + weekDayInteger);
            case WED -> System.out.println("Wednesday is day " + weekDayInteger);
            case THUR -> System.out.println("Thursday is day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is day " + weekDayInteger);
            case SUN -> System.out.println("Sunday is day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is Day " + weekDayInteger);
        }
    }
}
