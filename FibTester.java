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
//    javac FibTester.java
//    java FibTester input.txt output.txt
//******************************************************************************
/**
 * This class will organize all of the data to compute three Fibonacci tables
 * each using different methods to find them, the tables will be roughly squared
 * and the program is set up to catch any exception or error thrown to redirect
 * the user the right direction.
 */
import java.io.File; //Imports the command to allow an input file to be read onto the program.
import java.io.FileNotFoundException; //Exception in the case that an input file is not found for the program to read.
import java.io.PrintWriter;  //Used to help the program export the output of the program to an output file.
import java.util.InputMismatchException; //Exception in the case that the input is not read as an integer.
import java.util.Scanner; //Imports the scanner command in order to read what is inside the input file.
public class FibTester {
    /**
     * @param args the command line arguments Create catch method for every
     * exception thrown inside the try method in order to prevent the program
     * from crashing. Check if the terminal (in this case for Unix) has an input
     * and output file. If it does not it will throw the
     * ArrayIndexOutOfBoundsException. The Scanner named in will read the first
     * file linked to the program, the PrintWriter named out will print out the
     * output on the second linked file. The inputInteger is the integer input
     * returned if the input String declared earlier passes through 3 of the
     * conditions that will throw an exception if they read an error. Creating
     * three separate objects all referencing the FibonacciInterface interface
     * class; must also call out the Recursive, Fast Recursive, and the
     * Iterative classes respectively. If the try method experiences any
     * errors,it will throw the error to the catch methods. Each error explained
     * above will be directed to these 5 catch methods and matched with the
     * exception it is given printing out the respective message.
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            final int CHECK_THE_LENGTH_OF_ARGS = 2;
            if (args.length != CHECK_THE_LENGTH_OF_ARGS) {
                throw new ArrayIndexOutOfBoundsException();
            }
            String input = args[0]; //Sets the input file as the first file linked to program.
            String output = args[1]; //Sets the output file as the second file linked to the program. 
            Scanner inputScanner = new Scanner(new File(input));
            PrintWriter outputText = new PrintWriter(output);
            FibonacciExceptionHandling exceptionHandler = new FibonacciExceptionHandling();
            int inputInteger = exceptionHandler.checkForErrors(input, inputScanner);
            FibonacciInterface slowRecursive = new RecursiveFib();
            computeFibonacciTable(outputText, inputInteger, slowRecursive, "RECURSIVE FIBONACCI TABLE:");
            FibonacciInterface iterative = new LoopFib();
            computeFibonacciTable(outputText, inputInteger, iterative, "ITERATIVE FIBONACCI TABLE:");
            FibonacciInterface fastRecursive = new FastRecursiveFib();
            computeFibonacciTable(outputText, inputInteger, fastRecursive, "FAST RECURSIVE FIBONACCI TABLE:");
            inputScanner.close();
            outputText.close();
        } catch (ArrayIndexOutOfBoundsException exception1) {
            System.out.println("You need two commmand line arguments in order for this program to execute.");
        } catch (IllegalArgumentException exception2) {
            System.out.println("The input number you have selected is out of range.");
        } catch (InputMismatchException exception3) {
            System.out.println("The input read is not recognized as an integer.");
        } catch (IllegalStateException exception4) {
            System.out.println("The file that has been selected is empty.");
        } catch (FileNotFoundException exception5) {
            System.out.println("The program was not able to find any file to take an input from.");
        }
    }
    /**
     * @param outputText is the PrintWriter that will
     * @param input is the converted input file as an integer.
     * @param timer is the object from the Stopwatch class.
     * @param myObject is the current object from the FibonacciInterface.
     * @param tableName will help distinguish each table. The if statement will
     * take the square root of the input and round it to the nearest whole
     * number, once the index reaches a number divisible by this squared and
     * rounded input it will go on to the next line to print out the remaining
     * Fibonacci numbers.
     */
    public static void computeFibonacciTable(PrintWriter outputText, int input, FibonacciInterface myObject,
            String tableName) {
        Stopwatch timer = new Stopwatch();
        outputText.println(tableName);
        final int FIRST_INDEX_NUMBER = 1; //number index will be intialized with.
        final int LIMIT = 0; //Used to help organize the output tables. 
        timer.reset(); //Called in the case that we require multiple methods to be timed.
        timer.start(); //Records the current time in milliseconds.
        for (int index = FIRST_INDEX_NUMBER; index <= input; index++) {
            outputText.printf("%13d", myObject.computeFibonacci(index));
            if (index % Math.round(Math.sqrt(input)) == LIMIT) {
                outputText.println();
            }
        }
        outputText.println();
        timer.stop();//Records the current time in milliseconds.
        outputText.println("Time taken for method to create table: "
                + timer.getElapsedTime() + " milliseconds");
    }
}
