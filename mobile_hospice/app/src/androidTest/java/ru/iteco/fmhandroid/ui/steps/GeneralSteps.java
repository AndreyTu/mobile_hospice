package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static org.hamcrest.core.IsNot.not;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.GeneralElements;

public class GeneralSteps {
    private final GeneralElements generalElements = new GeneralElements();

    public void clickSaveButton(){
        Allure.step("Нажать на кнопку Сохранить");
        generalElements.getSaveButton().perform(click());
    }

    public void clickCancelButton(){
        Allure.step("Нажать на кнопку Отменить");
        generalElements.getCancelButton().perform(click());
    }

    public void clickOkButton(){
        Allure.step("Нажать на кнопку ОК");
        generalElements.getOkButton().perform(click());
    }

    public void checkEmptyToast(int id, boolean visible){
        if (visible) {
            generalElements.getEmptyToastMatcher(id).check(matches(isDisplayed()));
        } else {
            generalElements.getEmptyToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkInvalidAuthDataToast(){
        Allure.step("Проверка предупреждения");
        checkEmptyToast(generalElements.getError(), true);
    }

    public void checkEmptyAuthDataToast() {
        Allure.step("Проверка предупреджения");
        checkEmptyToast(generalElements.getEmptyInfoMatcher(), true);
    }

    public void checkErrorToast(int id, boolean visible){
        if (visible) {
            generalElements.getErrorToastMatcher(id).check(matches(isDisplayed()));
        } else {
            generalElements.getErrorToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkEmptyFieldError(){
        Allure.step("Текст ошибки пустые поля");
        checkErrorToast(generalElements.getEmptyFields(), true);
    }

    public void checkInvalidData(String text, boolean visible){
        if(visible){
            generalElements.getInvalidData(text).check(matches(isDisplayed()));
        } else{
            generalElements.getInvalidData(text).check(matches(not(isDisplayed())));
        }
    }

    public void checkNewsListImage(){
        Allure.step("Проверка картинки с бабочкой");
        generalElements.getNewsListImage().check(matches(isDisplayed()));
    }

    public void checkNothingToShow(){
        Allure.step("Элемент экрана нечего показать");
        generalElements.getNoText().check(matches(isDisplayed()));
        generalElements.getRefreshText().check(matches(isDisplayed()));
    }
}