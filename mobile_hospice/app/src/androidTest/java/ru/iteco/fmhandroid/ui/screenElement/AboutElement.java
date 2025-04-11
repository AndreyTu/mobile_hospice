package ru.iteco.fmhandroid.ui.screenElement;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

/**
 * Класс, представляющий элементы страницы "О приложении"
 * Реализует паттерн PageObject для работы с элементами экрана
 */
public class AboutElement {
    private final ViewInteraction trademark;
    private final ViewInteraction versionTitle;
    private final ViewInteraction versionValue;
    private final ViewInteraction privacyPolicyLabel;
    private final ViewInteraction privacyPolicyValue;
    private final ViewInteraction termsOfUseLabel;
    private final ViewInteraction termsOfUseValue;
    private final ViewInteraction companyInfoLabel;
    private final ViewInteraction returnButton;

    public AboutElement() {
        this.trademark = onView(withId(R.id.trademark_image_view));
        this.versionTitle = onView(withId(R.id.about_version_title_text_view));
        this.versionValue = onView(withId(R.id.about_version_value_text_view));
        this.privacyPolicyLabel = onView(withId(R.id.about_privacy_policy_label_text_view));
        this.privacyPolicyValue = onView(withId(R.id.about_privacy_policy_value_text_view));
        this.termsOfUseLabel = onView(withId(R.id.about_terms_of_use_label_text_view));
        this.termsOfUseValue = onView(withId(R.id.about_terms_of_use_value_text_view));
        this.companyInfoLabel = onView(withId(R.id.about_company_info_label_text_view));
        this.returnButton = onView(withId(R.id.about_back_image_button));
    }

    /**
     * Возвращает матчер для поиска элемента с информацией о компании
     * @return Matcher<View> для поиска элемента с информацией о компании
     */
    public Matcher<View> getCompanyInfoMatcher() {
        return ViewMatchers.withId(R.id.about_company_info_label_text_view);
    }

    /**
     * Возвращает элемент с логотипом приложения
     */
    public ViewInteraction getTrademark() {
        return trademark;
    }

    /**
     * Возвращает элемент с заголовком версии
     */
    public ViewInteraction getVersionTitle() {
        return versionTitle;
    }

    /**
     * Возвращает элемент со значением версии
     */
    public ViewInteraction getVersionValue() {
        return versionValue;
    }

    /**
     * Возвращает элемент с заголовком политики конфиденциальности
     */
    public ViewInteraction getPrivacyPolicyLabel() {
        return privacyPolicyLabel;
    }

    /**
     * Возвращает элемент со значением политики конфиденциальности
     */
    public ViewInteraction getPrivacyPolicyValue() {
        return privacyPolicyValue;
    }

    /**
     * Возвращает элемент с заголовком условий использования
     */
    public ViewInteraction getTermsOfUseLabel() {
        return termsOfUseLabel;
    }

    /**
     * Возвращает элемент со значением условий использования
     */
    public ViewInteraction getTermsOfUseValue() {
        return termsOfUseValue;
    }

    /**
     * Возвращает элемент с информацией о компании
     */
    public ViewInteraction getCompanyInfoLabel() {
        return companyInfoLabel;
    }

    /**
     * Возвращает кнопку возврата на предыдущий экран
     */
    public ViewInteraction getReturnButton() {
        return returnButton;
    }
}