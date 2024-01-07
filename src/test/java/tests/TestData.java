package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();
    String number = faker.phoneNumber().subscriberNumber(10);
    int year = faker.number().numberBetween(1950,2023);
    String month = getRandomMonth();
    String day = getRandomDay(month, year);
    String gender = getRandomGender();
    String subject = getRandomSubject();
    String hobby = getRandomHobby();
    String picture = getRandomFile();
    String state = getRandomState();
    String city = getRandomCity(state);

}
