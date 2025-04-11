package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Helper.waitForElement;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.screenElement.MainElement;
import ru.iteco.fmhandroid.ui.screenElement.NewsElement;
import ru.iteco.fmhandroid.ui.screenElement.PanelElement;

public class PanelStep {
    private final PanelElement panelElement = new PanelElement();
    private final MainElement mainElement = new MainElement();
    private final NewsElement newsElement = new NewsElement();

    public void checkPanelElements(){
        Allure.step("Элементы панели упавления");
        panelElement.getPanelName().check(matches(isDisplayed()));
        panelElement.getSortNewsButton().check(matches(isDisplayed()));
        panelElement.getFilterNewsButton().check(matches(isDisplayed()));
        panelElement.getAddNewsButton().check(matches(isDisplayed()));
    }

    public String getFirstNewsDate(int index) {
        Allure.step("Дата публикации первой новости");
        return Helper.Text.getText(onView(withIndex(panelElement.getNewsPublicationDate(), index)));
    }

    public String getFirstNewsDateAfterAnotherSorting(int index) {
        Allure.step("Дата публикации первой новости после сортировки");
        return Helper.Text.getText(onView(withIndex(panelElement.getNewsPublicationDate(), index)));
    }

    public void checkSortPanel(){
        Allure.step("Сортировка новостей");
        String firstNewsPublication = getFirstNewsDate(0);
        panelElement.getSortNewsButton().perform(click());
        panelElement.getNewsList().perform(swipeDown());
        panelElement.getSortNewsButton().perform(click());
        panelElement.getNewsList().perform(swipeDown());
        String firstNewsPublicationAfterAnotherSorting = getFirstNewsDateAfterAnotherSorting(0);
        assertEquals(firstNewsPublication, firstNewsPublicationAfterAnotherSorting);
    }

    public void clickSortNewsButton(){
        Allure.step("Нажать на кнопку сортировки");
        panelElement.getSortNewsButton().perform(click());
    }

    public void openExpendedNewsFilter(){
        Allure.step("Открыть расширенный фильтр");
        panelElement.getFilterNewsButton().perform(click());
    }

    public void clickCreateNewsButton(){
        Allure.step("Нажать создать новость");
        panelElement.getAddNewsButton().perform(click());
    }

    public void clickEditNewsButton(int index){
        Allure.step("Нажать на Редактировать новость");
        onView(withIndex(panelElement.getButtonEditNews(), index)).perform(click());
        onView(isRoot()).perform(waitForElement(withText("Editing"), 5000));
    }

    public void clickOnAnyNews(int index) {
        Allure.step("Нажать на любую новость");
        panelElement.getNewsList().perform(actionOnItemAtPosition(index, click()));
    }

    public String getEditedNewsTitle(int index){
        Allure.step("Редактированный заголовок новости");
        return Helper.Text.getText(onView(withIndex(newsElement.getNewsTitleText(), index)));
    }

    public String getEditedNewsDescription(int index) {
        Allure.step("Редактировать описание новости");
        return Helper.Text.getText(onView(withIndex(mainElement.getNewsDescriptionText(), index)));
    }

    public void checkStatusIsActive(){
        Allure.step("Статус активен");
        panelElement.getStatusActive().check(matches(withText("Active")));
    }

    public void checkStatusIsNotActive(){
        Allure.step("Статус не активен");
        panelElement.getStatusNotActive().check(matches(withText("Not active")));
    }

    public void checkCreateNews(int position, String titleText, String descriptionText) {
        Allure.step("Заголовок и содержание новости");
        panelElement.getNewsList().perform(actionOnItemAtPosition(position, click()));
        onView(isRoot()).perform(waitForElement(mainElement.getNewsDescriptionText(), 10000));
        panelElement.getNewsTitleText().check(matches(withText(titleText)));
        panelElement.getNewsDescriptionText().check(matches(withText(descriptionText)));
    }
}