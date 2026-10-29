class TicketBooking {
    int seatsLeft = 5;

    //  boolean book() {
    //     if (seatsLeft > 0) {
    //         try {
    //             Thread.sleep(10);
    //         } catch (InterruptedException e) {
    //             Thread.currentThread().interrupt();
    //         }

    //         seatsLeft--;
    //         return true;
    //     }

    //     return false;
    // }

    synchronized boolean book() {
        if (seatsLeft > 0) {
            seatsLeft--;
            return true;
        }

        return false;
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        TicketBooking booking = new TicketBooking();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                if (booking.book()) {
                    System.out.println("Seat booked");
                } else {
                    System.out.println("Booking failed");
                }
            });

            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("Seats left: " + booking.seatsLeft);
    }
}