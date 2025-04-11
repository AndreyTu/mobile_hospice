package ru.iteco.fmhandroid.ui.data;

import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentTime;

import io.bloco.faker.Faker;

public class Data {

    private Data() {
        // Приватный конструктор для предотвращения создания экземпляров класса
    }

    static Faker faker= new Faker();
    public static final String validLogin= "login2";
    public static final String validPassword= "password2";
    public static final String invalidLogin= faker.name.firstName() + faker.number.between(1,10);
    public static final String invalidPassword= faker.internet.password();
    public static final String emptyLogin= "";
    public static final String emptyPassword= "";

    public static final String dateOfPublic= getCurrentDate();
    public static final String timeOfPublic= getCurrentTime();
    public static final String nonNewsDate= "17.06.1999";
    public static final String descriptionCyr= "Описание новости";
    public static final String titleCyr= "Заголовок новости";
    public static final String emptyDescription= "";
    public static final String editTitle= "Отредактированный заголовок";
    public static final String editDescription= "Отредактированное описание";
}