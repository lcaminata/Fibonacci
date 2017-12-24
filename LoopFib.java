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
//    javac LoopFib.java
//******************************************************************************
/**
 * This is the iterative method for finding the Fibonacci numbers. This class
 * was influenced by a method found on the Big Java: Early Subjects textbook, it
 * can be found on page 601.
 */
public class LoopFib implements FibonacciInterface {
    /**
     * The first two Fibonacci numbers are set to 1, this if statement will give
     * them the values. The alternate method will store the previous elements of
     * the Fibonacci table as variables to make it easier for the next method to
     * compute the next Fibonacci number. This for loop will compute the current
     * number in the Fibonacci sequence, it starts from the third element in the
     * sequence and its limit will be the current element you are trying to
     * compute.
     * @param currentIterarion is the current number that the method will
     * attempt to compute using the iterative method of finding Fibonacci
     * numbers.
     * @return the currentFibonacci variable which will be the latest Fibonacci
     * number using the iterative method.
     */
    public long computeFibonacci(int currentIterarion) {
        final int THIRD_NUMBER_IN_LIST = 3; //
        final int FIRST_TWO_ITERATIONS = 2; //Used to set the first two numbers in the table.
        final int FIRST_FIBONACCI_NUMBER = 1; //The first and second value in the fibonacci sequence.
        if (currentIterarion <= FIRST_TWO_ITERATIONS) {
            return FIRST_FIBONACCI_NUMBER;
        } else {
            long currentFibonacciMinusTwo = FIRST_FIBONACCI_NUMBER; //Fibonacci number two places down from the current Fibonacci.
            long currentFibonacciMinusOne = FIRST_FIBONACCI_NUMBER; ////Fibonacci number one place down from the current Fibonacci.
            long currentFibonacci = FIRST_FIBONACCI_NUMBER; //The current Fibonacci number, intended to be returned.

            for (int iteration = THIRD_NUMBER_IN_LIST; iteration <= currentIterarion; iteration++) {
                currentFibonacci = currentFibonacciMinusTwo + currentFibonacciMinusOne;
                currentFibonacciMinusTwo = currentFibonacciMinusOne;
                currentFibonacciMinusOne = currentFibonacci;
            }
            return currentFibonacci;
        }
    }
}
