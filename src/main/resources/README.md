
## Palindrome Project

### The ambition of this project -
This project aims to satisfy the following criteria:
 - Application starts with a full sentence 
 - Contains a method splitting the sentence into individual words
 - Provides user a choice between one of three different methods of identifying palindromes.
   - Individual words are screened to determine if they're a palindrome or not
   - The list of palindromes is returned to main and displayed to user
   - Incorporate an interface which takes in a string and returns a boolean


## How it works & Criteria satisfaction breakdown
In this section, I'll utilise the opportunity to emphasise criteria accomplishment
and demonstrate how and why the code works. This will be accomplished through
code snippets, which include extensive comments as well as a smaller breakdown
without the impedement of cluttering code too dramatically.

 Each section of criteria will be appropriately labelled, with sub-headings 
 demonstrating each class formed to satisfy the multiple methods requirement.

### <b> User walkthrough </b>
In order to navigate the application, you'll initially be prompted to input a sentence 
containing what you may or may not believe to be a palindrome.

Following on from having successfully entered your potential palindromes, you'll be prompted to make
a select options '1', '2' or '3' with further notice that no input will default to option 3.

What these options mean: 
- '1' represents our <b> <i> StringBuilderPalindrome() </b> </i> class and methods. 
- '2' represents our <b> <i> WhileLoopPalindrome() </b> </i> class and methods.
- '3' and any other variation, or abscence of input, will represent our <b> <i> ForLoopPalindrome() </b> </i> 
class and methods

From here onwards, let the code do the work. Upon successful identification of any palindrome(s), a list will 
be populated and returned for your observation.
In the event nothing returns, well, have you tried 'racecar'? 

### Main
My main method was designed to satisfy the following criteria:
- Provide user option to input an entire sentence
- Provide user multiple methods to choose from
As is visible through the snippets below, the criteria has been accomplished through:
- Providing the user multiple options
  - This as is visible through the prompt for input
- Take in a full sentence

<b> Snippet of how this was accomplished: </b>

```java
        // instantiating new Scanner object to obtain user input
        Scanner input = new Scanner(System.in);
        // prompting user to provide input
        System.out.println("Wondering how many words in your sentence are a palindrome? Try it out!");
        // userInput is initialised with the values entered by the user
        String userInput = input.nextLine();
        // informing user of multiple method choices, as well as which means of input are accepted, and what happens in
        // the event of incorrect, or no input.
        System.out.println("There are a few ways we can do this. Select 1, 2 or 3.\n Alternate or no input defaults to 3");
        // capturing user choice
        String userMethod = input.nextLine();
```
- Return ArrayList of palindromes back to user
- Provide user selection of multiple methods

Implementation is visible below:
```java
        // screening user input and providing specified methods as appropriate to user selection
        if(userMethod.equalsIgnoreCase("1")) {
            // instantiating new StringBuilder method, in order to obtain isPalindrome(), which takes in a string and 
            // provides an ArrayList of palindromes once methods have been seen through
            StringBuilderPalindrome strBuildPal = new StringBuilderPalindrome(); 
            // presenting the ArrayList to the user
            System.out.println(strBuildPal.isPalindrome(userInput));
            // screening for user input option 2
        } else if (userMethod.equalsIgnoreCase("2")) {
            // instantiating WhileLoop object, in order to obtain isPalindrome() method, taking in a string and returning
            // an ArrayList for display.
            WhileLoopPalindrome whilePal = new WhileLoopPalindrome();
            System.out.println(whilePal.isPalindrome(userInput));
        } else {
            // this is effectively our 'fall through', when user selects 3 they get their appropriate selection
            // due to not screening for '3', however if user doesn't provide any input will fall-through to here
            // instantiating ForLoopPalindrome object and utilising isPalindrome()
            ForLoopPalindrome forPal = new ForLoopPalindrome();
            System.out.println(forPal.isPalindrome(userInput));;
        }
```


### Interface
The application is broken down into three separate classes, all of which implement
our PalindromeInterface (as displayed below).
```java
public interface PalindromeInterface {
    static boolean palindromeCypher(String userInput) {
        boolean isPalindrome = true;
        return isPalindrome;
    }
}
```
As is visible above, this meets the criteria specified for the interface, which was to:
> - Takes in a string paramter
> - Returns a boolean

