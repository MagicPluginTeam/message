package io.github.magaicpluginteam.message.utils;

import java.util.Arrays;
import java.util.Collections;

public class ArrayUtils {

    public static Object[] reverse(Object[] o) {
        return Arrays.stream(o).sorted(Collections.reverseOrder()).toArray();
    }

}
