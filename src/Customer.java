
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
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		StringBuilder result 					= new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(getAmountFor(rental)).append("\n");
            totalAmount += getAmountFor(rental);

        }

		result.append("You owed ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points\n");


		return result.toString();
	}

    private static double getAmountFor(Rental rental) {
        return Rental.getRentalPrice(rental);
    }


}