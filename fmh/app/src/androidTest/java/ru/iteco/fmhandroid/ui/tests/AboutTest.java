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
import ru.iteco.fmhandroid.ui.steps.AboutPage;
import ru.iteco.fmhandroid.ui.steps.AuthPage;
import ru.iteco.fmhandroid.ui.steps.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    AboutPage aboutPage = new AboutPage();
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
    @DisplayName("Проверка отображения страницы О приложении")
    public void checkAbout() {
     mainPage.goToAboutScreen();
     aboutPage.checkAboutScreen();
    }

    @Test
    @DisplayName("Проверка кликабельности ссылок")
    public void checkLinks() {
        mainPage.goToAboutScreen();
        aboutPage.checkPrivacyPolicyLink();
        aboutPage.checkTermsOfUseLink();
    }

    @Test
    @DisplayName("Возврат на главную страницу со страницы О приложении ")
    public void checkReturnButton() {
        mainPage.goToAboutScreen();
        aboutPage.checkAboutScreen();
        aboutPage.clickReturnButton();
        mainPage.checkLogo();
    }
}
