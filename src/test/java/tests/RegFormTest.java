package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomEmail;

public class RegFormTest {

    String userEmail = getRandomEmail();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
//    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.lebowski().quote() + " " +
            faker.address();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("history").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/pict.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("pict.jpg");
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").shouldHave(text("Submit"));
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
