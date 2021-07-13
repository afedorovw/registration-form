package tests;

import com.codeborne.selenide.ClickOptions;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class RegistrationForm extends TestBase {

    private static final String MOBILE = "8999123455";
    private static final String Base_URL = "https://www.demoqa.com/";

    @Test
    @Owner("MMM")
    @Feature("Form")
    @Story("Зполнение формы")
    @Link(name = "Base_URL", value = Base_URL)
    @Tags({@Tag("web"), @Tag("other")})
    @DisplayName("Форма регистрации")
    void dataAppearsInOutputBlockTest() {
        Faker faker = new Faker();
        parameter("Mobile", MOBILE);

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                dayOfBirth = "11",
                monthOfBirth = "May",
                yearOfBirth = "1990",
                currentAddress = faker.address().fullAddress(),
                state = "NCR",
                city = "Delhi";

        step("Открываем главную страницу", () -> {
            open("https://www.demoqa.com/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });

        step("Вводим данные", () ->{
            $("#firstName").val(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
            $("#gender-radio-1").click(ClickOptions.usingJavaScript());
            $("#userNumber").setValue(MOBILE);

            $("#dateOfBirthInput").clear();
            $(".react-datepicker__year-select").selectOption(yearOfBirth);
            $(".react-datepicker__month-select").selectOption(monthOfBirth);
            $(".react-datepicker__day--0" + dayOfBirth).click();

            $("#subjectsInput").setValue("history").pressEnter();
            $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());

            File file = new File("src/test/resources/pict.jpg");
            $("#uploadPicture").uploadFile(file);
            $("#uploadPicture").uploadFromClasspath("pict.jpg");

            $("#currentAddress").val(currentAddress);

            //$("#state").val("Uttar Pradesh");
            $("#state").click();
            $("#stateCity-wrapper").$(byText(state)).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText(city)).click();

            $("#submit").shouldHave(text("Submit"));
            $("#submit").click();
        });

        step("Делаем проверку", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            //Selenide.$(".modal-content").shouldHave(Condition.text("Thanks for submitting the form"));
            // asserts
/*        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(email), text(gender)); */
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
            $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
            $x("//td[text()='Student Email']").parent().shouldHave(text(email));
            $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
            $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
            $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
        });

    }
}
