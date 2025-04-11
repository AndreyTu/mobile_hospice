package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы панели управления новостями
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class PanelElement {
    private final ViewInteraction panelName;
    private final ViewInteraction filterNewsButton;
    private final ViewInteraction sortNewsButton;
    private final ViewInteraction newsList;
    private final ViewInteraction newsTitleText;
    private final ViewInteraction newsDescriptionText;
    private final ViewInteraction addNewsButton;
    private final ViewInteraction statusActive;
    private final ViewInteraction statusNotActive;
    private final Matcher<View> newsPublicationDate;
    private final Matcher<View> buttonEditNews;

    public PanelElement() {
        this.panelName = onView(withText("Control panel"));
        this.filterNewsButton = onView(withId(R.id.filter_news_material_button));
        this.sortNewsButton = onView(withId(R.id.sort_news_material_button));
        this.newsList = onView(withId(R.id.news_list_recycler_view));
        this.newsTitleText = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
        this.newsDescriptionText = onView(withIndex(withId(R.id.news_item_description_text_view), 0));
        this.addNewsButton = onView(withId(R.id.add_news_image_view));
        this.statusActive = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
        this.statusNotActive = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
        this.newsPublicationDate = ViewMatchers.withId(R.id.news_item_publication_date_text_view);
        this.buttonEditNews = ViewMatchers.withId(R.id.edit_news_item_image_view);
    }

    /**
     * Возвращает элемент с заголовком панели управления
     */
    public ViewInteraction getPanelName() {
        return panelName;
    }

    /**
     * Возвращает кнопку фильтрации новостей
     */
    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    /**
     * Возвращает кнопку сортировки новостей
     */
    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    /**
     * Возвращает список новостей
     */
    public ViewInteraction getNewsList() {
        return newsList;
    }

    /**
     * Возвращает элемент с заголовком новости
     */
    public ViewInteraction getNewsTitleText() {
        return newsTitleText;
    }

    /**
     * Возвращает элемент с описанием новости
     */
    public ViewInteraction getNewsDescriptionText() {
        return newsDescriptionText;
    }

    /**
     * Возвращает кнопку добавления новости
     */
    public ViewInteraction getAddNewsButton() {
        return addNewsButton;
    }

    /**
     * Возвращает элемент с активным статусом новости
     */
    public ViewInteraction getStatusActive() {
        return statusActive;
    }

    /**
     * Возвращает элемент с неактивным статусом новости
     */
    public ViewInteraction getStatusNotActive() {
        return statusNotActive;
    }

    /**
     * Возвращает кнопку удаления новости по её заголовку
     * @param newsTitle заголовок новости
     * @return ViewInteraction для кнопки удаления
     */
    public ViewInteraction getDeleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(newsTitle))))))));
    }

    /**
     * Возвращает матчер для поиска даты публикации новости
     * @return Matcher<View> для поиска даты публикации
     */
    public Matcher<View> getNewsPublicationDate() {
        return newsPublicationDate;
    }

    /**
     * Возвращает матчер для поиска кнопки редактирования новости
     * @return Matcher<View> для поиска кнопки редактирования
     */
    public Matcher<View> getButtonEditNews() {
        return buttonEditNews;
    }
}