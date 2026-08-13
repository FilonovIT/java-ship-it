package ru.yandex.practicum.delivery;
// стандартная посылка
public class StandardParcel extends Parcel{
    public static final int PRICE = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка %s упакована %n", description);
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * PRICE;
    }
}
