class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    void cancel(int n) {
        seatsAvailable += n;
        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Book 20 seats: " + show.book(20));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Book 15 seats: " + show.book(15));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        show.cancel(10);
        System.out.println("After canceling 10 seats:");
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Book 30 seats: " + show.book(30));
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        show.cancel(50);
        System.out.println("After canceling 50 seats:");
        System.out.println("Seats Available: " + show.getSeatsAvailable());

        System.out.println("Total Booked Seats: " + CinemaShow.getTotalBooked());
    }
}