/*
 * Copyright (C) 2016 Robinhood Markets, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.robinhood.ticker;

/**
 * Static utility class for the ticker package. This class contains helper methods such as those
 * that generate default character lists to use for animation.
 *
 * @author Jin Cao, Robinhood
 */
public class TickerUtils {
    static final char EMPTY_CHAR = (char) 0;

    public static String provideNumberList() {
        return "0123456789";
    }

    public static String provideAlphabeticalList() {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    /**
     * Finds the index of the first differing character between the current text and the target text.
     * <p>
     * If the lengths of the two texts are different, the comparison starts at index 0.
     * If all characters match, the method returns -1.
     *
     * @param origin The current text being displayed.
     * @param target The target text to compare against.
     * @return The index of the first differing character, or -1 if the texts are identical.
     */
    public static int findFirstDifferenceCharacterIndex(String origin, String target) {
        if (origin.length() != target.length()) {
            return 0;
        }

        int minLength = origin.length();
        for (int i = 0; i < minLength; i++) {
            if (origin.charAt(i) != target.charAt(i)) {
                return i;
            }
        }

        return -1;
    }
}
