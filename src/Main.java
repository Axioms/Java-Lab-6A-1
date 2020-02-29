import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws TimeFormatException{
        String in = "";
        String temp;
        Scanner stdin= new Scanner(System.in);

        while(!in.equals("n")) {
            System.out.print("Enter time in 24-hour notation: ");
            if(in.equals("") || in.equals("y")) {
                in = stdin.nextLine();

                try {
                    temp = convertTo12Hour(in);
                    System.out.println("That is the same as: " + temp);
                }
                catch (TimeFormatException e) {
                    System.out.println(in + " is an invalid time");
                }
            }

            else {
                System.out.print("Please enter either \"y\" or \" n\": ");
                in = stdin.nextLine();
            }

            if(!(in.equals("y") || in.equals("n"))) {
                System.out.print("Again? (y/n): ");
                in = stdin.nextLine();
            }
        }
        System.out.println("Thank you – end of program.");
    }

    private static String convertTo12Hour(String time) throws TimeFormatException {
        if (isFormatted(time)) {
            String[] tempString = time.split(":");
            int[] tempInt = new int[tempString.length];

            for (int i = 0; i < tempString.length; i++) {
                tempInt[i] = Integer.parseInt(tempString[i]);
            }

            if (tempInt[0] > 12) {
                return (tempInt[0] - 12) + ":" + tempString[1] + " " + "PM";
            } else if(tempInt[0] == 0) {
                return  12 + ":" + tempString[1] + " " + "AM";
            } else {
                return tempInt[0] + ":" + tempString[1] + " " + "AM";
            }
        }
        else {
            throw new TimeFormatException(time);
        }
    }

    private static boolean isFormatted(String time) {
        return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }
}
