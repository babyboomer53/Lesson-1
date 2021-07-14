# Data Structures and Algorithms in Java (CSE-41321)
## UCSD Extension (Summer 2021)
### Homework Assignment 1

## Introduction
This program implements a method named *insert*, which accepts three arguments. The first argument is an array of 
integers (type int). The second argument, also an integer (type int), specifies the location in the array where 
another element will be inserted. The third argument is the value (type int) that will be inserted into the array. 
The *insert* method takes the value of the third argument and inserts it into the array identified by the first 
argument - at the location specified by the second argument. Then it returns a reference to the modified array - 
that is, a version of the array after the new value has been inserted.

The *main* method calls the *insert* method sixty times, increasing its size by one thousand elements each time. The
objective is to determine how much longer the the insert algorithm takes to run relative to the size of the array. My
expectation was that it would take longer to run as the array grew in size, and run in around O(n) time.
## Implementation
### Test Suite
During this exercise I was introduced to the TestNG framework, having previously used only JUnit.
```java
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Homework1Test {
    @Test
    public void insertValueIntoArray() {
        int[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] secondArray = {1, 2, 3, 4, 6, 7, 8, 9};
        int[] result = Homework1.insert(secondArray, 4, 5);
        assertTrue(Arrays.equals(firstArray, result));
        assertEquals(result.length,9);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void invalidIndex() {
        int[] secondArray = {1, 2, 3, 4, 6, 7, 8, 9};
        int[] result = Homework1.insert(secondArray, 9, 5);
    }
}
```
### Test Results

### Main
```java
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
            System.out.printf("%12d %18.8f", array.length, timePerReading/1_000_000_000);
            System.out.println();
        }
    }
}

```
## Output
```text
"C:\Program Files\Java\jdk-14\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.1\lib\idea_rt.jar=57019:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\out\production\Lesson-1;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\testng-7.1.0.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\jcommander-1.72.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\guice-4.1.0-no_aop.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\javax.inject-1.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\aopalliance-1.0.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\guava-19.0.jar;C:\Users\Champ\IdeaProjects\Data Structures and algorithms\Lesson-1\lib\snakeyaml-1.21.jar" Homework1
Array Length  Seconds per Insert

        1001         0.00032852
        2001         0.00003674
        3001         0.00002745
        4001         0.00002504
        5001         0.00002771
        6001         0.00003674
        7001         0.00003338
        8001         0.00007750
        9001         0.00006920
       10001         0.00007586
       11001         0.00004110
       12001         0.00002077
       13001         0.00002646
       14001         0.00002812
       15001         0.00002619
       16001         0.00003337
       17001         0.00002622
       18001         0.00002285
       19001         0.00009540
       20001         0.00002750
       21001         0.00003147
       22001         0.00002653
       23001         0.00003301
       24001         0.00003445
       25001         0.00003397
       26001         0.00003379
       27001         0.00009506
       28001         0.00003381
       29001         0.00004404
       30001         0.00003360
       31001         0.00004232
       32001         0.00003800
       33001         0.00003658
       34001         0.00009056
       35001         0.00005169
       36001         0.00005359
       37001         0.00004310
       38001         0.00005589
       39001         0.00005015
       40001         0.00004970
       41001         0.00005217
       42001         0.00004750
       43001         0.00004311
       44001         0.00005741
       45001         0.00005649
       46001         0.00005147
       47001         0.00005238
       48001         0.00005574
       49001         0.00005793
       50001         0.00005291
       51001         0.00013370
       52001         0.00007688
       53001         0.00006034
       54001         0.00006110
       55001         0.00005913
       56001         0.00006631
       57001         0.00006404
       58001         0.00005384
       59001         0.00005691
       60001         0.00006651

Process finished with exit code 0
```
## Scatter Plot
