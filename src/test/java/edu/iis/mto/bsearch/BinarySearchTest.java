package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
/*///todo assert correct pos, add short array for test 1,2 + refactor test names*/

class BinarySearchTest {

    SearchResult result;
    int SEARCHED_VALUE;
    int NOT_FOUND = -1;
    final int ARR_SIZE_ODD = 7;
    final int ARR_SIZE_EVEN = 10;
    int[] testSeqOdd = new int[ARR_SIZE_ODD];
    int[] testSeqEven = new int[ARR_SIZE_EVEN];
    int targetVal;

    @BeforeEach
    void setUp(){
        Random rand = new Random();
        targetVal = Math.abs(rand.nextInt(30));
        for(int i = 0; i < ARR_SIZE_ODD; i++){
            testSeqOdd[i] = targetVal + i;
        }
        for(int i = 0; i < ARR_SIZE_EVEN; i++){
            testSeqEven[i] = targetVal + i;
        }
    }

    //Test for empty array

    @Test
    void testEmptyArray(){
        SEARCHED_VALUE = 7;
        int[] empty = new int[0];
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(SEARCHED_VALUE, empty) );
    }

    //Tests for 1 element array.

    @Test
    void testNotSortedOddLenArray(){
        SEARCHED_VALUE = 7;
        testSeqOdd[0] = testSeqOdd[ARR_SIZE_ODD-1];
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(SEARCHED_VALUE, testSeqOdd));
    }

    @Test
    void testPresentInOneElementArray() {
        SEARCHED_VALUE = 7;
        int[] testOneElementSeq = {SEARCHED_VALUE};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void testNotPresentInOneElementArray(){
        SEARCHED_VALUE = 9;
        int[] testOneElementSeq = {SEARCHED_VALUE+1};
        result = BinarySearch.search(SEARCHED_VALUE, testOneElementSeq);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());

    }


    // Tests for odd len arrays
    @Test
    void testDuplicatesOddArray(){
        SEARCHED_VALUE = 7;
        testSeqOdd[0] = testSeqOdd[1];
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(SEARCHED_VALUE, testSeqOdd));
    }

    @Test
    void testFirstElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[0];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void testLastElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[ARR_SIZE_ODD -1];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
        assertEquals(ARR_SIZE_ODD -1, result.getPosition());
    }

    @Test
    void testMidElementOddLenArray(){
        SEARCHED_VALUE = testSeqOdd[ARR_SIZE_ODD /2];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertTrue(result.isFound());
        assertEquals(ARR_SIZE_ODD /2, result.getPosition());
    }

    @Test
    void testNotPresentOddLenArray(){
        final int SEARCHED_VALUE = targetVal-1;
        result = BinarySearch.search(SEARCHED_VALUE, testSeqOdd);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

    //Tests for even len array

    @Test
    void testNotSortedEvenLenArray(){
        SEARCHED_VALUE = 7;
        testSeqEven[0] = testSeqEven[ARR_SIZE_EVEN-1];
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(SEARCHED_VALUE, testSeqEven));
    }

    @Test
    void testDuplicatesEvenLenArray(){
        SEARCHED_VALUE = 7;
        testSeqEven[0] = testSeqEven[1];
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(SEARCHED_VALUE, testSeqEven));
    }

    @Test
    void testFirstElementEvenLenArray(){
        SEARCHED_VALUE = testSeqEven[0];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqEven);
        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
    }

    @Test
    void testLastElementEvenLenArray(){
        SEARCHED_VALUE = testSeqEven[ARR_SIZE_EVEN -1];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqEven);
        assertTrue(result.isFound());
        assertEquals(ARR_SIZE_EVEN -1, result.getPosition());
    }

    @Test
    void testRightMidElementEvenLenArray(){
        SEARCHED_VALUE = testSeqEven[(ARR_SIZE_EVEN /2)];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqEven);
        assertTrue(result.isFound());
        assertEquals(ARR_SIZE_EVEN /2, result.getPosition());
    }

    @Test
    void testLeftMidElementEvenLenArray(){
        SEARCHED_VALUE = testSeqEven[(ARR_SIZE_EVEN/2) - 1];
        result = BinarySearch.search(SEARCHED_VALUE, testSeqEven);
        assertTrue(result.isFound());
        assertEquals((ARR_SIZE_EVEN/2) - 1, result.getPosition());
    }

    @Test
    void testNotPresentEvenLenArray(){
        final int SEARCHED_VALUE = targetVal-1;
        result = BinarySearch.search(SEARCHED_VALUE, testSeqEven);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

}
