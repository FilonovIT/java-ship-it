package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public abstract void packageItem();
}
