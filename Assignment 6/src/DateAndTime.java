import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


//Date and Time :
//        1.Create a program to calculate the number of days until your next birthday.
//        2.Format the current date and time into a custom pattern (e.g., MM/dd/yyyy HH:mm).
//        3.Find the difference in hours between two time zones (e.g., UTC and Asia/Kolkata).

public class DateAndTime {

    public static long calculateDaysNextBirthday(){
        System.out.println("Enter Your Birthdate(dd/mm/yyyy) :- ");
        Scanner sc = new Scanner(System.in);
        String datestr = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(datestr, formatter);
        LocalDate today = LocalDate.now();
//        System.out.println("Today :- "+today);
        LocalDate custom = LocalDate.of(today.getYear(),birthDate.getMonthValue(),birthDate.getDayOfMonth());
//        System.out.println("Current Year birthDate :- "+custom);
        if(today.isBefore(custom)){
            return ChronoUnit.DAYS.between(today, custom);
        }
        else{
            return ChronoUnit.DAYS.between(today,LocalDate.of(today.getYear()+1, birthDate.getMonthValue(), birthDate.getDayOfMonth()));
        }
    }

    public static void main(String[] args) {
        System.out.println("Days left :- "+calculateDaysNextBirthday());
        System.out.println("Custom Pattern :- "+customPattern("MM/dd/yyyy HH:mm"));
        System.out.println("Difference in Hours Between two Time Zones :- "+differentTimeZOne());
    }

    public static String differentTimeZOne() {
        LocalDateTime dateTime1 = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        LocalDateTime dateTime2 = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        Duration duration = Duration.between(dateTime1, dateTime2);
        return ""+duration.toHoursPart()+" "+duration.toMinutesPart();
    }

    public static String customPattern(String pattern) {
        Date today;
        String output;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat(pattern);
        today = new Date();
        System.out.println("Today :- "+today);
        output = formatter.format(today);
        return pattern + "\nOutput :- " + output;
    }
}
