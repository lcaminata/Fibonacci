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
//    javac RecursiveFib.java
//******************************************************************************
/**
 * This serves as the recursive method for computing Fibonacci numbers. This
 * class was influenced by a method found on the Big Java: Early Subjects
 * textbook, it can be found on page 598.
 */
public class RecursiveFib implements FibonacciInterface {
    /**
     * The first two Fibonacci numbers are set to 1, this if statement will give
     * them the values. The alternate method will recursively compute the
     * remaining Fibonacci numbers by calling out the the two previous values of
     * the same method and adding them.
     *
     * @param currentRecursion is the current Fibonacci number in the sequence
     * this method will attempt to compute recursively.
     * @return the current Fibonacci number.
     */
    public long computeFibonacci(int currentRecursion) {
        final int FIRST_TWO_RECURSIONS = 2; //Constant to help give the first two Fibonacci numbers value.
        final int FIRST_FIBONACCI_NUMBER = 1; //Value of the first two Fibonacci numbers.
        if (currentRecursion <= FIRST_TWO_RECURSIONS) {
            return FIRST_FIBONACCI_NUMBER;
        } else {
            final int SUBTRACT_BY_ONE = 1; //Constant used to find a previous Fibonacci number in the sequence.
            final int SUBTRACT_BY_TWO = 2; //Constant used to find a previous Fibonacci number in the sequence.
            return computeFibonacci(currentRecursion - SUBTRACT_BY_ONE)
                    + computeFibonacci(currentRecursion - SUBTRACT_BY_TWO);
        }
    }
}
