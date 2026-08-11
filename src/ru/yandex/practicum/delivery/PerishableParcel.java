package ru.yandex.practicum.delivery;
// скоропортящая посылка
public class PerishableParcel extends Parcel {
    private int timeToLive;

    @Override
    public void packageItem() {
        System.out.println("Посылка <<XXX>> упакована");
    }
}
