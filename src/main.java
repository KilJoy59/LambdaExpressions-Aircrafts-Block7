
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;


public class main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        Date now = new Date(); // oldDate == current time
        final long hoursInMillis = 60L * 60L * 1000L;
        Date afterNow = new Date(now.getTime() +
                (2L * hoursInMillis));
        airport.getTerminals().stream().map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getDate().after(now) && flight.getDate().before(afterNow) && flight.getType().equals(Flight.Type.DEPARTURE))
                .forEach(flight -> System.out.println("Дата: " + flight.getDate() + "\nСамолет: " + flight.getAircraft() + "\n" +flight.getType() ));


    }
}
