package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.Helper.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана новостей
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class NewsElement {
    private final ViewInteraction newsName;
    private final ViewInteraction filterNewsButton;
    private final ViewInteraction sortNewsButton;
    private final ViewInteraction allNewsBlock;
    private final ViewInteraction allNewsButton;
    private final ViewInteraction childNewsButton;
    private final ViewInteraction editNewsButton;
    private final Matcher<View> newsMainList;
    private final Matcher<View> newsTitleText;
    private final Matcher<View> descriptionTextNewsView;

    public NewsElement() {
        this.newsName = onView(withText("News"));
        this.filterNewsButton = onView(withId(R.id.filter_news_material_button));
        this.sortNewsButton = onView(withId(R.id.sort_news_material_button));
        this.allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
        this.allNewsButton = onView(withId(R.id.all_news_cards_block_constraint_layout));
        this.childNewsButton = onView(allOf(withId(R.id.news_list_recycler_view),
                childAtPosition(withClassName(is("android.widget.LinearLayout")),
                        withId(R.id.all_news_cards_block_constraint_layout), 0)));
        this.editNewsButton = onView(allOf(withId(R.id.edit_news_material_button),
                childAtPosition(
                        withClassName(is("android.widget.LinearLayout")), childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                withId(R.id.container_list_news_include), 0), 3)));
        this.newsMainList = ViewMatchers.withId(R.id.news_list_recycler_view);
        this.newsTitleText = ViewMatchers.withId(R.id.news_item_title_text_view);
        this.descriptionTextNewsView = ViewMatchers.withId(R.id.news_item_description_text_view);
    }

    /**
     * Возвращает элемент с заголовком раздела новостей
     */
    public ViewInteraction getNewsName() {
        return newsName;
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
     * Возвращает блок со всеми новостями
     */
    public ViewInteraction getAllNewsBlock() {
        return allNewsBlock;
    }

    /**
     * Возвращает кнопку просмотра всех новостей
     */
    public ViewInteraction getAllNewsButton() {
        return allNewsButton;
    }

    /**
     * Возвращает кнопку дочерней новости
     */
    public ViewInteraction getChildNewsButton() {
        return childNewsButton;
    }

    /**
     * Возвращает кнопку редактирования новости
     */
    public ViewInteraction getEditNewsButton() {
        return editNewsButton;
    }

    /**
     * Возвращает матчер для поиска основного списка новостей
     * @return Matcher<View> для поиска списка новостей
     */
    public Matcher<View> getNewsMainList() {
        return newsMainList;
    }

    /**
     * Возвращает матчер для поиска заголовка новости
     * @return Matcher<View> для поиска заголовка новости
     */
    public Matcher<View> getNewsTitleText() {
        return newsTitleText;
    }

    /**
     * Возвращает матчер для поиска описания новости
     * @return Matcher<View> для поиска описания новости
     */
    public Matcher<View> getDescriptionTextNewsView() {
        return descriptionTextNewsView;
    }
}