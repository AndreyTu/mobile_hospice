package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана фильтрации новостей
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class FilterNews {
    private final ViewInteraction filterNewsName;
    private final ViewInteraction dateStartText;
    private final ViewInteraction categoryText;
    private final ViewInteraction filterButton;
    private final ViewInteraction dateEndText;
    private final ViewInteraction filterActive;
    private final ViewInteraction filterInActive;

    public FilterNews() {
        this.filterNewsName = onView(withText("Filter news"));
        this.dateStartText = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        this.categoryText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        this.filterButton = onView(withText("Filter"));
        this.dateEndText = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        this.filterActive = onView(withId(R.id.filter_news_active_material_check_box));
        this.filterInActive = onView(withId(R.id.filter_news_inactive_material_check_box));
    }

    /**
     * Возвращает элемент с заголовком "Filter news"
     */
    public ViewInteraction getFilterNewsName() {
        return filterNewsName;
    }

    /**
     * Возвращает поле ввода начальной даты
     */
    public ViewInteraction getDateStartText() {
        return dateStartText;
    }

    /**
     * Возвращает поле выбора категории
     */
    public ViewInteraction getCategoryText() {
        return categoryText;
    }

    /**
     * Возвращает кнопку фильтрации
     */
    public ViewInteraction getFilterButton() {
        return filterButton;
    }

    /**
     * Возвращает поле ввода конечной даты
     */
    public ViewInteraction getDateEndText() {
        return dateEndText;
    }

    /**
     * Возвращает чекбокс активных новостей
     */
    public ViewInteraction getFilterActive() {
        return filterActive;
    }

    /**
     * Возвращает чекбокс неактивных новостей
     */
    public ViewInteraction getFilterInActive() {
        return filterInActive;
    }
}