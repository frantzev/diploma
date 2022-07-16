package ru.netology.diploma.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.Value;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


public class DataGenerator {


    private static final String SPACE = " ";
    private static final Faker FAKER = new Faker();
    private static final String APPROVED_CARD = "4444 4444 4444 4441";
    private static final String DECLINED_CARD = "4444 4444 4444 4442";
    private static final String INVALID_CARD = "4444 4444 4444 444";
    public static final String ZERO = "0";
    public static final int MIN_CVC = 100;
    public static final int MAX_CVC = 999;

    public static String generateCardHolderName() {
        Name name = FAKER.name();
        return name.lastName() + SPACE + name.firstName();
    }

    public static Calendar generateFutureDate(int atMost, int minimum, TimeUnit timeUnit) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(FAKER.date().future(atMost, minimum, timeUnit));
        return calendar;
    }

    public static Calendar generatePastDate(int atMost, int minimum, TimeUnit timeUnit) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(FAKER.date().past(atMost, minimum, timeUnit));
        return calendar;
    }

    public static String generateCVC(int min, int max){
        return String.valueOf(FAKER.number().numberBetween(min, max));
    }

    public static CardInfo generateValidCardInfo(){
        Calendar date = generateFutureDate(400, 300, TimeUnit.DAYS);
        return new CardInfo (APPROVED_CARD, getMonth(date),
                getYear(date), generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateDeclinedCardInfo(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (DECLINED_CARD, getMonth(date),
                getYear(date), generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateWithoutCardInfo(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (null, getMonth(date),
                getYear(date), generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateWithoutMonth(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (APPROVED_CARD, null,
                getYear(date), generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateWithoutYear(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (APPROVED_CARD, getMonth(date),
                null, generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateWithoutHolder(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (APPROVED_CARD, getMonth(date),
                getYear(date), null,
                generateCVC(MIN_CVC, MAX_CVC));
    }

    public static CardInfo generateWithoutCvc(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (APPROVED_CARD, getMonth(date),
                getYear(date), generateCardHolderName(),
                null);
    }

    public static CardInfo generateWithInvalidCardCardInfo(){
        Calendar date = generateFutureDate(400, 300,  TimeUnit.DAYS);
        return new CardInfo (INVALID_CARD, getMonth(date),
                getYear(date), generateCardHolderName(),
                generateCVC(MIN_CVC, MAX_CVC));
    }

    private static String getYear(Calendar date) {
        return String.valueOf(date.get(Calendar.YEAR)).substring(2,4);
    }

    private static String getMonth(Calendar date) {
        return addZero(String.valueOf(date.get(Calendar.MONTH)));
    }

    private static String addZero(String result) {
        if (result.length() == 1) {
            return ZERO + result;
        }
        return result;
    }


    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String cardHolderName;
        String cvc;
    }
}
