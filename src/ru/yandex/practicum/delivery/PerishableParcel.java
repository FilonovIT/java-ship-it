package ru.yandex.practicum.delivery;
// скоропортящая посылка
public class PerishableParcel extends Parcel {
    public static final int PRICE = 3;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public void packageItem() {

        System.out.printf("Посылка <<%s>> упакована %n", description);
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * PRICE;
    }

    public boolean isExpired(int currentDay) {
        // currentDay — номер текущего дня месяца
        // sendDay — день месяца, в который посылка была отправлена
        // timeToLive - срок в днях, за который посылка не испортится
        
        if ((sendDay + timeToLive) >= currentDay) {
            return false;
    } else {
            return true;
    }
}
