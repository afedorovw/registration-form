package pagob;

import com.codeborne.selenide.SelenideElement;
import pagob.calCom.CalenCompon;

import static com.codeborne.selenide.Selenide.$;

public class RegPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    CalenCompon calenCompon = new CalenCompon();

    public void typeFirstName() {
        firstNameInput.setValue("Igor");
    }

    public void typeLastName() {
        lastNameInput.setValue("Nem");
    }

    public RegPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegPage setBirthDate(String day, String month, String year) {
        calenCompon.setDate(day, month, year);

        return this;
    }
}
