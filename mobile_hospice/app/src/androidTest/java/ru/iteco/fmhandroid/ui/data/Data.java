package ru.iteco.fmhandroid.ui.data;

import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentTime;

import io.bloco.faker.Faker;

public class Data {

    static Faker faker= new Faker();
    public static final String validLogin= "login2";
    public static final String validPassword= "password2";
    public static final String invalidLogin= faker.name.firstName() + faker.number.between(1,10);
    public static final String invalidPassword= faker.internet.password();
    public static final String emptyLogin= "";
    public static final String emptyPassword= "";


    public String dateOfPublic= getCurrentDate();
    public String timeOfPublic= getCurrentTime();

    public String nonNewsDate= "17.06.1999";

    public String descriptionCyr= "Описание новости";
    public String titleCyr= "Заголовок новости";
    public String emptyDescription= "";
    public String editTitle= "Отредактированный заголовок";
    public String editDescription= "Отредактированное описание";


}