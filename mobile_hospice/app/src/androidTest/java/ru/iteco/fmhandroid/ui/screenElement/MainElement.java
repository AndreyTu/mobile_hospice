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
 * Класс, представляющий элементы главного экрана приложения
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class MainElement {
    private final ViewInteraction logoutText;
    private final ViewInteraction mainText;
    private final ViewInteraction newsText;
    private final ViewInteraction allNews;
    private final ViewInteraction aboutText;
    private final ViewInteraction menuButton;
    private final ViewInteraction missionButton;
    private final ViewInteraction logoutButton;
    private final ViewInteraction newsList;
    private final ViewInteraction allNewsButton;
    private final ViewInteraction childNews;
    private final ViewInteraction newsBlockButton;
    private final Matcher<View> newsDescriptionText;

    public MainElement() {
        this.logoutText = onView(withText("Log out"));
        this.mainText = onView(withText("Main"));
        this.newsText = onView(withText("News"));
        this.allNews = onView(withText("ALL NEWS"));
        this.aboutText = onView(withText("About"));
        this.menuButton = onView(withId(R.id.main_menu_image_button));
        this.missionButton = onView(withId(R.id.our_mission_image_button));
        this.logoutButton = onView(withId(R.id.authorization_image_button));
        this.newsList = onView(withId(R.id.news_list_recycler_view));
        this.allNewsButton = onView(withId(R.id.all_news_text_view));
        this.childNews = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(withId(R.id.all_news_cards_block_constraint_layout), 0)));
        this.newsBlockButton = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(withClassName(is("android.widget.LinearLayout")),
                                childAtPosition(withClassName(is("android.widget.Linear.Layout")),
                                        withId(R.id.container_list_news_include_on_fragment_main), 0), 4)));
        this.newsDescriptionText = ViewMatchers.withId(R.id.news_item_description_text_view);
    }

    /**
     * Возвращает элемент с текстом "Log out"
     */
    public ViewInteraction getLogoutText() {
        return logoutText;
    }

    /**
     * Возвращает элемент с текстом "Main"
     */
    public ViewInteraction getMainText() {
        return mainText;
    }

    /**
     * Возвращает элемент с текстом "News"
     */
    public ViewInteraction getNewsText() {
        return newsText;
    }

    /**
     * Возвращает элемент с текстом "ALL NEWS"
     */
    public ViewInteraction getAllNews() {
        return allNews;
    }

    /**
     * Возвращает элемент с текстом "About"
     */
    public ViewInteraction getAboutText() {
        return aboutText;
    }

    /**
     * Возвращает кнопку меню
     */
    public ViewInteraction getMenuButton() {
        return menuButton;
    }

    /**
     * Возвращает кнопку "Our Mission"
     */
    public ViewInteraction getMissionButton() {
        return missionButton;
    }

    /**
     * Возвращает кнопку выхода из системы
     */
    public ViewInteraction getLogoutButton() {
        return logoutButton;
    }

    /**
     * Возвращает список новостей
     */
    public ViewInteraction getNewsList() {
        return newsList;
    }

    /**
     * Возвращает кнопку "All News"
     */
    public ViewInteraction getAllNewsButton() {
        return allNewsButton;
    }

    /**
     * Возвращает элемент дочерней новости
     */
    public ViewInteraction getChildNews() {
        return childNews;
    }

    /**
     * Возвращает кнопку разворачивания блока новостей
     */
    public ViewInteraction getNewsBlockButton() {
        return newsBlockButton;
    }

    /**
     * Возвращает матчер для поиска описания новости
     * @return Matcher<View> для поиска описания новости
     */
    public Matcher<View> getNewsDescriptionText() {
        return newsDescriptionText;
    }
}