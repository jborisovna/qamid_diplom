package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPass;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthPage;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.QuotesPage;

@RunWith(AllureAndroidJUnit4.class)
public class QuotesTest {
    QuotesPage quotesPage = new QuotesPage();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkAuth() {
        try {
            authPage.loadAuthPage();
        } catch (Exception e) {
            return;
        }
        authPage.login(validLogin, validPass);
        mainPage.checkLogo();
    }

    @Test
    @DisplayName("Проверить отображение страницы Цитаты")
    public void checkQuotesElements() {
        mainPage.goToQuoatesScreen();
        quotesPage.checkQuotesScreen();
    }

    @Test
    @DisplayName("Развернуть одну цитату")
    public void expandOneQuote() {
        int position = 0;
        mainPage.goToQuoatesScreen();
        quotesPage.expandQuote(position);
    }
}
