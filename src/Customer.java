
import java.util.*;

public class Customer 
{
	private final String name;
	private final List<Rental> rentals = new ArrayList<>();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		StringBuilder result 					= new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {

            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(getAmountFor(rental)).append("\n");

        }

		result.append("You owed ").append(getTotalCharge()).append("\n");
		result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points\n");

		return result.toString();
	}

    private int getTotalFrequentRenterPoints() {
        int					frequentRenterPoints 	= 0;

        for (Rental rental : rentals){
            frequentRenterPoints += Rental.calculatePoints(rental);
        }

        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount+= getAmountFor(rental);
        }
        return totalAmount;
    }

    private static double getAmountFor(Rental rental) {
        return Rental.getRentalPrice(rental);
    }


}