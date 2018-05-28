package com.hchiplonkar.arrays;

class ArrayManipulation {
    private static int MAX_ASCII_COUNT = 256;

    /*
    Check if a string has unique characters. Assuming ASCII
     */
    static boolean IsUniqueCharacters(String str) {
        if (str.length() > MAX_ASCII_COUNT) return false; // cannot be unique if more than allowed characters
        boolean charMap[] = new boolean[MAX_ASCII_COUNT];

        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
            if (charMap[charValue])
                return false;
            charMap[charValue] = true;
        }
        return true;
    }

    /*
    Compress a string
     */
    static String CompressString(String str) {
        int compressedSize = getCompressedSize(str);
        if (compressedSize > str.length()) {
            return str;
        }

        StringBuilder returnStringBuffer = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                returnStringBuffer.append(last);
                returnStringBuffer.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        returnStringBuffer.append(last);
        returnStringBuffer.append(count);
        return returnStringBuffer.toString();
    }

    private static int getCompressedSize(String str) {
        char last = str.charAt(0);
        int size = 0;
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += String.valueOf(count).length() + 1;
                count = 1;
            }
        }

        size += String.valueOf(count).length() + 1;
        return size;
    }

    /*
    Check if two strings are permutations of each other
     */
    static boolean IsPermutation(String source, String destination) {
        if (source.length() != destination.length()) return false;
        int charMap[] = new int[MAX_ASCII_COUNT];
        for (int i = 0; i < source.length(); i++) {
            charMap[source.charAt(i)]++;
        }

        for (int i = 0; i < destination.length(); i++) {
            if (--charMap[destination.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
