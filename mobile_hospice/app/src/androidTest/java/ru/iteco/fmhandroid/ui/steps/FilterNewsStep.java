package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.FilterNews;

public class FilterNewsStep {
    private final FilterNews filterNews = new FilterNews();

    public void checkFilterNewsElements(){
        Allure.step("Элементы экрана Фильтровать новости");
        filterNews.getFilterNewsName().check(matches(isDisplayed()));
        filterNews.getDateStartText().check(matches(isDisplayed()));
        filterNews.getDateEndText().check(matches(isDisplayed()));
        filterNews.getCategoryText().check(matches(isDisplayed()));
        filterNews.getFilterButton().check(matches(isDisplayed()));
    }

    public void clickFilterButton(){
        Allure.step("Нажать на кнопку Фильтровать");
        filterNews.getFilterButton().perform(click());
    }

    public void fillStartDate(String startDate){
        Allure.step("Ввод данных в поле ОТ даты");
        filterNews.getDateStartText().perform(replaceText(startDate));
    }

    public void fillEndDate(String endDate){
        Allure.step("Ввод данных в поле ДО даты");
        filterNews.getDateEndText().perform(replaceText(endDate));
    }

    public void clickActiveCheckBox(){
        Allure.step("Нажать на чекбокс Активна");
        filterNews.getFilterActive().perform(click());
    }

    public void clickNotActiveCheckBox(){
        Allure.step("Нажать на чекбокс Неактивен");
        filterNews.getFilterInActive().perform(click());
    }

    public void checkBoxStatusIsActive(boolean checked){
        Allure.step("Проверка нажатия на свитчер Активна");
        if (checked) {
            filterNews.getFilterActive().check(matches(isChecked()));
        } else {
            filterNews.getFilterActive().check(matches(isNotChecked()));
        }
    }

    public void checkBoxStatusIsNotActive(boolean checked){
        Allure.step("Проверка нажатич на свичер не автивна");
        if (checked) {
            filterNews.getFilterInActive().check(matches(isChecked()));
        } else {
            filterNews.getFilterInActive().check(matches(isNotChecked()));
        }
    }
}