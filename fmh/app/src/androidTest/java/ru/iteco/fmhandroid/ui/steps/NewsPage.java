package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.waitForElement;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import static org.junit.Assert.assertEquals;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;

import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.elements.NewsElements;

public class NewsPage {

    Data data = new Data();
    NewsElements newsElements = new NewsElements();

    public void newsListLoaded() {
        Allure.step("Загрузка списка новостей");
        elementWaiting(withId(R.id.news_list_recycler_view), 10000);
    }

    public void checkNewsScreen() {
        Allure.step("Проверка элементов экрана Новости");
        newsElements.newsScreenName.check(matches(isDisplayed()));
        newsElements.allNewsList.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открыть фильтр");
        newsElements.newsFilterButton.check(matches(isDisplayed()));
        newsElements.newsFilterButton.perform(click());
    }

    public void clickEditButton() {
        Allure.step("Кликнуть кнопку редактирования");
        newsElements.editButton.check(matches(isDisplayed()));
        newsElements.editButton.perform(click());
    }

    public void checkControlPanel() {
        Allure.step("Проверка отображения страницы Панель управления");
        newsElements.createNewsButton.check(matches(isDisplayed()));
    }

    public void openNews(int position) {
        Allure.step("Развернуть одну новость");
        newsElements.expandNewsButton.perform(actionOnItemAtPosition(position, click()));
    }

