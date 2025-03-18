import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static final Scanner input = new Scanner(System.in);
    private static final PrintStream output = System.out;

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            calculator.execute();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    private void execute() {
        Operation operation = null;
        while (operation == null) {
            output.print("Enter the desired operation " + Arrays.toString(Operation.operations()) + ": ");
            String operator = input.nextLine();
            operation = Operation.perOperation(operator);
            if(operation == null) {
                    output.println("Invalid operation, try again!");
            }
        }

        output.println("Enter a value: ");
        double n1 = Double.parseDouble(input.nextLine());
        output.println("Enter another value: ");
        double n2 = Double.parseDouble(input.nextLine());

        double result = operation.execute(n1, n2);
        output.println("The result of " + operation.name + "is: " + result);
    }
}