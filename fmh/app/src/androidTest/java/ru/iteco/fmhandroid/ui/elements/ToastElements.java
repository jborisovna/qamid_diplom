package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;

public class ToastElements {
    public static ViewInteraction toastMatcher(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }
    public static int getWrongLoginOrPassword() {
        return R.string.error;
    }

    public static int getEmptyLoginOrPassword() {
        return R.string.empty_login_or_password;
    }

    public static int getEmptyFields() {
        return R.string.empty_fields;
    }
}
