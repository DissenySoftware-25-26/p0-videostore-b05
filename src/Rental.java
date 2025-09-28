
public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

    static double getRentalPrice(Rental rental) {
        double thisAmount = 0;

        // determines the amount for each line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    static int calculatePoints(Rental rental) {
        int					frequentRenterPoints 	= 0;
        frequentRenterPoints++;

        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public int getDaysRented () {
		return daysRented;
	}

	public Movie getMovie () {
		return movie;
	}

	private Movie movie;
	private int daysRented;
}