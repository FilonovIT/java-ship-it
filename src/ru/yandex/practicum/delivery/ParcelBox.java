package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final List<T> listT = new ArrayList<>();
    private int weightMax;

    public ParcelBox(int weightMax) {
        this.weightMax = weightMax;
    }

    public void addParcel(T value) {
        if ((weightMax - value.weight) == 0 || (weightMax - value.weight) > value.weight) {
            listT.add(value);
            weightMax -= value.weight;
        } else {
            System.out.println("Маленькая коробка! Доствайте новую!");
        }
    }

    public void getAllParcels() {
        for (T element : listT) {
            System.out.println(element.description);
        }
    }
}
