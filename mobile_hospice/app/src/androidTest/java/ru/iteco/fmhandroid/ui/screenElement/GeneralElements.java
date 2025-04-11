package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;

/**
 * Класс, представляющий общие элементы интерфейса приложения
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class GeneralElements {
    private final ViewInteraction newsListImage;
    private final ViewInteraction cancelButton;
    private final ViewInteraction saveButton;
    private final ViewInteraction okButton;
    private final ViewInteraction refreshText;
    private final ViewInteraction noText;

    public GeneralElements() {
        this.newsListImage = onView(withId(R.id.empty_news_list_image_view));
        this.cancelButton = onView(withId(R.id.cancel_button));
        this.saveButton = onView(withId(R.id.save_button));
        this.okButton = onView(withText("OK"));
        this.refreshText = onView(withText("Refresh"));
        this.noText = onView(withId(R.id.empty_news_list_text_view));
    }

    /**
     * Возвращает изображение пустого списка новостей
     */
    public ViewInteraction getNewsListImage() {
        return newsListImage;
    }

    /**
     * Возвращает кнопку отмены
     */
    public ViewInteraction getCancelButton() {
        return cancelButton;
    }

    /**
     * Возвращает кнопку сохранения
     */
    public ViewInteraction getSaveButton() {
        return saveButton;
    }

    /**
     * Возвращает кнопку OK
     */
    public ViewInteraction getOkButton() {
        return okButton;
    }

    /**
     * Возвращает элемент с текстом "Refresh"
     */
    public ViewInteraction getRefreshText() {
        return refreshText;
    }

    /**
     * Возвращает элемент с текстом "No news"
     */
    public ViewInteraction getNoText() {
        return noText;
    }

    /**
     * Возвращает элемент с сообщением об ошибке
     * @param text текст сообщения об ошибке
     * @return ViewInteraction для элемента с сообщением об ошибке
     */
    public ViewInteraction getInvalidData(String text) {
        return onView(allOf(withId(android.R.id.message), withText(text)));
    }

    /**
     * Возвращает элемент с пустым сообщением
     * @param id идентификатор ресурса сообщения
     * @return ViewInteraction для элемента с пустым сообщением
     */
    public ViewInteraction getEmptyToastMatcher(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }

    /**
     * Возвращает элемент с сообщением об ошибке
     * @param id идентификатор ресурса сообщения
     * @return ViewInteraction для элемента с сообщением об ошибке
     */
    public ViewInteraction getErrorToastMatcher(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }

    /**
     * Возвращает идентификатор ресурса для сообщения о пустом логине или пароле
     * @return идентификатор ресурса
     */
    public int getEmptyInfoMatcher() {
        return R.string.empty_login_or_password;
    }

    /**
     * Возвращает идентификатор ресурса для сообщения о пустых полях
     * @return идентификатор ресурса
     */
    public int getEmptyFields() {
        return R.string.empty_fields;
    }

    /**
     * Возвращает идентификатор ресурса для сообщения об ошибке
     * @return идентификатор ресурса
     */
    public int getError() {
        return R.string.error;
    }
}