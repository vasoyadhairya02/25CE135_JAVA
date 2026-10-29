public class Drivr
{
    public static void main(String args[])
    {
        Employee employees[] = {
            new FullTime("Rahul", 101, 50000),
            new PartTime("Amit", 102, 80, 250),
            new Intern("Shyam", 103, 12000)
        };

        double total = 0;

        for(Employee employee : employees)
        {
            double salary = employee.monthlySalary();

            System.out.println(
                employee.name + " Salary = " + salary
            );

            if(employee instanceof Intern)
            {
                System.out.println("Note: This employee is an Intern.");
            }

            total += salary;
        }

        System.out.println("-------------------------");
        System.out.println("Total Payroll = " + total);
    }
}