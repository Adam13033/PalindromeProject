import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringBuilderPalindrome implements PalindromeInterface{
    public ArrayList<String> isPalindrome(String userInput) {
        // instantiating our ArrayList which will house our palindromes
        ArrayList<String> palindrome = new ArrayList<>();
        // calling splitMethod which will call .split(" "), separating each word at whitespace and creating a
        // String[] array
        String[] wordArr = splitMethod(userInput);
        // iterating through wordArr, providing each entry in temp variable 'currentWord'
        for (String currentWord : wordArr) {
            boolean isPalindrome = palindromeCypher(currentWord);
            // if word stored in temp variable 'currentWord' is equal to its reversed counterpart
            // add into our palindrome ArrayList
            if (isPalindrome) {
                palindrome.add(currentWord);
            }
        }
        // returns palindrome ArrayList to present to user
        return palindrome;
    }

    public boolean palindromeCypher(String currentWord) {
        // instantiating new StringBuilder in order to obtain mutability
        // reversing new StringBuilder in order to provide point of palindrome comparison
        String reverseWord = new StringBuilder(currentWord).reverse().toString();
        if (reverseWord.equals(currentWord)) {
            return true;
        }
        return false;
    }

    public static String[] splitMethod(String userInput) {
        // splits our userInput at whitespace, isolating individual words and providing us the required array
        // this is returned to isPalindrome() method and array is used for isolating words and screening
        // for palindromes
        return userInput.split(" ");
    }
}







