public class TimeFormatException extends Exception {

    String time;

    public TimeFormatException(String a) {
        this.time = a;
    }

    public String toString(){
        return (time +" is an invalid time \n" + super.toString());
    }
}
