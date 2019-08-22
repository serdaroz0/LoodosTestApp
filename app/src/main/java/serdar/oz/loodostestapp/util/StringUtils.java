package serdar.oz.loodostestapp.util;

import static serdar.oz.loodostestapp.constants.GlobalConstants.EMPTY;

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
