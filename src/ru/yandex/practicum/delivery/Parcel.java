package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected String description;
    protected int weight; // вес
    protected String deliveryAddress;
    protected int sendDay;
    public static final int PRICE = 0;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public abstract void packageItem();

    public void deliver() {
        System.out.printf("Посылка %s доставлена по адресу %s", description, deliveryAddress); // xxx - описание, посылки yyyy - адрес назначения
    }

    public abstract int calculateDeliveryCost();
}
