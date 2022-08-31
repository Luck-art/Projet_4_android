package com.luck_art.lamzone.utils.meeting_list;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MeetingFilterPlaceTest {

	@Rule
	public ActivityScenarioRule<MeetingListActivity> mActivityScenarioRule =
			new ActivityScenarioRule<>(MeetingListActivity.class);

	@Test
	public void meetingFilterPlaceTest() {

		DI.getMeetingApiService().clear();

		ViewInteraction floatingActionButton = onView(
				allOf(withId(R.id.buttonAddMeeting),
						isDisplayed()));
		floatingActionButton.perform(click());

		ViewInteraction appCompatSpinner = onView(
				allOf(withId(R.id.place),
						isDisplayed()));
		appCompatSpinner.perform(click());

		DataInteraction appCompatCheckedTextView = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(0);
		appCompatCheckedTextView.perform(click());

		ViewInteraction textInputEditText = onView(
				allOf(withId(R.id.hour),
						isDisplayed()));
		textInputEditText.perform(replaceText("11"), closeSoftKeyboard());

		ViewInteraction textInputEditText2 = onView(
				allOf(withId(R.id.topic),
						isDisplayed()));
		textInputEditText2.perform(replaceText("qzdqd"), closeSoftKeyboard());

		ViewInteraction textInputEditText3 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText3.perform(replaceText("mario@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView.perform(click());

		ViewInteraction textInputEditText4 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText4.perform(replaceText("luigi@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView2 = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView2.perform(click());

		ViewInteraction materialButton = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						isDisplayed()));
		materialButton.perform(click());

		ViewInteraction floatingActionButton2 = onView(
				allOf(withId(R.id.buttonAddMeeting),
						isDisplayed()));
		floatingActionButton2.perform(click());

		ViewInteraction appCompatSpinner2 = onView(
				allOf(withId(R.id.place),
						isDisplayed()));
		appCompatSpinner2.perform(click());

		DataInteraction appCompatCheckedTextView2 = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(1);
		appCompatCheckedTextView2.perform(click());

		ViewInteraction textInputEditText5 = onView(
				allOf(withId(R.id.hour),
						isDisplayed()));
		textInputEditText5.perform(replaceText("14"), closeSoftKeyboard());

		ViewInteraction textInputEditText6 = onView(
				allOf(withId(R.id.topic),
						isDisplayed()));
		textInputEditText6.perform(replaceText("qzds"), closeSoftKeyboard());

		ViewInteraction textInputEditText7 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText7.perform(replaceText("luigi@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView3 = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView3.perform(click());

		ViewInteraction textInputEditText8 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText8.perform(replaceText("warrioo@gmail.com"), closeSoftKeyboard());

		ViewInteraction textInputEditText9 = onView(
				allOf(withId(R.id.mail), withText("warrioo@gmail.com"),
						isDisplayed()));
		textInputEditText9.perform(click());

		ViewInteraction textInputEditText10 = onView(
				allOf(withId(R.id.mail), withText("warrioo@gmail.com"),
						isDisplayed()));
		textInputEditText10.perform(replaceText("warrio@gmail.com"));

		ViewInteraction textInputEditText11 = onView(
				allOf(withId(R.id.mail), withText("warrio@gmail.com"),
						isDisplayed()));
		textInputEditText11.perform(closeSoftKeyboard());

		ViewInteraction materialTextView4 = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView4.perform(click());

		ViewInteraction materialButton2 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						isDisplayed()));
		materialButton2.perform(click());

		ViewInteraction floatingActionButton3 = onView(
				allOf(withId(R.id.buttonAddMeeting),
						isDisplayed()));
		floatingActionButton3.perform(click());

		ViewInteraction appCompatSpinner3 = onView(
				allOf(withId(R.id.place),
						isDisplayed()));
		appCompatSpinner3.perform(click());

		DataInteraction appCompatCheckedTextView3 = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(0);
		appCompatCheckedTextView3.perform(click());

		ViewInteraction textInputEditText12 = onView(
				allOf(withId(R.id.hour),
						isDisplayed()));
		textInputEditText12.perform(replaceText("16"), closeSoftKeyboard());

		ViewInteraction textInputEditText13 = onView(
				allOf(withId(R.id.topic),
						isDisplayed()));
		textInputEditText13.perform(replaceText("sdqdz"), closeSoftKeyboard());

		ViewInteraction textInputEditText14 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText14.perform(replaceText("mario@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView5 = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView5.perform(click());

		ViewInteraction textInputEditText15 = onView(
				allOf(withId(R.id.mail),
						isDisplayed()));
		textInputEditText15.perform(replaceText("luigi@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView6 = onView(
				allOf(withId(R.id.saveEmail),
						isDisplayed()));
		materialTextView6.perform(click());

		ViewInteraction materialButton3 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						isDisplayed()));
		materialButton3.perform(click());

		ViewInteraction actionMenuItemView = onView(
				allOf(withId(R.id.filtre), withContentDescription("Filtres"),
						isDisplayed()));
		actionMenuItemView.perform(click());

		ViewInteraction textView = onView(
				allOf(withId(R.id.title), withText("Salles"),
						isDisplayed()));
		textView.perform(click());

		DataInteraction appCompatTextView = onData(anything())
				.inAdapterView(allOf(withId(R.id.select_dialog_listview)
						))
				.atPosition(0);
		appCompatTextView.perform(click());

		onView(ViewMatchers.withId(R.id.recycler_meeting_list))
				.check(matches(hasChildCount(2)));

	}

	private static Matcher<View> childAtPosition(
			final Matcher<View> parentMatcher, final int position) {

		return new TypeSafeMatcher<View>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Child at position " + position + " in parent ");
				parentMatcher.describeTo(description);
			}




			@Override
			public boolean matchesSafely(View view) {
				ViewParent parent = view.getParent();
				return parent instanceof ViewGroup && parentMatcher.matches(parent)
						&& view.equals(((ViewGroup) parent).getChildAt(position));
			}
		};
	}
}
