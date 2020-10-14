package com.ebelli.hospitals.ui.detail

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ebelli.hospitals.R
import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.ui.main.HOSPITAL_EXTRA
import org.junit.Test

class DetailActivityTest {


    private val intent = Intent(ApplicationProvider.getApplicationContext(), DetailActivity::class.java)
        .putExtra(HOSPITAL_EXTRA, getAlbum())

    @Test
    fun elementsAreVisible() {
        val activityScenario: ActivityScenario<DetailActivity> =
            ActivityScenario.launch(intent)

            Espresso.onView(withId(R.id.detail_hospital_name))
                .check(ViewAssertions.matches(isDisplayed()))
            Espresso.onView(withId(R.id.detail_hospital_sector))
                .check(ViewAssertions.matches(isDisplayed()))
            Espresso.onView(withId(R.id.detail_hospital_type))
                .check(ViewAssertions.matches(isDisplayed()))
            Espresso.onView(withId(R.id.detail_hospital_city))
                .check(ViewAssertions.matches(isDisplayed()))

        activityScenario.close()
    }

    private fun getAlbum() = HospitalEntity(
        id = 1421,
        organisationCode = "RV9HE",
        organisationType = "Hospital",
        sector = "NHS Sector",
        isPimsManaged = true,
        organisationName = "East Riding Community Hospital",
        city = "Beverley")

}
