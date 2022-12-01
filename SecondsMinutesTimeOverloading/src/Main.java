public class Main {
    public static void main(String[] args) {
        getDurationString(8274);
        getDurationString(7356473);
        getDurationString(0);
    }

    public static void getDurationString(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        getDurationString(remainingSeconds, minutes);

    }

    public static void getDurationString(int seconds, int minutes) {
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        System.out.printf("\n%dh %dm %ds", hours, remainingMinutes, seconds);
    }


}