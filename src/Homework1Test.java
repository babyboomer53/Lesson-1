import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Homework1Test {
    @Test
    public void insertValueIntoArray() {
        int[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] secondArray = {1, 2, 3, 4, 6, 7, 8, 9};
        int[]result = Homework1.insert(secondArray,4,5);
        assertTrue(Arrays.equals(firstArray,result));
    }
}