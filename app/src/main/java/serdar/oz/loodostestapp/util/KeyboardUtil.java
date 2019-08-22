package serdar.oz.loodostestapp.util;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

public class KeyboardUtil {

        public static void hideKeyboard(Activity activity) {
            InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
        }

}
