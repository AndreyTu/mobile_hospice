package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.Helper.waitForElement;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.screenElement.MainElement;

public class MainSteps {
    private final MainElement mainElement = new MainElement();

    public void loadMainScreen(){
        Allure.step("Загрузка основной страницы");
        elementWaiting(withText("ALL NEWS"), 10000);
    }

    public void checkMainElements(){
        Allure.step("Проверка элементов Основного экрана");
        mainElement.getAllNews().check(matches(isDisplayed()));
    }

    public void checkAllNews(){
        Allure.step("Развернуть/свернуть блок новостей");
        mainElement.getNewsBlockButton().check(matches(isDisplayed()));
        mainElement.getNewsBlockButton().perform(click());
    }

    public void allNewsAreDisplayed(){
        Allure.step("Блок новостей развернут");
        mainElement.getAllNewsButton().check(matches(isDisplayed()));
    }

    public void allNewsNotDisplayed(){
        Allure.step("Блок новостей свернут");
        mainElement.getAllNewsButton().check(matches(not(isDisplayed())));
    }

    public void checkNews(int position){
        Allure.step("Развернуть новость");
        mainElement.getChildNews().perform(actionOnItemAtPosition(position, click()));
    }

    public void descriptionDisplayed(int position){
        Allure.step("Отображение описания новости");
        String descriptionText = Helper.Text.getText(onView(withIndex(mainElement.getNewsDescriptionText(), position)));
        onView(allOf(withText(descriptionText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickAllNewsButton(){
        Allure.step("Нажать на Все Новости");
        mainElement.getAllNewsButton().check(matches(isDisplayed()));
        mainElement.getAllNewsButton().perform(click());
    }

    public void clickOurMissionButton(){
        Allure.step("Нажать на Наша миссия");
        mainElement.getMissionButton().check(matches(isDisplayed()));
        mainElement.getMissionButton().perform(click());
    }

    public void clickLogoutButton(){
        Allure.step("Нажать на Выйти");
        mainElement.getLogoutButton().check(matches(isDisplayed()));
        mainElement.getLogoutButton().perform(click());
        onView(isRoot()).perform(waitForElement(withText("Log out"), 5000));
        mainElement.getLogoutText().check(matches(isDisplayed()));
        mainElement.getLogoutText().perform(click());
    }

    public void clickMenuButton(){
        Allure.step("Нажать на меню");
        mainElement.getMenuButton().check(matches(isDisplayed()));
        mainElement.getMenuButton().perform(click());
    }

    public void checkMenuList(){
        Allure.step("Проверка списка меню");
        mainElement.getMainText().check(matches(isDisplayed()));
        mainElement.getNewsText().check(matches(isDisplayed()));
        mainElement.getAboutText().check(matches(isDisplayed()));
    }

    public void clickOnNews(){
        Allure.step("Нажать на кнопку новости в меню");
        mainElement.getMenuButton().perform(click());
        mainElement.getNewsText().check(matches(isDisplayed()));
        mainElement.getNewsText().perform(click());
    }

    public void clickOnAboutUs(){
        Allure.step("Нажать на кнопку О нас в меню");
        mainElement.getMenuButton().perform(click());
        mainElement.getAboutText().check(matches(isDisplayed()));
        mainElement.getAboutText().perform(click());
    }

    public void clickOnMain(){
        Allure.step("Нажать на кнопку Главная в меню");
        mainElement.getMenuButton().perform(click());
        mainElement.getMainText().check(matches(isDisplayed()));
        mainElement.getMainText().perform(click());
    }
}