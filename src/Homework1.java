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

    public static void main(String[] args) {
        SecureRandom generateRandomNumber = new SecureRandom();
        final int NUM_READINGS = 60;
        final int INSERTS_PER_READING = 1000;
        int[] array = {0};
    }

}
