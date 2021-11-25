package io.bitrise.composetest

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun counter_init() {
        val textClicks = composeTestRule.activity.getString(R.string.clicks, 0)
        composeTestRule
            .onNodeWithText(textClicks)
            .assertExists()
    }

    @Test
    fun counter_increment() {
        val textIncrement = composeTestRule.activity.getString(R.string.increment_counter)
        val textClicks = composeTestRule.activity.getString(R.string.clicks, 1)
        composeTestRule
            .onNodeWithText(textIncrement)
            .performClick()
        composeTestRule
            .onNodeWithText(textClicks)
            .assertExists()
    }
}