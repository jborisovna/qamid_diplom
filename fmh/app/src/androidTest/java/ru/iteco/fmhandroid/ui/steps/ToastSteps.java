package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.ui.elements.ToastElements.toastMatcher;

import ru.iteco.fmhandroid.ui.elements.ToastElements;

public class ToastSteps {

    public static void checkToast(int id, boolean visible) {
        if (visible) {
            toastMatcher(id).check(matches(isDisplayed()));
        } else {
            toastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public static void checkWrongLoginOrPasswordToast() throws InterruptedException {
        checkToast(ToastElements.getWrongLoginOrPassword(), true);
        Thread.sleep(1000);
    }

    public static void checkEmptyLoginOrPassword() throws InterruptedException {
        checkToast(ToastElements.getEmptyLoginOrPassword(), true);
        Thread.sleep(2000);
    }

    public static void checkEmptyFields() {
        checkToast(ToastElements.getEmptyFields(), true);
    }

}
