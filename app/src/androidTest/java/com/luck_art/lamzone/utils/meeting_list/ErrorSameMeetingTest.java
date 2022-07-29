package com.luck_art.lamzone.utils.meeting_list;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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
public class ErrorSameMeetingTest {

	@Rule
	public ActivityScenarioRule<MeetingListActivity> mActivityScenarioRule =
			new ActivityScenarioRule<>(MeetingListActivity.class);

	@Test
	public void errorSameMeetingTest() {
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
				allOf(withId(R.id.place),
						childAtPosition(
								allOf(withId(R.id.cardContainer),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												2)),
								1),
						isDisplayed()));
		appCompatSpinner.perform(click());

		DataInteraction appCompatCheckedTextView = onData(anything())
				.inAdapterView(childAtPosition(
						withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
						0))
				.atPosition(1);
		appCompatCheckedTextView.perform(click());

		ViewInteraction textInputEditText = onView(
				allOf(withId(R.id.hour),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout2),
										0),
								0),
						isDisplayed()));
		textInputEditText.perform(replaceText("11"), closeSoftKeyboard());

		ViewInteraction textInputEditText2 = onView(
				allOf(withId(R.id.topic),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout3),
										0),
								0),
						isDisplayed()));
		textInputEditText2.perform(replaceText("qzdqd"), closeSoftKeyboard());

		ViewInteraction textInputEditText3 = onView(
				allOf(withId(R.id.mail),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout4),
										0),
								0),
						isDisplayed()));
		textInputEditText3.perform(replaceText("luigii@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView = onView(
				allOf(withId(R.id.saveEmail),
						childAtPosition(
								allOf(withId(R.id.textInputLayout4),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												5)),
								1),
						isDisplayed()));
		materialTextView.perform(click());

		ViewInteraction textInputEditText4 = onView(
				allOf(withId(R.id.mail),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout4),
										0),
								0),
						isDisplayed()));
		textInputEditText4.perform(replaceText("warrio@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView2 = onView(
				allOf(withId(R.id.saveEmail),
						childAtPosition(
								allOf(withId(R.id.textInputLayout4),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												5)),
								1),
						isDisplayed()));
		materialTextView2.perform(click());

		ViewInteraction materialButton = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								7),
						isDisplayed()));
		materialButton.perform(click());

		ViewInteraction floatingActionButton2 = onView(
				allOf(withId(R.id.buttonAddMeeting),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								1),
						isDisplayed()));
		floatingActionButton2.perform(click());

		ViewInteraction appCompatSpinner2 = onView(
				allOf(withId(R.id.place),
						childAtPosition(
								allOf(withId(R.id.cardContainer),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												2)),
								1),
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
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout2),
										0),
								0),
						isDisplayed()));
		textInputEditText5.perform(replaceText("11"), closeSoftKeyboard());

		ViewInteraction textInputEditText6 = onView(
				allOf(withId(R.id.topic),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout3),
										0),
								0),
						isDisplayed()));
		textInputEditText6.perform(replaceText("zzzzzzqq"), closeSoftKeyboard());

		ViewInteraction textInputEditText7 = onView(
				allOf(withId(R.id.mail),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout4),
										0),
								0),
						isDisplayed()));
		textInputEditText7.perform(replaceText("luigi@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView3 = onView(
				allOf(withId(R.id.saveEmail),
						childAtPosition(
								allOf(withId(R.id.textInputLayout4),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												5)),
								1),
						isDisplayed()));
		materialTextView3.perform(click());

		ViewInteraction textInputEditText8 = onView(
				allOf(withId(R.id.mail),
						childAtPosition(
								childAtPosition(
										withId(R.id.textInputLayout4),
										0),
								0),
						isDisplayed()));
		textInputEditText8.perform(replaceText("warrio@gmail.com"), closeSoftKeyboard());

		ViewInteraction materialTextView4 = onView(
				allOf(withId(R.id.saveEmail),
						childAtPosition(
								allOf(withId(R.id.textInputLayout4),
										childAtPosition(
												withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
												5)),
								1),
						isDisplayed()));
		materialTextView4.perform(click());

		ViewInteraction materialButton2 = onView(
				allOf(withId(R.id.register_meeting), withText("Programmer"),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								7),
						isDisplayed()));
		materialButton2.perform(click());

		ViewInteraction textView = onView(
				allOf(withId(R.id.textView), withText("Cr�ez votre r�union"),
						withParent(withParent(withId(android.R.id.content))),
						isDisplayed()));
		textView.check(matches(withText("Cr�ez votre r�union")));
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
