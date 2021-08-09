package Exercise12;

import java.util.Iterator;

public class testClass {
	public static void main(String[] args) {
		TicketReservation test = new TicketReservation();
		test.bookFlight("Daniel","Shang",15,"male","econ","A123");
		test.bookFlight("jia","Shang",15,"male","econ","A4325");
		test.cancel("A123");
		Iterator<Passenger> iterator = test.getConfirmedList().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getFirstName());
		}
	}
}
