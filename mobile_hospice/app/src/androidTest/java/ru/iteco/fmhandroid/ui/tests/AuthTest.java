package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import kotlin.jvm.JvmField;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElement.AuthElement;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.GeneralSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;


@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthStep authStep = new AuthStep();
    AuthElement authElement = new AuthElement();
    MainSteps mainSteps = new MainSteps();
    GeneralSteps generalSteps = new GeneralSteps();
    SplashStep splashStep = new SplashStep();


    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            authElement.loadAuthPage();
            authStep.checkAuthScreenElements();
        } catch (Exception e) {
            mainSteps.clickLogoutButton();
            authElement.loadAuthPage();
        }
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    public void loginWithInvalidData(){
        authStep.authWithInvalidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация зарегистрированного пользователя и выход из профиля")
    public void loginWithValidData(){
        authStep.authWithValidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        mainSteps.loadMainScreen();
        mainSteps.checkMainElements();
        mainSteps.clickLogoutButton();
        authStep.checkAuthScreenElements();
    }

    @Test
    @DisplayName("Авторизация пользователя с неверным паролем")
    public void authWithInvalidPassword() {
        authStep.authWithInvalidPass(authInfo());
        authStep.clickSignInButton();
        generalSteps.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация пользователя с пустыми полями")
    public void authWithEmptyLoginAndPass(){
        authStep.clickSignInButton();
        generalSteps.checkEmptyAuthDataToast();
    }

        @Test
    @DisplayName("Отображение элементов на странице авторизации")
    public void checkAuthScreenElements(){
        authStep.checkAuthScreenElements();
    }

}