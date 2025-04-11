package ru.iteco.fmhandroid.ui.screenElement;

import android.view.View;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана загрузки
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class SplashElement {
    private final Matcher<View> splashscreenImage;

    public SplashElement() {
        this.splashscreenImage = ViewMatchers.withId(R.id.splashscreen_image_view);
    }

    /**
     * Возвращает матчер для поиска изображения на сплэш-скрине
     * @return Matcher<View> для поиска изображения сплэш-скрина
     */
    public Matcher<View> getSplashscreenImage() {
        return splashscreenImage;
    }
}