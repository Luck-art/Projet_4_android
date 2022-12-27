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

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddMeetingTest {

	@Rule
	public ActivityScenarioRule<MeetingListActivity> mActivityScenarioRule =
			new ActivityScenarioRule<>(MeetingListActivity.class);

	@Test
	public void addMeetingTest() {
		ViewInteraction floatingActionButton = onView(
				allOf(withId(R.id.buttonAddMeeting),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								1),
						isDisplayed()));
		floatingActionButton.perform(click());

		ViewInteraction appCompatSpinner = onView(
				allOf(withId(R.id.spinnerPlace),
						childAtPosition(
								allOf(withId(R.id.cardContainer),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												1)),
								1)));
		appCompatSpinner.perform(scrollTo(), click());

		DataInteraction appCompatCheckedTextView = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(1);
		appCompatCheckedTextView.perform(click());

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

		ViewInteraction appCompatSpinner2 = onView(
				allOf(withId(R.id.spinnerDuration),
						childAtPosition(
								allOf(withId(R.id.CardDuration),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												3)),
								1)));
		appCompatSpinner2.perform(scrollTo(), click());

		DataInteraction appCompatCheckedTextView2 = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(3);
		appCompatCheckedTextView2.perform(click());

		ViewInteraction textInputEditText = onView(
				allOf(withId(R.id.topic)));
		textInputEditText.perform(scrollTo(), replaceText("ddd"), closeSoftKeyboard());

		ViewInteraction textInputEditText2 = onView(
				allOf(withId(R.id.mail)));
		textInputEditText2.perform(scrollTo(), replaceText("luigi@gmail.com"), closeSoftKeyboard());

		ViewInteraction appCompatImageButton = onView(
				allOf(withId(R.id.saveEmail)));
		appCompatImageButton.perform(scrollTo(), click());

		ViewInteraction materialButton4 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						childAtPosition(
								childAtPosition(
										withClassName(is("android.widget.ScrollView")),
										0),
								7)));
		materialButton4.perform(scrollTo(), click());

		ViewInteraction textView = onView(
				allOf(withId(R.id.textPLace), withText("Luigi -"),
						withParent(withParent(withId(R.id.recycler_meeting_list))),
						isDisplayed()));
		textView.check(matches(withText("Luigi -")));
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
