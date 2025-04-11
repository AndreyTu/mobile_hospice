package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.CreateNews;

public class CreateNewsStep {
    private final CreateNews createNews = new CreateNews();

    public void newsScreenElements(){
        Allure.step("Элементы экрана Создать новость");
        createNews.getCreateName().check(matches(isDisplayed()));
        createNews.getCategoryName().check(matches(isDisplayed()));
        createNews.getCategoryText().check(matches(isDisplayed()));
        createNews.getTitleName().check(matches(isDisplayed()));
        createNews.getTitleText().check(matches(isDisplayed()));
        createNews.getPublishDateText().check(matches(isDisplayed()));
        createNews.getPublicationDateName().check(matches(isDisplayed()));
        createNews.getTimeText().check(matches(isDisplayed()));
        createNews.getTitleName().check(matches(isDisplayed()));
        createNews.getDescriptionName().check(matches(isDisplayed()));
        createNews.getDescriptionText().check(matches(isDisplayed()));
    }

    public void fillCategory(String text) {
        Allure.step("Ввод данных в поле Категория");
        createNews.getCategoryText().perform(replaceText(text));
    }

    public void fillTitle(String text){
        Allure.step("Ввод данных в поле Заголовок");
        createNews.getTitleText().perform(replaceText(text));
    }

    public void fillPublicDate(String text){
        Allure.step("Ввод данных в поле Дата публикации");
        createNews.getPublishDateText().perform(replaceText(text));
    }

    public void fillTimeField(String text){
        Allure.step("Ввод данных в поле Время");
        createNews.getTimeText().perform(replaceText(text));
    }

    public void fillNewsDescription(String text){
        Allure.step("Ввод данных в поле описание");
        createNews.getDescriptionText().perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate, String publicationTime, String description){
        Allure.step("Создать новость");
        fillCategory(category);
        fillTitle(title);
        fillPublicDate(publicationDate);
        fillTimeField(publicationTime);
        fillNewsDescription(description);
    }
}