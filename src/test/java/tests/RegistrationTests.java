package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;
import static utils.RandomUtils.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData t = new TestData();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .bannerRemove()
                .setFirstName(t.firstName)
                .setLastName(t.lastName)
                .setEmail(t.userEmail)
                .setGender(t.gender)
                .setUserNumber(t.number)
                .setDateOfBirth(t.day, t.month, t.year)
                .setSubject(t.subject)
                .setHobby(t.hobby)
                .selectPicture("img/"+t.picture)
                .setAddress(t.streetAddress)
                .setStateAndCity(t.state, t.city)
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResults()
                .checkResult("Student Name", t.firstName + " " + t.lastName)
                .checkResult("Student Email", t.userEmail)
                .checkResult("Mobile", t.number)
                .checkResult("Gender", t.gender)
                .checkResult("Date of Birth", t.day + " " + t.month +"," + t.year )
                .checkResult("Subjects", t.subject)
                .checkResult("Hobbies", t.hobby)
                .checkResult("Picture", t.picture)
                .checkResult("Address", t.streetAddress)
                .checkResult("State and City", t.state + " " + t.city);
    }

    @Test
    void successfulIncompleteRegistrationTest() {

        registrationPage.openPage()
                .bannerRemove()
                .setFirstName(t.firstName)
                .setLastName(t.lastName)
                .setGender(t.gender)
                .setUserNumber(t.number)
                .setDateOfBirth(t.day, t.month, t.year)
                .setAddress(t.streetAddress)
                .setStateAndCity(t.state, t.city)
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResults()
                .checkResult("Student Name", t.firstName + " " + t.lastName)
                .checkResult("Mobile", t.number)
                .checkResult("Gender", t.gender)
                .checkResult("Date of Birth", t.day + " " + t.month +"," + t.year )
                .checkResult("Address", t.streetAddress)
                .checkResult("State and City", t.state + " " + t.city)
                .checkEmptyResult("Subjects")
                .checkEmptyResult("Hobbies")
                .checkEmptyResult("Picture")
                .checkEmptyResult("Student Email");

    }

    @Test
    void negativeRegistrationTestWithoutLastName() {
        registrationPage.openPage()
                .bannerRemove()
                .setFirstName(t.firstName)
                .setEmail(t.userEmail)
                .setGender(t.gender)
                .setUserNumber(t.number)
                .setDateOfBirth(t.day, t.month, t.year)
                .setSubject(t.subject)
                .setHobby(t.hobby)
                .selectPicture("img/"+t.picture)
                .setAddress(t.streetAddress)
                .setStateAndCity(t.state, t.city)
                .clickSubmit();


        registrationPage.checkSpreadsheetWithResultsMissing();

    }

    @Test
    void negativeRegistrationTestWithoutGender() {
        registrationPage.openPage()
                .bannerRemove()
                .setFirstName(t.firstName)
                .setLastName(t.lastName)
                .setEmail(t.userEmail)
                .setUserNumber(t.number)
                .setDateOfBirth(t.day, t.month, t.year)
                .setSubject(t.subject)
                .setHobby(t.hobby)
                .selectPicture("img/"+t.picture)
                .setAddress(t.streetAddress)
                .setStateAndCity(t.state, t.city)
                .clickSubmit();

        registrationPage.checkSpreadsheetWithResultsMissing();

    }

}
