package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.LoveStep;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class MainPaigeTest {

    private final AuthStep authStep = new AuthStep();
    private final MainSteps mainSteps = new MainSteps();
    private final NewsStep newsStep = new NewsStep();
    private final LoveStep loveStep = new LoveStep();
    private final SplashStep splashStep = new SplashStep();
    private final AboutStep aboutStep = new AboutStep();

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            mainSteps.loadMainScreen();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(authInfo());
            authStep.clickSignInButton();
        } finally {
            mainSteps.loadMainScreen();
        }
    }

    @Test
    @DisplayName("Переход по меню")
    public void menuNewsToAbout() {
        mainSteps.clickOnNews();
        newsStep.checkNewsElements();
        mainSteps.clickOnAboutUs();
        aboutStep.checkScreenElementsAboutUs();
    }

    @Test
    @DisplayName("Развернуть/свернуть блок новостей")
    public void checkNewsBlock(){
        mainSteps.checkAllNews();
        mainSteps.allNewsNotDisplayed();
        mainSteps.checkAllNews();
        mainSteps.allNewsAreDisplayed();
    }

    @Test
    @DisplayName("Отображение разделов меню")
    public void menuElementsVisibility(){
        mainSteps.clickMenuButton();
        mainSteps.checkMenuList();
    }

    @Test
    @DisplayName("Переход через кнопку All news")
    public void goToAllNews(){
        mainSteps.clickAllNewsButton();
        newsStep.checkNewsElements();
        mainSteps.clickOnMain();
        mainSteps.checkMainElements();
    }

    @Test
    @DisplayName("Посмотреть отдельную новoсти")
    public void checkNews(){
        mainSteps.loadMainScreen();
        mainSteps.clickOnNews();
    }
}


