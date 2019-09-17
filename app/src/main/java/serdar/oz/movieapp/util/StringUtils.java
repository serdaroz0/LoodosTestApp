package serdar.oz.movieapp.util;

import static serdar.oz.movieapp.constants.GlobalConstants.EMPTY;

public class StringUtils {

    public static String checkNullOrNot(String text) {
        if (text == null)
            return null;
        else if (text.length() == 0)
            return EMPTY;
        else
            return text;
    }
}
