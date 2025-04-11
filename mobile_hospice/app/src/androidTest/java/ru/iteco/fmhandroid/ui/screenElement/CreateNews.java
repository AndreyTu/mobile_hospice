package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана создания новости
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class CreateNews {
    private final ViewInteraction titleName;
    private final ViewInteraction categoryName;
    private final ViewInteraction descriptionName;
    private final ViewInteraction publicationDateName;
    private final ViewInteraction createName;
    private final ViewInteraction categoryText;
    private final ViewInteraction titleText;
    private final ViewInteraction descriptionText;
    private final ViewInteraction timeText;
    private final ViewInteraction publishDateText;

    public CreateNews() {
        this.titleName = onView(withHint("Title"));
        this.categoryName = onView(withHint("Category"));
        this.descriptionName = onView(withHint("Description"));
        this.publicationDateName = onView(withHint("Publication date"));
        this.createName = onView(withText("Creating"));
        this.categoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        this.titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
        this.descriptionText = onView(withId(R.id.news_item_description_text_input_edit_text));
        this.timeText = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        this.publishDateText = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    /**
     * Возвращает поле ввода заголовка
     */
    public ViewInteraction getTitleName() {
        return titleName;
    }

    /**
     * Возвращает поле выбора категории
     */
    public ViewInteraction getCategoryName() {
        return categoryName;
    }

    /**
     * Возвращает поле ввода описания
     */
    public ViewInteraction getDescriptionName() {
        return descriptionName;
    }

    /**
     * Возвращает поле ввода даты публикации
     */
    public ViewInteraction getPublicationDateName() {
        return publicationDateName;
    }

    /**
     * Возвращает элемент с заголовком "Creating"
     */
    public ViewInteraction getCreateName() {
        return createName;
    }

    /**
     * Возвращает поле выбора категории новости
     */
    public ViewInteraction getCategoryText() {
        return categoryText;
    }

    /**
     * Возвращает поле ввода заголовка новости
     */
    public ViewInteraction getTitleText() {
        return titleText;
    }

    /**
     * Возвращает поле ввода описания новости
     */
    public ViewInteraction getDescriptionText() {
        return descriptionText;
    }

    /**
     * Возвращает поле ввода времени публикации
     */
    public ViewInteraction getTimeText() {
        return timeText;
    }

    /**
     * Возвращает поле ввода даты публикации
     */
    public ViewInteraction getPublishDateText() {
        return publishDateText;
    }
}