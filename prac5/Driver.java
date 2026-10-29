public class Driver
{
    public static void main(String[] args)
    {
        Shape[] shapes =
        {
            new Circle(3),
            new Rectangle(4, 5),
            new Triangle(6, 2)
        };

        double totalArea = 0;
        double largestArea = 0;
        Shape largestShape = null;

        for (Shape shape : shapes)
        {
            double area = shape.area();

            System.out.printf(
                "%s Area = %.2f%n",
                shape.getClass().getSimpleName(),
                area
            );

            totalArea += area;

            if (largestShape == null || area > largestArea)
            {
                largestArea = area;
                largestShape = shape;
            }

            System.out.printf(
                "Running Total = %.2f%n%n",
                totalArea
            );
        }

        System.out.println("-----------------------------");
        System.out.printf(
            "Largest Shape = %s%n",
            largestShape.getClass().getSimpleName()
        );
        System.out.printf(
            "Largest Area = %.2f%n",
            largestArea
        );
        System.out.printf(
            "Total Area = %.2f%n",
            totalArea
        );
    }
}