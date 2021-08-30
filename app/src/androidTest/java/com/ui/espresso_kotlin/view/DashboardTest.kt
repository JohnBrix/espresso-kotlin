package com.ui.espresso_kotlin.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ui.espresso_kotlin.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<Dashboard> = ActivityScenarioRule(
        Dashboard::class.java
    )

    private val DASHBOARD = "This is Dashboard"
    private val MESSAGE = "Welcome!"
    private val NICKNAME = "Akira"

    @Test
    fun testWelcomeMsg() {
        // input some text in the edit text
        Espresso.onView(withId(R.id.dash))
            .perform(ViewActions.typeText(DASHBOARD))
        Espresso.onView(withId(R.id.msg))
            .perform(ViewActions.typeText(MESSAGE))
        Espresso.onView(withId(R.id.name))
            .perform(ViewActions.typeText(NICKNAME))

        // close soft keyboard
        Espresso.closeSoftKeyboard()

        // perform button click
        Espresso.onView(withId(R.id.btn))
            .perform(ViewActions.click())

        // checking the text in the textview
        Espresso.onView(withId(R.id.tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("$DASHBOARD $MESSAGE $NICKNAME")))
    }

}