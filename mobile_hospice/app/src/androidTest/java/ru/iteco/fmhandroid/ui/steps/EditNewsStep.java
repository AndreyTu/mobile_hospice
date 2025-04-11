package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.EditNews;

public class EditNewsStep {
    private final EditNews editNews = new EditNews();

    public void checkEditNewsElements(){
        Allure.step("Элементы экрана Новости");
        editNews.getEditName().check(matches(isDisplayed()));
        editNews.getNewsCategoryText().check(matches(isDisplayed()));
        editNews.getNewsTitleEditText().check(matches(isDisplayed()));
        editNews.getNewsPublishDateText().check(matches(isDisplayed()));
        editNews.getNewsPublishTimeText().check(matches(isDisplayed()));
        editNews.getNewsDescriptionText().check(matches(isDisplayed()));
        editNews.getSwitcher().check(matches(isDisplayed()));
    }

    public void editTitle(String text){
        Allure.step("Редактировать заголовок");
        editNews.getNewsTitleEditText().perform(replaceText(text));
    }

    public void editDescription(String text){
        Allure.step("Редактировать описание");
        editNews.getNewsDescriptionText().perform(replaceText(text));
    }

    public void changeStatus(){
        Allure.step("Поменять статус");
        editNews.getSwitcher().perform(click());
    }
}