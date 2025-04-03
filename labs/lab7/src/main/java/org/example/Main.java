// Интерфейс цифровых часов
interface DigitalClock {
    String getTime();
}


class AnalogClock {
    private int hours;
    private int minutes;

    public AnalogClock(int hours, int minutes) {
        this.hours = hours % 24;
        this.minutes = minutes % 60;
    }

    public int getHourHandPosition() {
        return hours * 15;
    }

    public int getMinuteHandPosition() {
        return minutes * 6;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}

// Адаптер для преобразования аналоговых часов в цифровые
class ClockAdapter implements DigitalClock {
    private AnalogClock analogClock;

    public ClockAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }

    @Override
    public String getTime() {
        return String.format("%02d:%02d", analogClock.getHours(), analogClock.getMinutes());
    }
}


public class Main {
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock(17, 13);
        DigitalClock digitalClock = new ClockAdapter(analogClock);

        System.out.println("Время: " + digitalClock.getTime());
    }
}
