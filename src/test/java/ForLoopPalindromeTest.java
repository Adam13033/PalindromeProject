import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ForLoopPalindromeTest {

    @Test
    @DisplayName("Test for true, returning only palindromes")
    void isPalindrome() {
        ArrayList trueInput = new ArrayList();
        trueInput.add("racecar");
        trueInput.add("radar");
        trueInput.add("iiii");
        String testInput = "racecar radar iiii sdfsdfsd";
        Assertions.assertEquals(trueInput, ForLoopPalindrome.isPalindrome(testInput));
    }

    @Test
    @DisplayName("Testing for false return, with non-palindromes in ArrayList should return false.")
    void testIsPalindrome() {
        ArrayList falseInput = new ArrayList<>();
        falseInput.add("abcdefg");
        falseInput.add("hijkl");
        falseInput.add("racecar");
        String testInput = "abcdefg hijkl racecar";
        Assertions.assertNotEquals(falseInput, ForLoopPalindrome.isPalindrome(testInput));
    }

    @Test
    void palindromeCypher() {
        ForLoopPalindrome test = new ForLoopPalindrome();
        Assertions.assertTrue(test.palindromeCypher("racecar"));
        Assertions.assertFalse(test.palindromeCypher("abcdefg"));
    }

    @Test
    void splitMethod() {
        ForLoopPalindrome test = new ForLoopPalindrome();
        String testStr = "abcd efg hijk radar racecar";
        String[] testArr = {"abcd", "efg", "hijk", "radar", "racecar"};
        Assertions.assertEquals(testArr, test.splitMethod(testStr));
    }
}