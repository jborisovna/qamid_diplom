package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AboutElements;

public class AboutPage {

    AboutElements aboutElements = new AboutElements();

    public void checkAboutScreen() {
        Allure.step("Проверка отображения элементов страницы О приложении");
        elementWaiting(withId(R.id.about_company_info_label_text_view), 5000);
        aboutElements.logo.check(matches(isDisplayed()));
        aboutElements.version.check(matches(isDisplayed()));
        aboutElements.versionValue.check(matches(isDisplayed()));
        aboutElements.privacyPolicy.check(matches(isDisplayed()));
        aboutElements.privacyPolicyLink.check(matches(isDisplayed()));
        aboutElements.termsOfUse.check(matches(isDisplayed()));
        aboutElements.termsOfUseLink.check(matches(isDisplayed()));
        aboutElements.companyInfo.check(matches(isDisplayed()));
    }

    public void checkPrivacyPolicyLink() {
        Allure.step("Проверка кликабельности ссылки Политика конфиденциальности");
        aboutElements.privacyPolicyLink.check(matches(isClickable()));
    }

    public void checkTermsOfUseLink() {
        Allure.step("Проверка кликабельности ссылки Пользовательское соглашение");
        aboutElements.termsOfUseLink.check(matches(isClickable()));
    }

    public void clickReturnButton() {
        Allure.step("Проверка кнопки возврата");
        aboutElements.returnButton.perform(click());
    }
}
