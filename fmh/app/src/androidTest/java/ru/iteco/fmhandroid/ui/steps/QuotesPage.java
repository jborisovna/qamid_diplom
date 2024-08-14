package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.QuotesElements;

public class QuotesPage {
    QuotesElements quotesElements = new QuotesElements();
    public void checkQuotesScreen() {
        Allure.step("Проверка отображения страницы Цитаты");
        quotesElements.screenName.check(matches(isDisplayed()));
        quotesElements.listOfQuotes.check(matches(isDisplayed()));
    }

    public void expandQuote(int position) {
        Allure.step("Развернуть/свернуть цитату");
        quotesElements.quotesList.check(matches(isDisplayed()));
        quotesElements.quotesList.perform(actionOnItemAtPosition(position, click()));
    }
}
