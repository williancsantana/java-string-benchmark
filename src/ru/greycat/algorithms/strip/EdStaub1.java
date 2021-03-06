package ru.greycat.algorithms.strip;

/**
 * Derivative of {@link RatchetFreak1}, constantly reuses static char array and enlarges it if necessary.
 */
public class EdStaub1 implements StripAlgorithm {
    char[] oldChars = new char[5];

    @Override
    public String strip(String s) throws Exception {
        final int length = s.length();
        if (oldChars.length < length) {
            oldChars = new char[length];
        }
        s.getChars(0, length, oldChars, 0);
        int newLen = 0;
        for (int j = 0; j < length; j++) {
            char ch = oldChars[j];
            if (ch >= ' ') {
                oldChars[newLen] = ch;
                newLen++;
            }
        }
        return new String(oldChars, 0, newLen);
    }
}
