class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String hour = String.valueOf(hours);
        String minute = String.valueOf(minutes);
                String second = String.valueOf(seconds);;
        if (hours < 10) {
            hour = "0" + String.valueOf(hours);
        }
        if (minutes < 10) {
            minute = "0" + String.valueOf(minutes);
        }
        if (seconds < 10) {
            second = "0" + String.valueOf(seconds);
        }
        return hour + ":" + minute + ":" + second;
    }

//    public static void main(String[] args) {
//        Time time = new Time(1,0,1);
//        System.out.println(time);
//    }
}