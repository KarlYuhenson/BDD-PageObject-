package ru.netology.web;
import lombok.val;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.web.SelectCardPage.getTansferAmount;
import static ru.netology.web.SelectCardPage.getTransferAmountWhenDouble;

public class TransferringMoneyFromCardToCardTest {

    @Test
    void transferFromTwoCardToOneCard() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String twoCardNumber = SelectCardPage.getTwoCardNumber();
        String amount = getTansferAmount(twoCardNumber);
        val cardInfo = Data.twoCardInfo();
        SelectCardPage.selectOneCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
    }

    @Test
    void checkOneCardBalance() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String twoCardNumber = SelectCardPage.getTwoCardNumber();
        String amount = getTansferAmount(twoCardNumber);
        val cardInfo = Data.twoCardInfo();
        String oneCardNumberBeforeTransfer = SelectCardPage.getOneCardNumber();
        int expected = (SelectCardPage.getCardBalance(oneCardNumberBeforeTransfer)
                + Integer.parseInt(amount));
        SelectCardPage.selectOneCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
        String oneCardNumberAfterTransfer = SelectCardPage.getOneCardNumber();
        int actual = SelectCardPage.getCardBalance(oneCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }

    @Test
    void transferFromOneCardToTwoCard() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String oneCardNumber = SelectCardPage.getOneCardNumber();
        String amount = getTansferAmount(oneCardNumber);
        val cardInfo = Data.oneCardInfo();
        SelectCardPage.selectTwoCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
    }

    @Test
    void checkTwoCardBalance() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String oneCardNumber = SelectCardPage.getOneCardNumber();
        String amount = getTansferAmount(oneCardNumber);
        val cardInfo = Data.oneCardInfo();
        String twoCardNumberBeforeTransfer = SelectCardPage.getTwoCardNumber();
        int expected = (SelectCardPage.getCardBalance(twoCardNumberBeforeTransfer)
                + Integer.parseInt(amount));
        SelectCardPage.selectTwoCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
        String twoCardNumberAfterTransfer = SelectCardPage.getTwoCardNumber();
        int actual = SelectCardPage.getCardBalance(twoCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }

    @Test
    void doubleTransferMoneyFromTwoToOneCard() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String twoCardNumber = SelectCardPage.getTwoCardNumber();
        String amount = getTransferAmountWhenDouble(twoCardNumber);
        val cardInfo = Data.twoCardInfo();
        SelectCardPage.selectOneCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
    }

    @Test
    void checkOneCardBalanceDouble() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String twoCardNumber = SelectCardPage.getTwoCardNumber();
        String amount = getTransferAmountWhenDouble(twoCardNumber);
        val cardInfo = Data.twoCardInfo();
        String oneCardNumberBeforeTransfer = SelectCardPage.getOneCardNumber();
        double expected = (SelectCardPage.getCardBalance(oneCardNumberBeforeTransfer)
                + Double.parseDouble(amount));
        SelectCardPage.selectOneCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
        String oneCardNumberAfterTransfer = SelectCardPage.getOneCardNumber();
        double actual = SelectCardPage.getCardBalance(oneCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }

    @Test
    void doubleTransferMoneyFromOneToTwoCard() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String oneCardNumber = SelectCardPage.getOneCardNumber();
        String amount = getTransferAmountWhenDouble(oneCardNumber);
        val cardInfo = Data.oneCardInfo();
        SelectCardPage.selectTwoCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
    }

    @Test
    void checkTwoCardBalanceDouble() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String oneCardNumber = SelectCardPage.getOneCardNumber();
        String amount = getTransferAmountWhenDouble(oneCardNumber);
        val cardInfo = Data.oneCardInfo();
        String twoCardNumberBeforeTransfer = SelectCardPage.getTwoCardNumber();
        double expected = (SelectCardPage.getCardBalance(twoCardNumberBeforeTransfer)
                + Double.parseDouble(amount));
        SelectCardPage.selectTwoCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
        String twoCardNumberAfterTransfer = SelectCardPage.getTwoCardNumber();
        double actual = SelectCardPage.getCardBalance(twoCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
}



