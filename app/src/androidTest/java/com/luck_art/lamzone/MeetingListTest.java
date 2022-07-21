package com.luck_art.lamzone;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.luck_art.lamzone.ui.meeting_list.MeetingListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingListTest {

	// This is fixed
	private static int ITEMS_COUNT = 12;

	private ActivityScenario<MeetingListActivity> mActivity;

	@Rule
	public ActivityScenarioRule<MeetingListActivity> mActivityRule =
			new ActivityScenarioRule(MeetingListActivity.class);

	@Before
	public void setUp() {
		mActivity = mActivityRule.getScenario();
		assertThat(mActivity, notNullValue());
	}

	/**
	 * We ensure that our recyclerview is displaying at least on item
	 */
	@Test
	public void myMeetingsList_shouldNotBeEmpty() {
		// First scroll to the position that needs to be matched and click on it.
		onView(ViewMatchers.withId(R.id.recycler_meeting_list))
				.check(matches(hasMinimumChildCount(1)));
	}

	/**
	 * When we delete an item, the item is no more shown
	 */
	@Test
	public void myMeetingList_deleteAction_shouldRemoveItem() {
		// Given : We remove the element at position 2
		onView(ViewMatchers.withId(R.id.recycler_meeting_list)).check(withItemCount(ITEMS_COUNT));
		// When perform a click on a delete icon
		onView(ViewMatchers.withId(R.id.recycler_meeting_list))
				.perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
		// Then : the number of element is 11
		onView(ViewMatchers.withId(R.id.recycler_meeting_list)).check(withItemCount(ITEMS_COUNT-1));
	}
}