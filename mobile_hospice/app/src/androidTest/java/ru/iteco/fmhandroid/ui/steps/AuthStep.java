package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Helper.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidLoginData;
import static ru.iteco.fmhandroid.ui.data.Helper.invalidPassData;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.screenElement.AuthElement;

public class AuthStep {
    private final AuthElement authElement = new AuthElement();

    public void checkAuthScreenElements() {
        Allure.step("Элементы экрана авторизации");
        authElement.getNameAuthText().check(matches(isDisplayed()));
        authElement.getLoginText().check(matches(isDisplayed()));
        authElement.getPasswordText().check(matches(isDisplayed()));
        authElement.getSignInButton().check(matches(isDisplayed()));
    }

    public void authWithValidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с валидным логином и паролем");
        checkAuthScreenElements();
        authElement.getLoginText().perform(replaceText(info.getLogin()));
        authElement.getPasswordText().perform(replaceText(info.getPass()));
    }

    public void authWithInvalidLoginAndPass(Helper.User info) {
        Allure.step("Авторизация с невалидными логином и паролем");
        checkAuthScreenElements();
        authElement.getLoginText().perform(replaceText(invalidAuthData().getLogin()));
        authElement.getPasswordText().perform(replaceText(invalidAuthData().getPass()));
    }

    public void authWithInvalidPass(Helper.User info) {
        Allure.step("Авторизация с невалидным паролем и валидным логином");
        checkAuthScreenElements();
        authElement.getLoginText().perform(replaceText(invalidPassData().getLogin()));
        authElement.getPasswordText().perform(replaceText(invalidPassData().getPass()));
    }

    public void clickSignInButton() {
        Allure.step("Нажать кнопку SignIn");
        authElement.getSignInButton().perform(click());
    }
}