package ru.yandex.practicum.delivery;
// стандартная посылка
public class StandardParcel extends Parcel{


    @Override
    public void packageItem() {
        System.out.println("Посылка <<XXX>> упакована");
    }
}