## Classes and methods 
Three classes were created, containing 3 different ways of identifying palindromes
and later returning them as was displayed in the <b> Main </b> class and  method displayed above.
The classes were broken down into the following:

## <b>StringBuilderPalindrome() </b>

This class contains 3 methods which will be further explained through comments in the code
and appropriate labelling of criteria as they're met.

 ### <b> isPalindrome() </b>

This method served to accomplish the following:
- Take in userInput, which is a string the user has formulated containing potential palidromes
- Add identified palindromes to ArrayList and return to main in order to display to user

```java
    public static ArrayList<String> isPalindrome(String userInput) {
        // instantiating our ArrayList which will house our palindromes
        ArrayList<String> palindrome = new ArrayList<>();
        // calling splitMethod which will call .split(" "), separating each word at whitespace and creating a
        // String[] array
        String[] wordArr = splitMethod(userInput);
        // iterating through wordArr, providing each entry in temp variable 'currentWord'
        for (String currentWord : wordArr) {
            // calls palindromeCypher with temp variable containing a word from our array of 
            // user words. Thereafter, checks are performed to determine if the word is a palindrome
            // and relevant true/false is returned, which isPalindrome stores.
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
```

 ### <b>palindromeCypher()</b>
This method served to accomplish the following:

- Individual words are screened to determine if they're a palindrome
- Incorporates shared method from PalindromeInterface
  - Takes in a string
  - Returns a boolean

```java
    public static boolean palindromeCypher(String currentWord) {
        // currentWord is obtained from the enhanced for-loop in isPalindrome() method.
        // currentWord is an individual word from the users input, retrieved from an array.
        // of the users individual words.
        
        // instantiating new StringBuilder in order to obtain mutability
        // reversing new StringBuilder in order to provide point of palindrome comparison
        String reverseWord = new StringBuilder(currentWord).reverse().toString();
        if (reverseWord.equals(currentWord)) {
            return true;
        }
        // if currentWord isn't a palindrome return false
        return false;
    }
```
### <b> splitMethod() </b>
This method serves to accomplish the following:
- Contains a method splitting the sentences into individual words

```java
    public static String[] splitMethod(String userInput) {
        // splits our userInput at whitespace, isolating individual words and providing us the required array
        // this is returned to isPalindrome() method and array is used for isolating words and screening
        // for palindromes
        return userInput.split(" ");
    }
```
## <b> ForLoopPalindrome() </b>
Much the same as <b> <i> StringBuilderPalindrome() </i> </b> this class contains three methods, serving the same
purpose only implemented differently. 

### <b> isPalindrome() </b>
This method served to accomplish the following:
- Take in userInput, which is a string the user has formulated containing potential palidromes
- Add identified palindromes to ArrayList and return to main in order to display to user

```java
    public static ArrayList<String> isPalindrome(String userInput) {
        // instantiating our ArrayList
        ArrayList palindromes = new ArrayList<>();
        // calling our strSplitter() method in order to split into individual words and convert to String[].
        String[] strArr = splitMethod(userInput);
        // iterate through each entry in strArr
        for (String currentWord : strArr) {
            // passes current word stored in currentWord to palindromeCypher() which will return
            // true if determining this individual word is a palindrome, or false
            // if it isn't.
            boolean palindrome = palindromeCypher(currentWord);
            // if palindrome is true, adds pal (palindrome) to our ArrayList (palindromes)
            if (palindrome) {
                palindromes.add(currentWord);
            }
        }
        return palindromes;
    }
```

### <b> palindromeCypher() </b>
This method served to accomplish the following:

- Individual words are screened to determine if they're a palindrome
- Incorporates shared method from PalindromeInterface
    - Takes in a string
    - Returns a boolean
