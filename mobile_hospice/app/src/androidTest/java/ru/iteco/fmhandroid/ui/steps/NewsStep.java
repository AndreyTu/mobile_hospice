package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.screenElement.NewsElement;

public class NewsStep {
    private final NewsElement newsElement = new NewsElement();

    public void loadNewsList(){
        Allure.step("Загрузка списка новостей");
        elementWaiting(newsElement.getNewsMainList(), 5000);
    }

    public void checkNewsElements(){
        Allure.step("Проверка элеметов экрана Новости");
        newsElement.getNewsName().check(matches(isDisplayed()));
        newsElement.getAllNewsBlock().check(matches(isDisplayed()));
    }

    public void openFilter(){
        Allure.step("Открыть фильтр");
        newsElement.getFilterNewsButton().check(matches(isDisplayed()));
        newsElement.getFilterNewsButton().perform(click());
    }

    public void clickSortButton(){
        Allure.step("Нажать Сортировать по");
        newsElement.getSortNewsButton().check(matches(isDisplayed()));
        newsElement.getSortNewsButton().perform(click());
    }

    public void clickEditButton(){
        Allure.step("Нажать на Редактировать");
        newsElement.getEditNewsButton().check(matches(isDisplayed()));
        newsElement.getEditNewsButton().perform(click());
    }

    public void checkOpenNews(int position){
        Allure.step("Развернуть выбранную новость");
        newsElement.getChildNewsButton().perform(actionOnItemAtPosition(position, click()));
    }

    public String getFirstNewsTitle(int index) {
        Allure.step("Заголовок первой новости");
        return Helper.Text.getText(onView(withIndex(newsElement.getNewsTitleText(), index)));
    }

    public String getFirsNewsTitleAfterAnotherSorting(int index) {
        Allure.step("Заголовок первой новости после сортировки");
        return Helper.Text.getText(onView(withIndex(newsElement.getNewsTitleText(), index)));
    }

    public String getCreateNewsDescription(int index) {
        Allure.step("Описание созданной новости");
        return Helper.Text.getText(onView(withIndex(newsElement.getDescriptionTextNewsView(), index)));
    }
}