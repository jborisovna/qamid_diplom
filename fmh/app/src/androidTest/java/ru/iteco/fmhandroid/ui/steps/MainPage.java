package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.Helper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.elements.MainElements;

public class MainPage {
    MainElements mainElements = new MainElements();

    public void checkMainLoad() {
        Allure.step("Загрузка страницы");
        elementWaiting(withText("Новости"), 10000);
    }

    public void checkLogo() {
        Allure.step("Проверить отображение Главной страницы");
        onView(isRoot()).perform(waitDisplayed(withId(R.id.all_news_text_view), 7000));
        mainElements.logo.check(matches(isDisplayed()));
        mainElements.titleNews.check(matches(isDisplayed()));
        mainElements.allNewsButton.check(matches(isDisplayed()));
    }
    public void logOut() {
        Allure.step("Выход из приложения");
        mainElements.authButton.check(matches(isDisplayed()));
        mainElements.authButton.perform(click());
        mainElements.logOutButton.check(matches(isDisplayed()));
        mainElements.logOutButton.perform(click());
    }

    public void expandAllNews(){
        Allure.step("Развернуть блок новостей");
        mainElements.expandAllNewsButton.check(matches(isDisplayed()));
        mainElements.expandAllNewsButton.perform(click());
    }

    public void allNewsNotDisplayed() {
        Allure.step("Проверка, что блок новостей свернут");
        mainElements.allNewsButton.check(matches(not(isDisplayed())));
    }

    public void allNewsDisplayed() {
        Allure.step("Проверка отображения кнопки Все новости");
        mainElements.newsBlock.check(matches(isDisplayed()));
    }

    public void expandOneNews(int position){
        Allure.step("Развернуть одну новость");
        mainElements.expandOneNews.perform(actionOnItemAtPosition(position, click()));
    }

    public void descriptionIsDisplayed(int position) {
        Allure.step("Проверка отображения описания новости");
        String descriptionText = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), position)));
        onView(allOf(withText(descriptionText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickAllNews() {
        Allure.step("Клик по кнопке Все новости");
        mainElements.allNewsButton.check(matches(isDisplayed()));
        mainElements.allNewsButton.perform(click());
    }

    public void clickActionMenu(){
        Allure.step("Клик по кнопке бургер-меню");
        mainElements.menuButton.perform(click());
    }

    public void checkMenuList(){
        Allure.step("Проверка выпадающего списка бургер-меню");
        mainElements.titleMain.check(matches(isDisplayed()));
        mainElements.titleNews.check(matches(isDisplayed()));
        mainElements.titleAbout.check(matches(isDisplayed()));
    }

    public void goToMainScreen() {
        Allure.step("Переход на главную страницу из выпадающего списка бургер-меню");
        mainElements.menuButton.perform(click());
        mainElements.titleMain.check(matches(isDisplayed()));
        mainElements.titleMain.perform(click());
    }

    public void goToNewsScreen() {
        Allure.step("Переход на страницу Новости из выпадающего списка бургер-меню");
        mainElements.menuButton.perform(click());
        mainElements.titleNews.check(matches(isDisplayed()));
        mainElements.titleNews.perform(click());
    }

    public void goToAboutScreen() {
        Allure.step("Переход на страницу О приложении из выпадающего списка бургер-меню");
        mainElements.menuButton.perform(click());
        mainElements.titleAbout.check(matches(isDisplayed()));
        mainElements.titleAbout.perform(click());
    }

    public void goToQuoatesScreen() {
        Allure.step("Переход на страницу Цитаты");
        mainElements.quotesButton.check(matches(isDisplayed()));
        mainElements.quotesButton.perform(click());
    }
}
