package ru.netology.web;
import lombok.val;
import org.junit.jupiter.api.Test;

import static ru.netology.web.SelectCardPage.getTansferAmount;
import static ru.netology.web.SelectCardPage.getTransferAmountWhenDouble;

public class TransferringMoneyFromCardToCardTest {

    @Test
    void TransferFromTwoCardToOneCard() {
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
    void TransferFromOneCardToTwoCard() {
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
    void doubleTransferMoneyFromTwoToOneCard() {
        val loginPage = new TheAuthenticationPage();
        loginPage.openLoginPage();
        val authInfo = Data.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = Data.getVerificationCode(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferMoneyFromCardToCard();
        String secondCardNumber = SelectCardPage.getTwoCardNumber();
        String amount = getTransferAmountWhenDouble(secondCardNumber);
        val cardInfo = Data.twoCardInfo();
        SelectCardPage.selectOneCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
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
        String firstCardNumber = SelectCardPage.getOneCardNumber();
        String amount = getTransferAmountWhenDouble(firstCardNumber);
        val cardInfo = Data.oneCardInfo();
        SelectCardPage.selectTwoCardForTransfer();
        transferPage.transferAmount(amount);
        transferPage.moneyCard(cardInfo);
    }
}


