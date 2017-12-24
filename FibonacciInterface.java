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
//    javac FibonacciInterface.java
//******************************************************************************
public interface FibonacciInterface {
    /**
     * This interface class is set up in order to simplify the tester class
     * operations once creating objects for each of the Fibonacci computing
     * classes.
     *
     * @param currentFibonacci current Fibonacci number the method will find.
     * @return the current Fibonacci number.
     */
    long computeFibonacci(int currentFibonacci);
}
