package com.jmh.ascii;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhraseUtils {

    public static String normalize(String phrase) {
        return phrase.trim().toLowerCase().replaceAll("\\s+", " "); //replace multiple white-spaces
    }

    public static Set<String> normalize(Stream<String> strings) {
        return strings.map(s -> normalize(s)).collect(Collectors.toSet());
    }


    /**
     * Normalize input phrase to ascii.
     */
    public static String toAsciiIf(String input) {
        char[] inputChars = input.toCharArray();
        
        // use 4 time longer char array in order to make sure we do handle cases when a single utf char is translated in several ascii chars
        // f.e. ⒭ -> (r)
        int len = containsNotAscii(input) ? inputChars.length * 4 : inputChars.length;
        char[] outputChars = new char[len];
        int length = ASCIIFoldingConverter.foldToASCII(inputChars, 0, outputChars, 0, inputChars.length);
        String asciiOutput = new String(outputChars, 0, length);
        return asciiOutput;
    }

    private static boolean containsNotAscii(String input) {
        for (int i = 0 ; i < input.length(); i ++) {
            if (input.charAt(i) > 127) {
                return true;
            }
        }
        return false;
    }

    /**
     * Normalize input phrase to ascii.
     */
    public static String toAscii(String input) {
        char[] inputChars = input.toCharArray();
        // use 4 time longer char array in order to make sure we do handle cases when a single utf char is translated in several ascii chars
        // f.e. ⒭ -> (r)
        char[] outputChars = new char[inputChars.length * 4];
        int length = ASCIIFoldingConverter.foldToASCII(inputChars, 0, outputChars, 0, inputChars.length);
        String asciiOutput = new String(outputChars, 0, length);
        return asciiOutput;
    }

    /**
     * Normalize input phrase to ascii.
     */
    public static String toAscii2(String input) {
        char[] inputChars = input.toCharArray();
        // use 4 time longer char array in order to make sure we do handle cases when a single utf char is translated in several ascii chars
        // f.e. ⒭ -> (r)
        char[] outputChars = new char[inputChars.length];
        int length = ASCIIFoldingConverter.foldToASCII(inputChars, 0, outputChars, 0, inputChars.length);
        String asciiOutput = new String(outputChars, 0, length);
        return asciiOutput;
    }

    /**
     * Normalize input phrase to ascii.
     */
    public static String toAscii3(String input) {
        StringBuilder stringBuilder = new StringBuilder(input.length());
        ASCIIFoldingConverter.foldToASCII(input, stringBuilder);
        String asciiOutput = stringBuilder.toString();
        return asciiOutput;
    }



    /**
     * Normalize input phrase to ascii.
     */
    public static String toAsciiCharArray(String input) {
        return ASCIIFoldingConverterArray.foldToASCII(input);
    }
}
