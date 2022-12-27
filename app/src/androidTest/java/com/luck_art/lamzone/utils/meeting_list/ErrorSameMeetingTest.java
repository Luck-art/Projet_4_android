package com.luck_art.lamzone.utils.meeting_list;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.luck_art.lamzone.R;
import com.luck_art.lamzone.di.DI;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ErrorSameMeetingTest {

	@Rule
	public ActivityScenarioRule<MeetingListActivity> mActivityScenarioRule =
			new ActivityScenarioRule<>(MeetingListActivity.class);

	@Test
	public void superposeMeetingActivityTest() {

		DI.getMeetingApiService().clear();

		ViewInteraction floatingActionButton = onView(
				allOf(withId(R.id.buttonAddMeeting),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								1),
						isDisplayed()));
		floatingActionButton.perform(click());

		ViewInteraction materialButton = onView(
				allOf(withId(R.id.buttonHour), withText("Choisir une heure"),
						childAtPosition(
								allOf(withId(R.id.cardHour),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												2)),
								1)));
		materialButton.perform(scrollTo(), click());

		ViewInteraction materialButton2 = onView(
				allOf(withId(android.R.id.button1), withText("OK"),
						childAtPosition(
								childAtPosition(
										withClassName(is("android.widget.ScrollView")),
										0),
								3)));
		materialButton2.perform(scrollTo(), click());

		ViewInteraction materialButton3 = onView(
				allOf(withId(android.R.id.button1), withText("OK"),
						childAtPosition(
								childAtPosition(
										withClassName(is("android.widget.ScrollView")),
										0),
								3)));
		materialButton3.perform(scrollTo(), click());

		ViewInteraction appCompatSpinner = onView(
				allOf(withId(R.id.spinnerDuration),
						childAtPosition(
								allOf(withId(R.id.CardDuration),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												3)),
								1)));
		appCompatSpinner.perform(scrollTo(), click());

		DataInteraction appCompatCheckedTextView = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(1);
		appCompatCheckedTextView.perform(click());

		ViewInteraction textInputEditText = onView(
				allOf(withId(R.id.topic)));
		textInputEditText.perform(scrollTo(), replaceText("aaa"), closeSoftKeyboard());

		ViewInteraction textInputEditText2 = onView(
				allOf(withId(R.id.mail)));
		textInputEditText2.perform(scrollTo(), replaceText("mario@gmail.com"), closeSoftKeyboard());

		ViewInteraction appCompatImageButton = onView(
				allOf(withId(R.id.saveEmail)));
		appCompatImageButton.perform(scrollTo(), click());

		ViewInteraction materialButton4 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer")));
		materialButton4.perform(scrollTo(), click());

		ViewInteraction floatingActionButton2 = onView(
				allOf(withId(R.id.buttonAddMeeting),
						isDisplayed()));
		floatingActionButton2.perform(click());

		ViewInteraction materialButton5 = onView(
				allOf(withId(R.id.buttonHour), withText("Choisir une heure")));
		materialButton5.perform(scrollTo(), click());

		ViewInteraction materialButton6 = onView(
				allOf(withId(android.R.id.button1), withText("OK")));
		materialButton6.perform(scrollTo(), click());

		ViewInteraction materialButton7 = onView(
				allOf(withId(android.R.id.button1), withText("OK")));
		materialButton7.perform(scrollTo(), click());

		ViewInteraction appCompatSpinner2 = onView(
				allOf(withId(R.id.spinnerDuration)));
		appCompatSpinner2.perform(scrollTo(), click());

		DataInteraction appCompatCheckedTextView2 = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(1);
		appCompatCheckedTextView2.perform(click());

		ViewInteraction textInputEditText3 = onView(
				allOf(withId(R.id.topic)));
		textInputEditText3.perform(scrollTo(), replaceText("aaa"), closeSoftKeyboard());

		ViewInteraction textInputEditText4 = onView(
				allOf(withId(R.id.mail)));
		textInputEditText4.perform(scrollTo(), replaceText("mario@gmail.com"), closeSoftKeyboard());

		ViewInteraction appCompatImageButton2 = onView(
				allOf(withId(R.id.saveEmail)));
		appCompatImageButton2.perform(scrollTo(), click());

		ViewInteraction materialButton8 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer")));
		materialButton8.perform(scrollTo(), click());

		ViewInteraction button = onView(
				allOf(withId(R.id.register_meeting), withText("PROGRAMMER"),
						withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
						isDisplayed()));
		button.check(matches(isDisplayed()));
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
