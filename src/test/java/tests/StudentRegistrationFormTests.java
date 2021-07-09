package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void dataAppearsInOutputBlockTest() {
        String firstName = "Alex",
                lastName = "Putin",
                dayOfBirth = "11",
                monthOfBirth = "May",
                yearOfBirth = "1990",
                state = "Uttar Pradesh",
                city = "Merrut";

        open("https://www.demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("ADadf@nasdp.com");
        $("#gender-radio-1").click(ClickOptions.usingJavaScript());
        $("#userNumber").setValue("89995551598");

        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();

        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());

        File file = new File("src/test/resources/pict.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("pict.jpg");

        $("#currentAddress").val("Moscow");

        //$("#state").setValue("Uttar Pradesh");
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").shouldHave(text("Submit"));
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Selenide.$(".modal-content").shouldHave(Condition.text("Thanks for submitting the form"));
        //$("#output").shouldBe(visible);
        //$("").shouldbe(visible, Duration.ofSeconds(30)); - Longer time
        //Selenide.sleep(Long.parseLong("5000"));

        // asserts
//        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
//                text(email), text(gender));
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        //$x("//td[text()='Student Email']").parent().shouldHave(text(email));
        //$x("//td[text()='Gender']").parent().shouldHave(text(gender));
        //$x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        //$x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));
        //$x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        //$x("//td[text()='Picture']").parent().shouldHave(text(picture));
        //$x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

    }
}
