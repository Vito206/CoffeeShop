//separate class for calculation of time on receipt
public class Time {
    int hour;
    int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}