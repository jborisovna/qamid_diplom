package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsElements {
    public ViewInteraction newsScreenName = onView(withText(R.string.news)); //заголовок раздела
    public ViewInteraction allNewsList = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction editButton = onView(
            allOf(withId(R.id.edit_news_material_button)));
    public ViewInteraction expandNewsButton = onView(
            allOf(withId(R.id.news_list_recycler_view)));
    public ViewInteraction filterScreenName = onView(withText("Фильтровать новости"));
    public ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction startDateField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction endDateField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction filterButton = onView(withText("Фильтровать"));
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    public ViewInteraction nothingToShowWarning = onView(withText("Здесь пока ничего нет…"));
    public ViewInteraction refreshButton = onView(withText("Обновить"));
    public ViewInteraction butterflyImage = onView(withId(R.id.empty_news_list_image_view));


    public ViewInteraction controlPanelScreen = onView(withText("Панель управления"));
    public ViewInteraction newsFilterButton = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction blockOfNews = onView(withId(R.id.news_list_recycler_view));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction okButton = onView(withText("OK"));

    public ViewInteraction deleteConfirm = onView(withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем."));
    public ViewInteraction newsStatusActive = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
    public ViewInteraction newsStatusNotActive = onView(withIndex(withId(R.id.news_item_published_text_view), 0));

    public ViewInteraction creatingNewsScreenName = onView(withText("Создание"));
    public ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction publicationDateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));

    public ViewInteraction editingNewsScreenName = onView(withText("Редактирование"));
    public ViewInteraction editCategoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction editTitleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction statusSwitcher = onView(withId(R.id.switcher));
    public ViewInteraction activeCheckBox = onView(withId(R.id.filter_news_active_material_check_box));
    public ViewInteraction notActiveCheckBox = onView(withId(R.id.filter_news_inactive_material_check_box));
}