    public void newsDescriptionIsDisplayed(int position) {
        Allure.step("Проверка отображения описания новости");
        String newsInfo = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), position)));
        onView(allOf(withText(newsInfo), isDisplayed())).check(matches(isDisplayed()));
    }

    public void checkFirstNewsPublicationDate() {
        Allure.step("Проверка даты публикации первой новости в списке");
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(firstNewsPublicationDate, data.newsPublicDate);
    }

    public String getCreatedNewsDescription(int position) {
        Allure.step("Получить описание созданной новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), position)));

    }

    public void checkFilterScreen() {
        Allure.step("Проверка отображения экрана Фильтр");
        newsElements.filterScreenName.check(matches(isDisplayed()));
        newsElements.categoryField.check(matches(isDisplayed()));
        newsElements.startDateField.check(matches(isDisplayed()));
        newsElements.endDateField.check(matches(isDisplayed()));
    }

    public void clickFilter() {
        Allure.step("Кликнуть кнопку фильтр");
        newsElements.filterButton.perform(click());
    }

    public void fillStartDate(String startDate) {
        Allure.step("Заполнение поля Начальная дата");
        newsElements.startDateField.perform(replaceText(startDate));
    }

    public void fillEndDate(String endDate) {
        Allure.step("Заполнение поля Конечная дата");
        newsElements.endDateField.perform(replaceText(endDate));
    }

    public void clickOnActiveCheckBox() {
        Allure.step("Кликнуть чек-бокс Активна");
        newsElements.activeCheckBox.perform(click());
    }

    public void clickOnNotActiveCheckBox() {
        Allure.step("Кликнуть чек-бокс Не активна");
        newsElements.notActiveCheckBox.perform(click());
    }

    public void checkNotActiveNewsStatus() {
        Allure.step("Проверка статуса Не активна");
        newsElements.newsStatusNotActive.check(matches(withText("Не активна")));
    }

    public void checkActiveNewsStatus() {
        Allure.step("Проверка статуса Активна");
        newsElements.newsStatusActive.check(matches(withText("Активна")));
    }

    public void checkNothingToShowScreen() {
        Allure.step("Проверка элементов экрана Здесь пока ничего нет…");
        newsElements.nothingToShowWarning.check(matches(isDisplayed()));
        newsElements.butterflyImage.check(matches(isDisplayed()));
        newsElements.refreshButton.check(matches(isDisplayed()));
    }

    public void clickCreateNews() {
        Allure.step("Кликнуть кнопку создания новости");
        newsElements.createNewsButton.perform(click());
    }

    public void clickSave() {
        Allure.step("Кликнуть кнопку Сохранить");
        newsElements.saveButton.perform(click());
    }

    public void clickCancel() {
        Allure.step("Кликнуть кнопку Отмена");
        newsElements.cancelButton.perform(click());
    }

    public void clickOK() {
        Allure.step("Кликнуть кнопку ОК");
        newsElements.okButton.perform(click());
    }

    public void checkCreatingNewsScreen() {
        Allure.step("Проверка отображения экрана Создание новости");
        newsElements.creatingNewsScreenName.check(matches(isDisplayed()));
        newsElements.categoryField.check(matches(isDisplayed()));
        newsElements.titleField.check(matches(isDisplayed()));
        newsElements.publicationDateField.check(matches(isDisplayed()));
        newsElements.timeField.check(matches(isDisplayed()));
        newsElements.descriptionField.check(matches(isDisplayed()));
    }

    public void fillInNewsCategory(String text) {
        Allure.step("Заполнить поле Категория");
        newsElements.categoryField.perform(replaceText(text));
    }

    public void fillInNewsTitle(String text) {
        Allure.step("Заполнить поле Заголовок");
        newsElements.titleField.perform(replaceText(text));
    }

    public void fillInPublicationDate(String text) {
        Allure.step("Заполнить поле Дата публикации");
        newsElements.publicationDateField.perform(replaceText(text));
    }

    public void fillInTime(String text) {
        Allure.step("Заполнить поле Время");
        newsElements.timeField.perform(replaceText(text));
    }

    public void fillInNewsDescription(String text) {
        Allure.step("Заполнить поле Описание");
        newsElements.descriptionField.perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate, String publicationTime, String description) {
        Allure.step("Создать новость");
        fillInNewsCategory(category);
        fillInNewsTitle(title);
        fillInPublicationDate(publicationDate);
        fillInTime(publicationTime);
        fillInNewsDescription(description);
    }

    public void clickEditNews(int position) {
        Allure.step("Клинкть кнопку редактирования новости");
        onView(withIndex(withId(R.id.edit_news_item_image_view), position)).perform(click());
        onView(isRoot()).perform(waitForElement(withText("Редактирование"), 10000));
    }

    public void checkEditNewsScreen() {
        Allure.step("Проверка отображения экрана Редактирование новости");
        newsElements.editingNewsScreenName.check(matches(isDisplayed()));
        newsElements.editCategoryField.check(matches(isDisplayed()));
        newsElements.editTitleField.check(matches(isDisplayed()));
        newsElements.publicationDateField.check(matches(isDisplayed()));
        newsElements.timeField.check(matches(isDisplayed()));
        newsElements.timeField.check(matches(isDisplayed()));
        newsElements.descriptionField.check(matches(isDisplayed()));
        newsElements.statusSwitcher.check(matches(isDisplayed()));
    }

    public void changeStatus() {
        Allure.step("Изменить статус новости (активный/неактивный)");
        newsElements.statusSwitcher.perform(click());
    }

    public void editTitle(String text) {
        Allure.step("Изменить заголовок новости");
        newsElements.editTitleField.perform(replaceText(text));
    }

    public void editDescription(String text) {
        Allure.step("Изменить описание новости");
        newsElements.descriptionField.perform(replaceText(text));
    }

    public void clickRandomNewsItem(int position) {
        Allure.step("Кликнуть произвольную новость");
        newsElements.blockOfNews.perform(actionOnItemAtPosition(position, click()));
    }

    public String getEditedNewsTitle(int position) {
        Allure.step("Получить заголовок отредактированной новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), position)));
    }

    public String getEditedNewsDescription(int position) {
        Allure.step("Получить содержание отредактированной новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), position)));
    }

    public void deleteNews(String title) {
        Allure.step("Удалить новость");
        onView(allOf(withId(R.id.delete_news_item_image_view), hasSibling(withText(title)))).perform(click());
        newsElements.deleteConfirm.check(matches(isDisplayed()));
        newsElements.okButton.perform(click());
    }

    public void checkDeleteNews(String title) {
        Allure.step("Проверить, что новость удалилась");
        onView(withText(title)).check(doesNotExist());
    }
}
