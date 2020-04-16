package ru.netology.web;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class TransferMoneyFromCardToCard {
    private SelenideElement countField = $("[data-test-id='amount'] input");
    private SelenideElement cardNumberField = $("[data-test-id='from'] input");
    private SelenideElement putMoneyButton = $("[data-test-id='action-transfer']");

    public void transferAmount(String transferAmount) {
        countField.setValue(transferAmount);
    }
    public DashboardPage moneyCard(Data.MoneyTransfer info) {
        cardNumberField.setValue(info.getCardNumber());
        putMoneyButton.click();
        return new DashboardPage();
    }
}

