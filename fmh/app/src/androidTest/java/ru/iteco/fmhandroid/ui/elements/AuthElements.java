package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthElements {

    public ViewInteraction auth = onView(withText(R.string.authorization));
    public ViewInteraction loginInput = onView(withHint(R.string.login));
    public ViewInteraction passwordInput = onView(withHint(R.string.password));
    public ViewInteraction signInButton = onView(withText(R.string.sign_in));
}
