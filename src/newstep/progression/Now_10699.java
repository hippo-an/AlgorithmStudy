package newstep.progression;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Now_10699 {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("+09:00")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
