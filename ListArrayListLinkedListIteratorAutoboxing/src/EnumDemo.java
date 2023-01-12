import java.util.Random;

enum DaysOfWeek {
    SUN, MON,TUES, WED, THUR, FRI, SAT
}

public class EnumDemo {
    public static void main(String[] args) {
        DaysOfWeek weekDay = DaysOfWeek.TUES;
        System.out.println(weekDay);

        for (int i = 0; i < 10; i++) {
            DaysOfWeek randaomDay = getRandomDay();
            System.out.printf("Name is %s & ordinal value is %d%n", randaomDay, randaomDay.ordinal());

            if(randaomDay == DaysOfWeek.FRI) {
                System.out.println("Found Friday!!!");
            }
        }


    }

    public static DaysOfWeek getRandomDay() {
        Integer randomInt = new Random().nextInt(7);
        var allDays = DaysOfWeek.values();
        return allDays[randomInt];
    }
}
