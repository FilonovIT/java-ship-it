package ru.yandex.practicum.delivery;
// хрупкая посылка
public class FragileParcel extends Parcel{
    @Override
    public void packageItem() {
        System.out.println("Посылка <<XXX>> обёрнута в защитную плёнку");
    }
}
