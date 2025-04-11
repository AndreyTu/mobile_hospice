package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.elementWaiting;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана авторизации
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class AuthElement {
    private final ViewInteraction nameAuthText;
    private final ViewInteraction loginText;
    private final ViewInteraction passwordText;
    private final ViewInteraction signInButton;

    public AuthElement() {
        this.nameAuthText = onView(allOf(withText("Authorization"), 
                withParent(withParent(withId(R.id.nav_host_fragment)))));
        this.loginText = onView(allOf(withHint("Login"), 
                withParent(withParent(withId(R.id.login_text_input_layout)))));
        this.passwordText = onView(allOf(withHint("Password"), 
                withParent(withParent(withId(R.id.password_text_input_layout)))));
        this.signInButton = onView(allOf(withId(R.id.enter_button), 
                withText("SIGN IN"), 
                withContentDescription("Save"), 
                withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))));
    }

    /**
     * Возвращает элемент с заголовком "Authorization"
     */
    public ViewInteraction getNameAuthText() {
        return nameAuthText;
    }

    /**
     * Возвращает поле ввода логина
     */
    public ViewInteraction getLoginText() {
        return loginText;
    }

    /**
     * Возвращает поле ввода пароля
     */
    public ViewInteraction getPasswordText() {
        return passwordText;
    }

    /**
     * Возвращает кнопку входа в систему
     */
    public ViewInteraction getSignInButton() {
        return signInButton;
    }

    /**
     * Ожидает загрузку страницы авторизации
     * Использует Allure для логирования шага
     */
    public void loadAuthPage() {
        Allure.step("Загрузка страницы авторизации");
        elementWaiting(withId(R.id.enter_button), 5000);
    }
}