```java
    public static boolean palindromeCypher(String userInput) {
        // isPalindrome serves as a switch for iteration, requiring isPalindrome to return 'true' in order to continue
        // iteration. At first instsance characters don't match, iteration ceases and moves forwards to next word.
        boolean isPalindrome = true;
        // i and j serve as index positions, with i counting forwards from the start of the word
        // and j counting backwards, from the back of the word.
        // the process continues until the word is complete, or 1 letter remains. As soon as 2 words are returned
        // which don't match, it isn't possible to be a palindrome and as such doesn't waste further resources
        // moves forwards to next word which holds the potential of being a palindrome.
        for (int i = 0, j = userInput.length() - 1; i < j && isPalindrome; i++, j--) {
            // uses i and j and create substrings, comparing between both for equality
            // when equal, returns true and triggers if statement contained within isPalindrome()
            // when false, as mentioned ceases iteration and begins next
            // false is returned at the first instance of characters not matching, otherwise
            // iteration proceeds forwards until no further characters, or one remains - a palindrome!
            return userInput
                    .substring(i, i + 1)
                    .equalsIgnoreCase(userInput.substring(j, j + 1));
        }
        return isPalindrome;
    }
```

### <b> splitMethod() </b>
This method serves to accomplish the following:
- Contains a method splitting the sentences into individual words

```java
    public static String[] splitMethod(String userInput) {
        return userInput.split(" ");
    }
```

## <b> WhileLoopPalindrome() </b> 
Again, the same underlying principle remains within <b> <i> WhileLoopPalindrome </i> </b> as is with
<b> <i> ForLoopPalindrome </i> </b> and <b> <i> StringBuilderPalindrome </i> </b>. Containing 3 methods,
comprised of the following:

### <b> isPalindrome() </b> 
This method served to accomplish the following:
- Take in userInput, which is a string the user has formulated containing potential palidromes
- Add identified palindromes to ArrayList and return to main in order to display to user
```java
    static ArrayList<String> isPalindrome(String userInput) {
        // instantiating a new ArrayList (referred to as ArrayList to avoid confusion here onwards)
        ArrayList<String> palindromes = new ArrayList<String>();
        // invoke strSplitter() which is simply a method to .split(" ") our string at whitespace
        // forming a String[] array of individual words to screen
        String[] strArr = splitMethod(userInput);
        // i indicates index, serving as our point of iteration. See below;
        int i = 0;
        // while i is less than our entries to strArr (index positions), continue looping.
        while (i < strArr.length) {
            // palindromeCypher() returns a boolean, conditional statement is specifying if
            // palindromeCypher() returns true, then the word is a palindrome
            // in which case, .add() to our ArrayList
            if (palindromeCypher(strArr[i])) {
                palindromes.add(strArr[i]);
            }
            // increment our index as a means of breaking out of while loop when i is equal to strArray.length.
            i++;
        }
        // returns out palindromes, which is received in our main method contained within system.out.println()
        // in order to present the recorded palindromes.
        return palindromes;
    }
```

### <b> palindromeCypher() </b>
This method served to accomplish the following:

- Individual words are screened to determine if they're a palindrome
- Incorporates shared method from PalindromeInterface
    - Takes in a string
    - Returns a boolean

```java
    static boolean palindromeCypher(String userInput) {
        // Representing index positions, where start counts forwards from the start
        // end counts backwards from the end
        int start = 0;
        int end = userInput.length() - 1;

        // Continue iterating until even
        while (end > start) {
            // iterates through current word up until it finds values which don't match
            // at which point, it isn't possible to be a palindrome
            // more efficient than screening exclusively for equality, considering we can figure it out faster
            if (userInput.charAt(start++) != userInput.charAt(end--)) {
                System.out.println(userInput.charAt(start++) + userInput.charAt(end--));
                return false;
            }
        }
        // when true, this is fed back to isPalindrome() method, which utilises the true valuation
        // as a trigger for conditional statement of 'if palindrome, add to ArrayList'
        return true;
    }
```

### <b> splitMethod </b>
This method serves to accomplish the following:
- Contains a method splitting the sentences into individual words

```java
    public static String[] splitMethod(String userInput) {
        // splits our userInput at whitespace, isolating individual words and providing us the required array
        // this is returned to isPalindrome() method and array is used for isolating words and screening
        // for palindromes
        return userInput.split(" ");
    }
```