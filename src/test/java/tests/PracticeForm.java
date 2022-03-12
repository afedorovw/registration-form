package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
        static void beforeAll() {
           Configuration.browserSize = "1920x1080";
        }

    @Test
    void practiceFormTest () {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Nem");
        $("#userEmail").setValue("igor@nem.com");

        $("#genterWrapper").$(byText("Other")).click();
//        $("#gender-radio-3").click(); // NOT WORKING
//        $("#gender-radio-3").doubleClick(); // BUT WHY?
//        $("#gender-radio-3").parent().click();
//        $("label[for=gender-radio-3]").click();
//        $(byText("Other")).click(); // BAD PRACTICE

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--030")
//                .filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first() // or .get(0)
//                .click();
//        $("[aria-label=Choose Wednesday, July 30th, 2008]").click(); // NOT WORKING
//        $("[aria-label=\"Choose Wednesday, July 30th, 2008\"]").click();
//        $("[aria-label='Choose Wednesday, July 30th, 2008']").click();
        $("[aria-label$='July 30th, 2008']").click();
//        $x("//*[contains(@aria-label, \"July 30th, 2008\")]").click();

// <div class="react-datepicker__day--030 react-datepicker__day--outside-month"  aria-label="Choose Monday, June 30th, 2008">30</div>
// <div class="react-datepicker__day--030"

        $("#subjectsInput").setValue("history").pressEnter();
//        $("#subjectsInput").setValue("M"); // todo Why not working
//        $("#subjectsWrapper").$(byText("Math")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        File file = new File("src/test/resources/pict.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("pict.jpg");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        File someFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(someFile);

//        $("#uploadPicture").uploadFromClasspath("test/resources/pict.

        $("#currentAddress").val("Some address 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").shouldHave(text("Submit"));
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
/*        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
*/
    }
}
