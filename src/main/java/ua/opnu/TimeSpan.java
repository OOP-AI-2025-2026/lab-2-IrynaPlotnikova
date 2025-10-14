package ua.opnu;


public class TimeSpan {
        private int hours;
        private int minutes;

    TimeSpan(int hours, int minutes) {
            if (hours < 0 || minutes < 0 || minutes > 59)
                return; //throw new IllegalArgumentException("Hours and minutes can`t be less than 0.");

            this.hours = hours;
            this.minutes = minutes;
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59)
            return;

        this.hours += hours;
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return (hours * 60 + minutes) / 60.0;
    }

    int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    void subtract(TimeSpan span) {
        int currentTimeSpanInMinutes = hours * 60 + minutes;
        int incomingTimeSpanInMinutes = span.getHours() * 60 + span.getMinutes();

        if (incomingTimeSpanInMinutes > currentTimeSpanInMinutes)
            return;
            //throw new IllegalArgumentException("Incoming TimeSpan is greater then current.");

        int total = currentTimeSpanInMinutes - incomingTimeSpanInMinutes;
        hours = total / 60;
        minutes = total % 60;
    }

    void scale(int factor) {
        if (factor <= 0)
            return;

        int scaledTimeSpanInMinutes = (hours * 60 + minutes) * factor;
        hours = scaledTimeSpanInMinutes / 60;
        minutes = scaledTimeSpanInMinutes % 60;

    }
}