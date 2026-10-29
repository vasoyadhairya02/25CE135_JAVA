import java.util.*;

public class TollBooth
{
record Vehicle(String number, String type) {}


public static void main(String args[])
{
    Scanner sc = new Scanner(System.in);

    int bike = 0, car = 0, truck = 0, total = 0;

    while (true)
    {
        System.out.print("Enter vehicle number or (done): ");
        String number = sc.next();

        if (number.equalsIgnoreCase("done"))
        {
            break;
        }

        System.out.print("Enter vehicle type: ");
        String type = sc.next().toLowerCase();

        Vehicle vehicle = new Vehicle(number, type);

        int toll = switch (vehicle.type())
        {
            case "bike" -> 100;
            case "car" -> 200;
            case "truck" -> 500;
            default -> 0;
        };

        if (toll == 0)
        {
            System.out.println("Invalid vehicle type!");
            continue;
        }

        total += toll;

        switch (vehicle.type())
        {
            case "bike" -> bike++;
            case "car" -> car++;
            case "truck" -> truck++;
        }
    }

    String most;

    if (bike >= car && bike >= truck)
    {
        most = "Bike";
    }
    else if (car >= bike && car >= truck)
    {
        most = "Car";
    }
    else
    {
        most = "Truck";
    }

    System.out.println("Total Toll: " + total);
    System.out.println("Vehicle Type with Highest Count: " + most);
}

}
