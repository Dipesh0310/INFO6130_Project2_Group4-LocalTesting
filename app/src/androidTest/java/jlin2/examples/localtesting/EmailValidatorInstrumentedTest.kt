package jlin2.examples.localtesting

import android.view.View
import android.widget.DatePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmailValidatorInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testEmailValidator_CorrectEmailSimple_ReturnsTrue() {
        val correctEmail = "123@abc.com"
        val userName = "Dipesh Chaudhary"
        val year = 1999
        val month = 2
        val day = 10

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(correctEmail), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())


        onView(withId(R.id.userNameInput)).check(matches(withText(userName)))
        onView(withId(R.id.emailInput)).check(matches(withText(correctEmail)))

        onView(withId(R.id.revertButton)).perform(click())


        onView(withId(R.id.userNameInput)).check(matches(withText(userName)))
        onView(withId(R.id.emailInput)).check(matches(withText(correctEmail)))
    }

    @Test
    fun testEmailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        val correctSubdomainEmail = "123@abc.co.ca"
        val userName = "Dipesh Chaudhary"
        val year = 1999
        val month = 2
        val day = 10

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(correctSubdomainEmail), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())


        onView(withId(R.id.userNameInput)).check(matches(withText(userName)))
        onView(withId(R.id.emailInput)).check(matches(withText(correctSubdomainEmail)))

        onView(withId(R.id.revertButton)).perform(click())


        onView(withId(R.id.userNameInput)).check(matches(withText(userName)))
        onView(withId(R.id.emailInput)).check(matches(withText(correctSubdomainEmail)))
    }

@Test
    fun testEmailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        val invalidEmailNoUsername = "@abc.com"
        val userName = "Anjila Gurung"
        val year = 2000
        val month = 12 
        val day = 23

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(invalidEmailNoUsername), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

       
        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }

    @Test
    fun testEmailValidator_InvalidEmailNoAtSymbol_ReturnsFalse() {
        val invalidEmailNoAtSymbol = "testing123"
        val userName = "Anjila Gurung"
        val year = 2000
        val month = 12
        val day = 23

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(invalidEmailNoAtSymbol), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

    
        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }


    @Test
    fun testEmailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        val invalidEmailNoDomain = "123@abc"
        val userName = "Parshant Gurung"
        val year = 2001
        val month = 5
        val day = 20

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(invalidEmailNoDomain), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

      
        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }

    @Test
    fun testEmailValidator_InvalidEmailDoubleDots_ReturnsFalse() {
        val invalidEmailDoubleDots = "123@abc..com"
        val userName = "Parshant Gurung"
        val year = 2001
        val month = 5
        val day = 20

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(invalidEmailDoubleDots), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

    
        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }

    @Test
    fun testEmailValidator_EmptyString_ReturnsFalse() {
        val emptyString = ""
        val userName = "Autsav Adhikari"
        val year = 2002
        val month = 2 
        val day = 30

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(emptyString), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }

    @Test
    fun testEmailValidator_Null_ReturnsFalse() {
        val nullString: String? = null
        val userName = "Autsav Adhikari"
        val year = 2002
        val month = 2
        val day = 30

        onView(withId(R.id.userNameInput)).perform(clearText(), typeText(userName), closeSoftKeyboard())
        onView(withId(R.id.emailInput)).perform(clearText(), typeText(nullString ?: ""), closeSoftKeyboard())
        onView(withId(R.id.dateOfBirthInput)).perform(setDate(year, month, day))

        onView(withId(R.id.saveButton)).perform(click())

        onView(withId(R.id.emailInput)).check(matches(hasErrorText("Invalid email")))
    }
    






    private fun setDate(year: Int, month: Int, day: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(DatePicker::class.java)
            }

            override fun getDescription(): String {
                return "Set the date into the DatePicker"
            }

            override fun perform(uiController: UiController, view: View) {
                val datePicker = view as DatePicker
                datePicker.updateDate(year, month, day)
            }
        }
    }
}
