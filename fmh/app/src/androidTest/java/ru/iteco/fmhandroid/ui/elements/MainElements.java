package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.data.Helper.childAtPosition;

import ru.iteco.fmhandroid.R;

public class MainElements {
    public ViewInteraction logo = onView(withId(R.id.trademark_image_view));
    public ViewInteraction authButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction logOutButton = onView(withText(R.string.log_out));

    public ViewInteraction titleMain = onView(withText("Главная"));
    public ViewInteraction titleNews = onView(withText("Новости"));
    public ViewInteraction titleAbout = onView(withText("О приложении"));
    public ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    public ViewInteraction newsBlock = onView(withId(R.id.news_list_recycler_view));
    public ViewInteraction expandAllNewsButton = onView(allOf(withId(R.id.expand_material_button),
            childAtPosition(
                    withClassName(is("android.widget.LinearLayout")), childAtPosition(
                            withClassName(is("android.widget.LinearLayout")),
                            withId(R.id.container_list_news_include_on_fragment_main),
                            0),
                    4)));;
    public ViewInteraction expandOneNews = onView(allOf(withId(R.id.news_list_recycler_view)));
}
