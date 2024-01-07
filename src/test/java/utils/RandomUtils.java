package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "qa_guru";
    }

    public static String getRandomAddress() {
        return getRandomString(5) + " " + getRandomString(5) + " " + getRandomString(7);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max+1); // рандомное число от какого до какого
    }

    public static String getRandomPhone(int len) {
        String AB = "1234567890";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomDate() {
        return String.format("%s, %s, %s", getRandomInt(1,31),
                getRandomInt(1,12), getRandomInt(1900,2023));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomDay(String month, int year) {
        int day;

        if(month == "February" & month == "April" & month == "June" &
                month == "September" & month == "November") {
            day = faker.number().numberBetween(1,30);
        }

        if(month == "February" & year % 4 == 0) {
            day = faker.number().numberBetween(1,29);
        }

        if(month == "February" & year % 4 != 0) {
            day = faker.number().numberBetween(1,28);
        }
        else day = faker.number().numberBetween(1,31);

        String a = String.valueOf(day);

        if(day == 1 || day == 2 || day == 3 || day == 4 || day == 5 ||
                day == 6 || day == 7 || day == 8 || day == 9) {
            a = String.format("0%s", day);
        }

        return a;
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};

        return getRandomItemFromArray(month);
    }

    public static String getRandomFile() {
        String[] files = {"1.png", "2.png", "3.png"};

        return getRandomItemFromArray(files);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "Chemistry", "Computer Science", "Commerce",
                "Economics", "English", "Arts"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobby);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(state);
    }

    public static String getRandomCity(String state) {
        String city = null;
        String[] cityOfNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityOfUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityOfHaryana = {"Karnal", "Panipat"};
        String[] cityOfRajasthan = {"Jaipur", "Jaiselmer"};

        if (state == "NCR") {
            city =  getRandomItemFromArray(cityOfNCR);
        }
        else if (state == "Uttar Pradesh") {
            city =  getRandomItemFromArray(cityOfUttarPradesh);
        }
        else if (state == "Haryana") {
            city =  getRandomItemFromArray(cityOfHaryana);
        }
        else if (state == "Rajasthan") {
            city =  getRandomItemFromArray(cityOfRajasthan);
        }

        return city;
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

}
