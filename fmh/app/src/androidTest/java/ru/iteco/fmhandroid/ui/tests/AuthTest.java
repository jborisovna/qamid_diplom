package ru.iteco.fmhandroid.ui.tests;;

import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPass;
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
import ru.iteco.fmhandroid.ui.steps.ToastSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkLogOut() {
        try {
            authPage.loadAuthPage();
        } catch (Exception e) {
            mainPage.logOut();
            authPage.loadAuthPage();
        }
    }

    @Test
    @DisplayName("Авторизация в приложении с валидными данными")
    public void loginWithValidData() {
        authPage.login(validLogin, validPass);
        mainPage.checkMainLoad();
        mainPage.checkLogo();
    }

    @Test
    @DisplayName("Авторизация в приложении с неверными данными")
    public void loginWithInvalidData() throws InterruptedException {
        authPage.login(invalidLogin, invalidPass);
        ToastSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
    @DisplayName("Авторизация в приложении с верным логином и неверным паролем")
    public void loginWithValidLoginInvalidPass() throws InterruptedException {
        authPage.login(validLogin, invalidPass);
        ToastSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
    @DisplayName("Авторизация с неверным логином и верным паролем")
    public void loginWithInvalidLoginValidPass() throws InterruptedException {
        authPage.login(invalidLogin, validPass);
        ToastSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
    @DisplayName("Авторизация с пустыми полями")
    public void loginWithEmptyLoginAndPass() throws InterruptedException {
        authPage.clickSingInButton();
        ToastSteps.checkEmptyLoginOrPassword();
    }
}
