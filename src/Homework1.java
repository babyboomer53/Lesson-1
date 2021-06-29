import java.security.SecureRandom;

public class Homework1 {

    static int[] insert(int[] array, int index, int value) throws IndexOutOfBoundsException {
        int[] temporaryArray = new int[array.length + 1];
        for (int currentElement = 0; currentElement < index; currentElement++) {
            temporaryArray[currentElement] = array[currentElement];
        }
        temporaryArray[index] = value;
        for (int currentElement = index; currentElement < array.length; currentElement++) {
            temporaryArray[currentElement + 1] = array[currentElement];
        }
        return temporaryArray;
    }

    public static void main(String[] arguments) {
        SecureRandom generateRandomNumber = new SecureRandom();
        final int NUM_READINGS = 6;
        final int INSERTS_PER_READING = 1000;
        int[] array = {0};
        int index;
        int value;
        for (int readings = 1; readings <= NUM_READINGS; readings++) {
            long startTime = System.nanoTime();
            for (int inserts = 1; inserts <= INSERTS_PER_READING; inserts++) {
                index = generateRandomNumber.nextInt(array.length);
                value = generateRandomNumber.nextInt();
                array = Homework1.insert(array, index, value);
            }
            long stopTime = System.nanoTime();
            double timePerReading = (double) (stopTime - startTime) / INSERTS_PER_READING;
            System.out.printf("%10d", array.length);
            System.out.println();
        }
    }

}
