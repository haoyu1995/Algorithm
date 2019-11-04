package OA.Quora;

import java.util.HashSet;
import java.util.Set;

public class WordsIsValid2 {
    //broken Keyboard
    public int wordsIsValid(String sen, char[] letters){
        //get HashSet of letters
        Set<Character> valid = new HashSet<>();
        for (char letter: letters){
            valid.add(letter);
        }

        String[] words = sen.split(" ");

        int sum = 0;
        for (String word: words){
            word = word.replaceAll("[^a-zA-Z]","").toLowerCase();
            int i = 0;
            while (i < word.length()){
                if (!valid.contains(word.charAt(i))){
                    break;
                }
                i++;
            }
            if (i == word.length()){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        WordsIsValid2 test = new WordsIsValid2();
        System.out.println(test.wordsIsValid("Hello, my dear friend!", new char[]{'h','e', 'l', 'o', 't', 'h', 's'}));
    }
}
