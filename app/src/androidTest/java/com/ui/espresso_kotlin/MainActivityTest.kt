package com.ui.espresso_kotlin

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ui.espresso_kotlin.view.Dashboard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(
        MainActivity::class.java
    )

    private val FIRST_NAME = "John Brix"
    private val LAST_NAME = "Pomoy"
    private val MIDDLE_NAME = "Akira"

    @Test
    fun testUserIfSuccess(){
        // input some text in the edit text
        Espresso.onView(withId(R.id.edfName))
            .perform(ViewActions.typeText(FIRST_NAME))

        Espresso.onView(withId(R.id.edlName))
            .perform(ViewActions.typeText(LAST_NAME))

        Espresso.onView(withId(R.id.edMname))
            .perform(ViewActions.typeText(MIDDLE_NAME))
        // close soft keyboard
        Espresso.closeSoftKeyboard()

        // perform button click
        Espresso.onView(withId(R.id.btn))
            .perform(ViewActions.click())

        // checking the text in the textview and compare if True
        Espresso.onView(withId(R.id.tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("$FIRST_NAME $LAST_NAME $MIDDLE_NAME")))
    }

    @Test
    fun testOpenIntent() {
        // input some text in the edit text
        Espresso.onView(withId(R.id.edfName))
            .perform(ViewActions.typeText("open"))
        Espresso.onView(withId(R.id.edlName))
            .perform(ViewActions.typeText("the"))
        Espresso.onView(withId(R.id.edMname))
            .perform(ViewActions.typeText("intent"))

        // close soft keyboard
        Espresso.closeSoftKeyboard()

        // perform button click
        Espresso.onView(withId(R.id.btn))
            .perform(ViewActions.click())

        /*Init*/Intents.init()
        ActivityScenario.launch(Dashboard::class.java) /*launch intent*/
        Intents.release() /*End Intent*/
    }
    

}