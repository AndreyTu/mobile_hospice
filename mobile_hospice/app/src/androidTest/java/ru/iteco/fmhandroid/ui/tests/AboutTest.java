package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.SplashStep;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {

    AuthStep authStep = new AuthStep();
    AboutStep aboutStep = new AboutStep();
    MainSteps mainSteps= new MainSteps();
    SplashStep splashStep = new SplashStep();

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Before
    public void logoutCheck(){
        splashStep.appDownload();
        try {
            mainSteps.loadMainScreen();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(Helper.authInfo());
            authStep.clickSignInButton();
        } finally {
            mainSteps.loadMainScreen();
            mainSteps.clickOnAboutUs();
        }
    }

    @Test
    @DisplayName("Проверка ссылок")
    public void checkClickLinks(){
        aboutStep.clickTermsOfUseLink();
        aboutStep.clickPrivacyPolicyLink();

    }
    @Test
    @DisplayName("Проверка элементов О нас")
    public void checkScreenElementsOnAboutUs(){
        aboutStep.checkScreenElementsAboutUs();
    }

    @Test
    @DisplayName("Возврат на главный экран")
    public void returnToMainScreen(){
        aboutStep.checkScreenElementsAboutUs();
        aboutStep.checkReturnButton();
        mainSteps.checkMainElements();
    }




}