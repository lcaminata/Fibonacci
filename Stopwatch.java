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
//    javac Stopwatch.java
//******************************************************************************
/**
 * This class serves as a stop watch to compute the execution of all three
 * Fibonacci classes. This class was influenced by the example in the Big Java:
 * Early Subjects textbook, found on page 634.
 */
public class Stopwatch {
    final int RESET = 0; //Used to reset the elapsedTime variable
    long elapsedTime = 0; //Will be set to the difference between the endTime and startTime
    long startTime = 0; //Will be recorded as the starting time
    boolean isRunning = false; //Methods will use this boolean variable to determine whether or not to keep running
    /**
     * Reset method will restart the elapsedTime and isRunning variables. Once
     * the start method is called the isRunning variable will be set to true and
     * the startTime variable will be set to the current amount of milliseconds
     * in the internal clock. Once the end method is called the endTime variable
     * will be set to the current amount of milliseconds in the internal clock.
     * elapsedTime is the difference between the endTime and startTime.
     * isRunning variable will be now set to false. The getElapsedTime method
     * will check if the isRunning variable is true, if it is not then it will
     * return the elapsedTime variable.
     */
    public Stopwatch() {
        reset();
    }
    public void reset() {
        elapsedTime = RESET;
        isRunning = false;
    }
    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
    }
    /**
     * @return the elapsedTime variable which will be the difference between the
     * endTime and the startTime.
     */
    public long getElapsedTime() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            return elapsedTime + endTime - startTime;
        } else {
            return elapsedTime;
        }
    }
}
