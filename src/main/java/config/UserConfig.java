package config;

import org.apache.commons.lang3.RandomStringUtils;

public class UserConfig {
    public static final String USER_NAME = "AliaksandraRyzhyk";
    public static final String USER_LOGIN = "DemoTest@list.ru";
    public static final String USER_PASSWORD = "Password!1";
    public static final String USER_CONFIRM_PASSWORD = "Password!1";

    public static String getBaseURI() {
        return "https://api.unisender.com/ru/api";
    }

    public static String getFormat() {
        return "json";
    }

    public static String getApiKey() {
        return "6jbr9h54ug9f93gq1um6k684swstsq5ozo5cj7oa";
    }

    public static String getTitle() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString;
    }

    public static String getListId() {
        String generatedString = RandomStringUtils.randomNumeric(1);
        return generatedString;
    }

    public static String getUserName() {
        return "ryzhik.sasha@list.ru";
    }

    public static String getUserEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString + "@list.ru");
    }

    public static String getSubject() {
        return "Sale";
    }

    public static String getTitleTemplate() {
        return "Autumn sale steam";
    }

    public static String getBody() {
        return ("<p>Вам полагается скидка 10%</p>");
    }

    public static String getDoubleOption() {
        return "3";
    }

    public static String getContactType() {
        return "email";
    }

}
