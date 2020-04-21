package ru.netology.web;
import lombok.Value;

public class Data {
    private Data() { }
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
    @Value
    public static class VerificationCode {
        private String code;
    }
    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }
    @Value
    public static class MoneyTransfer {
        private String cardNumber;
    }
    public static MoneyTransfer oneCardInfo() {
        return new MoneyTransfer("5559 0000 0000 0001");
    }
    public static MoneyTransfer twoCardInfo() {
        return new MoneyTransfer("5559 0000 0000 0002");
    }
}

