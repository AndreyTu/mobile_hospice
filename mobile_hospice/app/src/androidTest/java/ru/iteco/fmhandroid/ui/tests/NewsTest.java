package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Helper.Rand.randomCategory;
import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.google.android.material.snackbar.BaseTransientBottomBar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.screenElement.NewsElement;
import ru.iteco.fmhandroid.ui.screenElement.PanelElement;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.CreateNewsStep;
import ru.iteco.fmhandroid.ui.steps.EditNewsStep;
import ru.iteco.fmhandroid.ui.steps.FilterNewsStep;
import ru.iteco.fmhandroid.ui.steps.GeneralSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.PanelStep;
import ru.iteco.fmhandroid.ui.steps.SplashStep;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {

    private final AuthStep authStep = new AuthStep();
    private final NewsStep newsStep = new NewsStep();
    private final MainSteps mainSteps = new MainSteps();
    private final SplashStep splashStep = new SplashStep();
    private final NewsElement newsElement = new NewsElement();
    private final GeneralSteps generalSteps = new GeneralSteps();
    private final PanelStep panelStep = new PanelStep();
    private final FilterNewsStep filterNews = new FilterNewsStep();
    private final CreateNewsStep createNewsStep = new CreateNewsStep();
    private final EditNewsStep editNewsStep = new EditNewsStep();

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
            mainSteps.clickOnNews();
        }
    }

    @Test
    @DisplayName("Экран новостей")
    public void newsScreenElements() {
        newsStep.checkNewsElements();
    }

     @Test
     @DisplayName("Сортировка новостей во вкладке Новости")
     public void sortingNews(){
         newsStep.clickEditButton();
         newsStep.clickSortButton();
     }

     @Test
     @DisplayName("Создать новость")
     public void createNews(){
         newsStep.clickEditButton();
         panelStep.clickCreateNewsButton();
         createNewsStep.newsScreenElements();
         createNewsStep.createNews(randomCategory(), Data.titleCyr, Data.dateOfPublic, Data.timeOfPublic, Data.descriptionCyr);
         generalSteps.clickSaveButton();
     }

    @Test
    @DisplayName("Перейти в Control panel")
    public void clickControlPanel(){
        newsStep.clickEditButton();
        panelStep.checkPanelElements();
    }

    @Test
    @DisplayName("Создать новость с пустыми полями")
    public void createNewsWithEmptyFields(){
        newsStep.clickEditButton();
        panelStep.clickCreateNewsButton();
        createNewsStep.newsScreenElements();
        generalSteps.clickSaveButton();
        generalSteps.checkEmptyFieldError();
    }

    @Test
    @DisplayName("Создать новость с пустым описанием")
    public void createNewsWithEmptyDescription(){
        newsStep.clickEditButton();
        panelStep.clickCreateNewsButton();
        createNewsStep.newsScreenElements();
        createNewsStep.createNews(randomCategory(), Data.titleCyr, Data.dateOfPublic, Data.timeOfPublic, Data.emptyDescription);
        generalSteps.clickSaveButton();
        generalSteps.checkEmptyFieldError();
    }

    @Test
    @DisplayName("Редактировать новость")
    public void editNews(){
        newsStep.clickEditButton();
        panelStep.clickCreateNewsButton();
        createNewsStep.createNews(randomCategory(), Data.titleCyr, Data.dateOfPublic, Data.timeOfPublic, Data.descriptionCyr);
        generalSteps.clickSaveButton();
        newsStep.loadNewsList();
        panelStep.clickEditNewsButton(0);
        editNewsStep.checkEditNewsElements();
        editNewsStep.editTitle(Data.editTitle);
        editNewsStep.editDescription(Data.editDescription);
        generalSteps.clickSaveButton();
        panelStep.clickOnAnyNews(0);
        assertEquals(Data.editDescription, panelStep.getEditedNewsDescription(0));
    }

    @Test
    @DisplayName("Отмена создания новости")
    public void cancelCreateNews(){
        newsStep.clickEditButton();
        panelStep.clickCreateNewsButton();
        createNewsStep.fillTitle("Text");
        createNewsStep.fillTitle(Data.titleCyr);
        generalSteps.clickCancelButton();
        generalSteps.clickOkButton();
        panelStep.checkPanelElements();
    }

    @Test
    @DisplayName("Фильтрация по дате")
    public void noNewsToShow(){
        newsStep.openFilter();
        filterNews.checkFilterNewsElements();
        filterNews.fillStartDate(Data.nonNewsDate);
        filterNews.fillEndDate(Data.nonNewsDate);
        filterNews.clickFilterButton();
        generalSteps.checkNewsListImage();
        generalSteps.checkNothingToShow();
    }

    @Test
    @DisplayName("Фильтрация новостей по категории")
    public void checkFilterOfActive() {
        newsStep.clickEditButton();
        panelStep.openExpendedNewsFilter();
        filterNews.clickNotActiveCheckBox();
        filterNews.checkFilterNewsElements();
        filterNews.clickFilterButton();
        newsStep.loadNewsList();
        panelStep.checkStatusIsActive();
    }
}