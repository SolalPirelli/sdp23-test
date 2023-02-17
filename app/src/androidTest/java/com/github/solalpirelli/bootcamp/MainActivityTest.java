package com.github.solalpirelli.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.*;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void sendsIntentWithName() {
        Intents.init();
        onView(withId(R.id.mainName)).perform(ViewActions.typeText("Solal"));
        onView(withId(R.id.mainName)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.mainButton)).perform(ViewActions.click());
        intended(allOf(hasComponent(GreetingActivity.class.getName()), hasExtra(GreetingActivity.NAME_KEY, "Solal")));
        Intents.release();
    }
}
