package ru.yandex.practicum.delivery;
// хрупкая посылка
public class FragileParcel extends Parcel implements Trackable {
    public static final int PRICE = 4;
    // public static final String MSG = "Посылка <<XXX>> обёрнута в защитную плёнку";

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка <<%s>> обёрнута в защитную плёнку%n", description);
        System.out.printf("Посылка <<%s>> упакована%n", description);}

    @Override
    public int calculateDeliveryCost() {
        return weight * PRICE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("Хрупкая посылка <<%s>> изменила местоположение на <<%s>>%n", description, newLocation);
    }
}
