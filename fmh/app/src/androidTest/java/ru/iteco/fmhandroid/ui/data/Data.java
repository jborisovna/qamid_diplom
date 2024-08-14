package ru.iteco.fmhandroid.ui.data;

import static ru.iteco.fmhandroid.ui.data.Helper.Rand.random;
import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.Helper.getCurrentTime;
import static ru.iteco.fmhandroid.ui.data.Helper.getTextAtPosition;

public class Data {

    public static final String validLogin = "login2";
    public static final String validPass = "password2";
    public static final String invalidLogin = "wronglogin";
    public static final String invalidPass = "wrongpass";


    int number = random(1, 2, 3, 4, 5);
    public String newsPublicDate = getCurrentDate();
    public String dateForNonExistentNews = "12.09.2045";
    public String newsPublicTime = getCurrentTime();
    public String newsDescription = number + " " + "Описание новости";
    public String newsTitle = number + " " + "Название новости";
//    public String title = getTextAtPosition(0, 1,0);
}
