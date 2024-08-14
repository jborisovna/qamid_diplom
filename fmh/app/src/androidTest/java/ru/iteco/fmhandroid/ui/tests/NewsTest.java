package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.swipeDown;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPass;
import static ru.iteco.fmhandroid.ui.data.Helper.Rand.randomCategory;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import ru.iteco.fmhandroid.ui.steps.AuthPage;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.NewsPage;
import ru.iteco.fmhandroid.ui.steps.ToastSteps;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    Data data = new Data();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    NewsElements newsElements = new NewsElements();

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
    @DisplayName("Проверка отображения страницы Новости")
    public void checkNewsElements() {
        mainPage.clickAllNews();
        newsPage.checkNewsScreen();
    }

    @Test
    @DisplayName("Развернуть одну новость")
    public void expandOneNews() {
        int position = 0;
        mainPage.clickAllNews();
        newsPage.openNews(position);
        newsPage.newsDescriptionIsDisplayed(position);
    }

    @Test
    @DisplayName("Фильтрация новостей по дате")
    public void filterByDate() {
        String newsDate = data.newsPublicDate;
        mainPage.clickAllNews();
        newsPage.openFilter();
        newsPage.checkFilterScreen();
        newsPage.fillStartDate(newsDate);
        newsPage.fillEndDate(newsDate);
        newsPage.clickFilter();
        newsPage.checkFirstNewsPublicationDate();
    }

    @Test
    @DisplayName("Отсутствие новостей соответствующих указанным критериям")
    public void nothingToShowScreenWhenFilter() {
        String newsDate = data.dateForNonExistentNews;
        mainPage.clickAllNews();
        newsPage.openFilter();
        newsPage.checkFilterScreen();
        newsPage.fillStartDate(newsDate);
        newsPage.fillEndDate(newsDate);
        newsPage.clickFilter();
        newsPage.checkNothingToShowScreen();
    }

    @Test
    @DisplayName("Переход на страницу Панель управления")
    public void openControlPanel() {
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.checkControlPanel();
    }

    @Test
    @DisplayName("Сортировка новостей по статусу активности")
    public void sortByActivity() {
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.openFilter();
        newsPage.clickOnNotActiveCheckBox();
        newsPage.clickFilter();
        newsPage.newsListLoaded();
        newsPage.checkActiveNewsStatus();
        newsPage.openFilter();
        newsPage.clickOnActiveCheckBox();
        newsPage.clickFilter();
        newsPage.newsListLoaded();
        newsPage.checkNotActiveNewsStatus();
    }

    @Test
    @DisplayName("Создание новости")
    public void сreateNews() {
        int position = 0;
        String descriptionText = data.newsDescription;
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.clickCreateNews();
        newsPage.checkCreatingNewsScreen();
        newsPage.createNews(randomCategory(), data.newsTitle, data.newsPublicDate, data.newsPublicTime, data.newsDescription);
        newsPage.clickSave();
        newsPage.newsListLoaded();
        mainPage.goToNewsScreen();
        newsElements.allNewsList.perform(swipeDown());
        newsPage.openNews(position);
        String createdDescription = newsPage.getCreatedNewsDescription(position);
        assertEquals(descriptionText, createdDescription);
    }

    @Test
    @DisplayName("Создание новости с пустыми полями")
    public void createNewsWithEmptyFields() throws InterruptedException {
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.clickCreateNews();
        newsPage.checkCreatingNewsScreen();
        newsPage.clickSave();
        ToastSteps.checkEmptyFields();
    }

    @Test
    @DisplayName("Отмена создания новости")
    public void cancelNewsCreation() {
        String titleText = data.newsTitle;
        String descriptionText = data.newsDescription;
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.clickCreateNews();
        newsPage.checkCreatingNewsScreen();
        newsPage.createNews(randomCategory(), titleText, data.newsPublicDate, data.newsPublicTime, descriptionText);
        newsPage.clickCancel();
        newsPage.clickOK();
        newsPage.checkControlPanel();
    }

    @Test
    @DisplayName("Редактирование новости")
    public void editNews() {
        int position = 0;
        String newTitle = "Новое название";
        String newDescription = "Новое описание";
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.newsListLoaded();
        newsPage.clickEditNews(position);
        newsPage.checkEditNewsScreen();
        newsPage.editTitle(newTitle);
        newsPage.editDescription(newDescription);
        newsPage.clickSave();
        newsPage.clickRandomNewsItem(position);
        assertEquals(newTitle, newsPage.getEditedNewsTitle(position));
        assertEquals(newDescription, newsPage.getEditedNewsDescription(position));
    }

    @Test
    @DisplayName("Отмена редактирования новости")
    public void cancelEditNews() {
        int position = 0;
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.newsListLoaded();
        newsPage.clickEditNews(position);
        newsPage.checkEditNewsScreen();
        newsPage.clickCancel();
        newsPage.clickOK();
        newsPage.checkControlPanel();
    }

    @Test
    @DisplayName("Изменение статуса активности новости")
    public void changeStatusOfNews() {
        int position = 0;
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.newsListLoaded();
        newsPage.clickEditNews(position);
        newsPage.checkEditNewsScreen();
        newsPage.changeStatus();
        newsPage.clickSave();
        newsPage.newsListLoaded();
        newsPage.checkNotActiveNewsStatus();
        newsPage.clickEditNews(position);
        newsPage.checkEditNewsScreen();
        newsPage.changeStatus();
        newsPage.clickSave();
        newsPage.newsListLoaded();
        newsPage.checkActiveNewsStatus();
    }

    @Test
    @DisplayName("Удаление новости")
    public void deleteNews() {
        String titleText = data.newsTitle;
        mainPage.clickAllNews();
        newsPage.clickEditButton();
        newsPage.clickCreateNews();
        newsPage.checkCreatingNewsScreen();
        newsPage.createNews(randomCategory(), titleText, data.newsPublicDate, data.newsPublicTime, data.newsDescription);
        newsPage.clickSave();
        newsPage.newsListLoaded();
        newsPage.deleteNews(titleText);
        newsPage.checkControlPanel();
        newsPage.checkDeleteNews(titleText);
    }
}
