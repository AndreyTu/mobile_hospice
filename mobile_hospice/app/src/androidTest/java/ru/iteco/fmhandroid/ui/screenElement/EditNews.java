package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана редактирования новости
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class EditNews {
    private final ViewInteraction editName;
    private final ViewInteraction newsCategoryText;
    private final ViewInteraction newsPublishTimeText;
    private final ViewInteraction newsTitleEditText;
    private final ViewInteraction newsDescriptionText;
    private final ViewInteraction switcher;
    private final ViewInteraction newsPublishDateText;

    public EditNews() {
        this.editName = onView(withText("Editing"));
        this.newsCategoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        this.newsPublishTimeText = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        this.newsTitleEditText = onView(withId(R.id.news_item_title_text_input_edit_text));
        this.newsDescriptionText = onView(withId(R.id.news_item_description_text_input_edit_text));
        this.switcher = onView(withId(R.id.switcher));
        this.newsPublishDateText = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    /**
     * Возвращает элемент с заголовком "Editing"
     */
    public ViewInteraction getEditName() {
        return editName;
    }

    /**
     * Возвращает поле выбора категории новости
     */
    public ViewInteraction getNewsCategoryText() {
        return newsCategoryText;
    }

    /**
     * Возвращает поле ввода времени публикации
     */
    public ViewInteraction getNewsPublishTimeText() {
        return newsPublishTimeText;
    }

    /**
     * Возвращает поле ввода заголовка новости
     */
    public ViewInteraction getNewsTitleEditText() {
        return newsTitleEditText;
    }

    /**
     * Возвращает поле ввода описания новости
     */
    public ViewInteraction getNewsDescriptionText() {
        return newsDescriptionText;
    }

    /**
     * Возвращает переключатель статуса новости
     */
    public ViewInteraction getSwitcher() {
        return switcher;
    }

    /**
     * Возвращает поле ввода даты публикации
     */
    public ViewInteraction getNewsPublishDateText() {
        return newsPublishDateText;
    }
}