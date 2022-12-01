public class Main {
    public static void main(String[] args) {
        getDurationString(8274);
        getDurationString(7356473);
        getDurationString(0);
        getDurationString(-34);
        getDurationString(10, 23);
        getDurationString(76, 23);
        getDurationString(13, -34);
        getDurationString(13, 3443);
    }

    public static void getDurationString(int seconds) {
        if (seconds < 0) {
            System.out.println("\nInvalid seconds input value - " +  seconds);
            return;
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        getDurationString(remainingSeconds, minutes);

    }

    public static void getDurationString(int seconds, int minutes) {
        if (seconds < 0 || seconds > 59) {
            System.out.println("\nInvalid seconds input value - " + seconds);
            return;
        }
        if (minutes < 0) {
            System.out.println("\nInvalid minutes input value - " + minutes);
            return;
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        System.out.printf("\n%dh %dm %ds", hours, remainingMinutes, seconds);
    }


}