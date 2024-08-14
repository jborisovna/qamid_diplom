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
import ru.iteco.fmhandroid.ui.steps.NewsPage;
import ru.iteco.fmhandroid.ui.steps.QuotesPage;

@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    QuotesPage ourMissionPage = new QuotesPage();

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
        mainPage.checkMainLoad();
        mainPage.checkLogo();
    }

    @Test
    @DisplayName("Свернуть/развернуть блок новостей")
    public void collapseOrExpandNewsBlock() {
        mainPage.expandAllNews(); // свернуть новости
        mainPage.allNewsNotDisplayed();
        mainPage.expandAllNews();
        mainPage.allNewsDisplayed();
    }

    @Test
    @DisplayName("Развернуть одну отдельную новость")
    public void expandSeparateNews(){
        int position = 0;
        mainPage.expandOneNews(position);
        mainPage.descriptionIsDisplayed(position);
    }

    @Test
    @DisplayName("Перейти по кнопке Все Новости в раздел Новости")
    public void goToAllNews() {
        mainPage.clickAllNews();
        newsPage.checkNewsScreen();
    }

    @Test
    @DisplayName("Проверка выпадающего списка основного меню")
    public void checkActionMenuList() {
        mainPage.clickActionMenu();
        mainPage.checkMenuList();
    }

    @Test
    @DisplayName("Переход в разделы приложения с главной страницы")
    public void switchScreensFromMain(){
        mainPage.goToNewsScreen();
        newsPage.checkNewsScreen();
        mainPage.goToMainScreen();
        mainPage.checkLogo();
        mainPage.goToAboutScreen();
        aboutPage.checkAboutScreen();
        aboutPage.clickReturnButton();
        mainPage.checkLogo();
        mainPage.goToQuoatesScreen();
        ourMissionPage.checkQuotesScreen();
    }

    @Test
    @DisplayName("Переход в разделы приложения со страницы Новости")
    public void switchScreensFromNews(){
        goToAllNews();
        mainPage.goToMainScreen();
        mainPage.checkLogo();
        mainPage.goToNewsScreen();
        mainPage.goToQuoatesScreen();
        ourMissionPage.checkQuotesScreen();
        mainPage.goToNewsScreen();
        mainPage.goToAboutScreen();
        aboutPage.checkAboutScreen();
    }

    @Test
    @DisplayName("Переход в разделы приложения со страницы Цитаты")
    public void switchScreensFromQuotes() {
        mainPage.goToQuoatesScreen();
        mainPage.goToMainScreen();
        mainPage.checkLogo();
        mainPage.goToQuoatesScreen();
        ourMissionPage.checkQuotesScreen();
        mainPage.goToNewsScreen();
        newsPage.checkNewsScreen();
        mainPage.goToQuoatesScreen();
        ourMissionPage.checkQuotesScreen();
        mainPage.goToAboutScreen();
        aboutPage.checkAboutScreen();
    }

    @Test
    @DisplayName("Выход из приложения")
    public void logOut() {
        mainPage.logOut();
        authPage.loadAuthPage();
    }
}
