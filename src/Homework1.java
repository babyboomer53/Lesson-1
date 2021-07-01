import java.security.SecureRandom;

public class Homework1 {

    /**
     *
     * This function accepts three arguments in the form of a container, followed by
     * two integer values of type int. It returns an array in which the value of the
     * third argument has been inserted at the location indicated by the second
     * argument.
     *
     * This function runs in O(n) time.
     *
     * @param array A container of type Array
     * @param index An integer (int) representing the insertion point
     * @param value An integer (int) containing the value to insert
     * @return An array representing the original array after the new value has been
     * inserted
     * @throws IndexOutOfBoundsException
     */
    static int[] insert(int[] array, int index, int value) throws IndexOutOfBoundsException {
        int[] temporaryArray = new int[array.length + 1];                           // O(1)
        for (int currentElement = 0; currentElement < index; currentElement++) {    // O(n)
            temporaryArray[currentElement] = array[currentElement];                 // O(1)
        }
        temporaryArray[index] = value;                                              // O(1)
        for (int currentElement = index; currentElement < array.length; currentElement++) { // O(n)
            temporaryArray[currentElement + 1] = array[currentElement];             // O(1)
        }
        return temporaryArray;                                                      // O(1)
    }

    public static void main(String[] arguments) {
        SecureRandom generateRandomNumber = new SecureRandom();
        final int NUM_READINGS = 60;
        final int INSERTS_PER_READING = 1000;
        int[] array = {0};
        int index;
        int value;
        System.out.printf("%12s%20s%n%n", "Array Length", "Seconds per Insert");
        for (int readings = 1; readings <= NUM_READINGS; readings++) {
            long startTime = System.nanoTime();
            for (int inserts = 1; inserts <= INSERTS_PER_READING; inserts++) {
                index = generateRandomNumber.nextInt(array.length+1);
                value = generateRandomNumber.nextInt();
                array = Homework1.insert(array, index, value);
            }
            long stopTime = System.nanoTime();
            double timePerReading = (double) (stopTime - startTime) / INSERTS_PER_READING;
            System.out.printf("%12d %18f", array.length, timePerReading/1_000_000_000);
            System.out.println();
        }
    }

}
