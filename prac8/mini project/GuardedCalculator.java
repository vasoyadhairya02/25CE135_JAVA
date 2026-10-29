package Practical_8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean success = false;

        while (!success) {

            try {

                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                double result;

                if (op == '+') {
                    result = a + b;
                }
                else if (op == '-') {
                    result = a - b;
                }
                else if (op == '*') {
                    result = a * b;
                }
                else if (op == '/') {

                    if (b == 0) {
                        throw new DivideByZeroException(
                                "Cannot divide by zero");
                    }

                    result = a / b;
                }
                else {
                    System.out.println("Invalid operator");
                    continue;
                }

                System.out.println("Result = " + result);

                success = true;
            }

            catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter numbers only.");

                sc.nextLine();
            }

            catch (DivideByZeroException e) {

                System.out.println(
                        "Error: " + e.getMessage());
            }

            finally {

                System.out.println(
                        "Calculation attempt completed.");

                System.out.println("----------------------");
            }
        }

        sc.close();
    }
}