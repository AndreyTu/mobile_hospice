package ru.iteco.fmhandroid.ui.steps;

import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screenElement.SplashElement;

public class SplashStep {
    private final SplashElement splashElement = new SplashElement();

    public void appDownload(){
        Allure.step("Загрузка приложения");
        elementWaiting(splashElement.getSplashscreenImage(), 5000);
    }
}