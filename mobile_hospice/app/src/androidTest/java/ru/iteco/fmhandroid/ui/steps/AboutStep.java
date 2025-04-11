package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;

import android.view.View;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.AboutElement;

public class AboutStep {
    private final AboutElement aboutElement = new AboutElement();
    private final Matcher<View> companyInfoMatcher = aboutElement.getCompanyInfoMatcher();

    public void checkScreenElementsAboutUs(){
        Allure.step("Проверка элементов экрана О нас");
        elementWaiting(companyInfoMatcher, 10000);
        aboutElement.getTrademark().check(matches(isDisplayed()));
        aboutElement.getVersionTitle().check(matches(isDisplayed()));
        aboutElement.getVersionValue().check(matches(isDisplayed()));
        aboutElement.getPrivacyPolicyLabel().check(matches(isDisplayed()));
        aboutElement.getPrivacyPolicyValue().check(matches(isDisplayed()));
        aboutElement.getTermsOfUseLabel().check(matches(isDisplayed()));
        aboutElement.getTermsOfUseValue().check(matches(isDisplayed()));
        aboutElement.getCompanyInfoLabel().check(matches(isDisplayed()));
        aboutElement.getReturnButton().check(matches(isDisplayed()));
    }

    public void clickTermsOfUseLink(){
        Allure.step("Нажать на Условия использования");
        aboutElement.getTermsOfUseValue().check(matches(isClickable()));
    }

    public void clickPrivacyPolicyLink() {
        Allure.step("Нажать на Политика конфиденциальности");
        elementWaiting(companyInfoMatcher, 10000);
        aboutElement.getPrivacyPolicyValue().check(matches(isClickable()));
    }

    public void checkReturnButton(){
        Allure.step("Кнопки назад");
        aboutElement.getReturnButton().perform(click());
    }
}