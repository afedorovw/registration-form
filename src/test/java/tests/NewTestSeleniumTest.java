package tests;// Generated by Selenium IDE
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import java.util.*;
public class NewTestSeleniumTest {
  private Map<String, Object> vars;
  @BeforeEach
  public void setUp() {
    Configuration.browser = "chrome";
    vars = new HashMap<>();
  }
  @AfterEach
  public void tearDown() {
  }
  @Test
  public void newTestSelenium() {
    open("https://www.demoqa.com/automation-practice-form");
    WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(976, 1040));
    $("#firstName").click();
    $("#firstName").val("Ivan");
    $("#lastName").click();
    $("#lastName").val("Dorn");
    $("#userEmail").click();
    $("#userEmail").val("ido@mail.ru");
    $(".custom-radio:nth-child(1) > .custom-control-label").click();
    $("#userNumber").click();
    $("#userNumber").val("9167895463");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__day--022").click();
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("2004");
    $(".react-datepicker__year-select").click();
    $(".subjects-auto-complete__value-container").click();
    $("#react-select-2-option-0").click();
    $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
    $("#currentAddress").click();
    $("#currentAddress").val("Moscow");
    $(".css-1gtu0rj-indicatorContainer > .css-19bqh2r").click();
    $("#react-select-3-option-0").click();
    $(".css-1wa3eu0-placeholder").click();
    $("#react-select-4-option-1").click();
    $("#submit").click();
    actions().moveToElement($("#submit")).perform();
    actions().moveToElement($(byTagName("body")), 0, 0).perform();
    $("tr:nth-child(1) > td:nth-child(2)").click();
    $("tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Ivan Dorn"));
    $("tr:nth-child(4) > td:nth-child(2)").click();
    $("#closeLargeModal").click();
  }
}
