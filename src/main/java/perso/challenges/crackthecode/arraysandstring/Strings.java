package perso.challenges.crackthecode.arraysandstring;

import java.util.Arrays;

/**
 * User: sennen
 * Date: 01/05/2014
 * Time: 22:06
 */
public class Strings {
    public static boolean hasOnlyUniqueChars(String string) {
        boolean[] stringCharsFound = new boolean[256];
        for (char stringChar : string.toCharArray()) {
            if (stringCharsFound[stringChar]) {
                return false;
            }
            stringCharsFound[stringChar] = true;
        }
        return true;
    }

    public static String reverse(String string) {
        char[] stringChars = string.toCharArray();
        int length = stringChars.length;
        int lastIndex = length - 1;
        int middle = length / 2;
        for (int i = 0; i < middle; i++) {
            int positionToSwap = lastIndex - i;
            swap(stringChars, i, positionToSwap);
        }
        return new String(stringChars);
    }

    public static String removeDuplicate(String string) {
        char[] chars = string.toCharArray();
        if (chars == null || chars.length < 2) {
            return new String(chars);
        }
        boolean[] stringCharsFound = new boolean[256];
        stringCharsFound[chars[0]] = true;
        int lastCharacterInsertedPosition = 0;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (!stringCharsFound[currentChar]) {
                chars[++lastCharacterInsertedPosition] = currentChar;
            }
            stringCharsFound[currentChar] = true;
        }
        return new String(Arrays.copyOfRange(chars, 0, lastCharacterInsertedPosition + 1));
    }

    public static boolean areAnagrams(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return false;
        }
        int word1Length = string1.length();
        int word2Length = string2.length();
        if (word1Length == 0 || word2Length == 0 || word1Length != word2Length) {
            return false;
        }
        char[] string1Chars = string1.toCharArray();
        int[] numberOfCharacters1 = new int[256];
        for (char string1Char : string1Chars) {
            numberOfCharacters1[string1Char]++;
        }
        char[] string2Chars = string2.toCharArray();
        int[] numberOfCharacters2 = new int[256];
        for (char string2Char : string2Chars) {
            numberOfCharacters2[string2Char]++;
            if (numberOfCharacters2[string2Char] > numberOfCharacters1[string2Char]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(char[] stringChars, int position, int positionToSwap) {
        char temp = stringChars[positionToSwap];
        stringChars[positionToSwap] = stringChars[position];
        stringChars[position] = temp;
    }

    public static boolean areRotations(String string1, String string2) {
        StringBuilder string1AppendString1 = new StringBuilder(string1);
        string1AppendString1.append(string1);
        return string1AppendString1.indexOf(string2) != -1;
    }
}
