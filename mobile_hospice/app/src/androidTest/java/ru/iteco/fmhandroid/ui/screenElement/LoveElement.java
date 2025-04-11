package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.Helper.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы экрана "Our Mission"
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class LoveElement {
    private final ViewInteraction missionName;
    private final ViewInteraction missionList;
    private final ViewInteraction missionConstraintLayout;
    private final Matcher<View> descriptionText;

    public LoveElement() {
        this.missionName = onView(withId(R.id.our_mission_title_text_view));
        this.missionList = onView(withId(R.id.our_mission_item_list_recycler_view));
        this.missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(withClassName(is("android.constraintlayout.widget.ConstraintLayout")), 0)));
        this.descriptionText = ViewMatchers.withId(R.id.our_mission_item_description_text_view);
    }

    /**
     * Возвращает элемент с заголовком раздела "Our Mission"
     */
    public ViewInteraction getMissionName() {
        return missionName;
    }

    /**
     * Возвращает список миссий
     */
    public ViewInteraction getMissionList() {
        return missionList;
    }

    /**
     * Возвращает контейнер списка миссий
     */
    public ViewInteraction getMissionConstraintLayout() {
        return missionConstraintLayout;
    }

    /**
     * Возвращает матчер для поиска описания миссии
     * @return Matcher<View> для поиска описания миссии
     */
    public Matcher<View> getDescriptionText() {
        return descriptionText;
    }
}