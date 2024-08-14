package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AuthElements;

public class AuthPage {

    AuthElements authElements = new AuthElements();

    public void loadAuthPage() {
        Allure.step("Проверка отображения страницы авторизации");
        authElements.auth.check(matches(isDisplayed()));
    }

    public void login(String login, String password) {
        Allure.step("Авторизация в приложении");
        authElements.loginInput.perform(click());
        authElements.loginInput.perform(replaceText(login), closeSoftKeyboard());
        authElements.loginInput.check(matches(withText(login)));
        authElements.passwordInput.perform(replaceText(password), closeSoftKeyboard());
        authElements.passwordInput.check(matches(withText(password)));
        authElements.signInButton.perform(click());
    }

    public void clickSingInButton() {
        Allure.step("Кликнуть по кнопке Войти");
        authElements.signInButton.perform(click());
    }
}
