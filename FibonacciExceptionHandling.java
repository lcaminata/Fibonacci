//******************************************************************************
//Name: Luciano Caminata
//Class: COP 3337
//Section: U04
//Assignment: 6
//Due Date: December 1, 2016
// 
// I hereby certify that this collective work is my own
// and none of it is the work of any other person or entity.
//
// How to compile and execute this program:
//    javac FibonacciExceptionHandling.java
//******************************************************************************
/**
 * This class is set up in order to handle any error while reading for an
 * input.If any error is found the program will throw an exception and catch it
 * directing the user to a message indicating what the error was.
 */
import java.io.File; //Imports the command to allow an input file to be read onto the program.
import java.io.FileNotFoundException; //Exception in the case that an input file is not found for the program to read.
import java.util.InputMismatchException; //Exception in the case that the input is not read as an integer.
import java.util.Scanner; //Imports the scanner command in order to read what is inside the input file.
public class FibonacciExceptionHandling {
    /**
     * @param input is the String variable that in the main method is the input
     * File.
     * @param in is the Scanner that will read the elements inside the input
     * File. Checks if the input file linked to the program has elements in it.
     * If it does not it will throw the IllegalStateException. Declare an
     * inputInteger variable that will be set to the element in the input file
     * only if the program recognizes it as an integer, if i doesn't the program
     * will throw the InputMismatchException. The integer element inside the
     * input file must be within a range of 1 to 49, If it is not the program
     * will throw the IllegalArgumentException.
     * @return the inputInteger variable that is an integer value used to
     * compute in the main method.
     * @throws FileNotFoundException
     */
    public int checkForErrors(String input, Scanner in) throws FileNotFoundException {
        in = new Scanner(new File(input));
        if (!in.hasNext()) {
            throw new IllegalStateException();
        }
        int inputInteger;
        if (in.hasNextInt()) {
            inputInteger = in.nextInt();
        } else {
            throw new InputMismatchException();
        }
        final int NUMBER_TOO_SMALL = 0;
        final int NUMBER_TOO_LARGE = 50;
        if (inputInteger <= NUMBER_TOO_SMALL || inputInteger >= NUMBER_TOO_LARGE) {
            throw new IllegalArgumentException();
        }
        return inputInteger;
    }
}
