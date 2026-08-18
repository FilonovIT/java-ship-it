package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

  private static Parcel standardParcel;
  private static Parcel fragileParcel;
  private static Parcel perishableParcel;

  @BeforeEach
  public void beforeEach() {
    standardParcel = new StandardParcel("ПК", 50, "Москва", 12);
    fragileParcel = new FragileParcel("Люстра", 12, "Самара", 10);
    perishableParcel = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);
  }

  @Test
  public void testStandardParcelCalculateDeliveryCost() { // штатное
    Assertions.assertEquals(100, standardParcel.calculateDeliveryCost());
  }

  @Test
  public void testFragileParcelCalculateDeliveryCost() { // штатное
    Assertions.assertEquals(48, fragileParcel.calculateDeliveryCost());
  }

  @Test
  public void testPerishableParcelCalculateDeliveryCost() { // штатное
    Assertions.assertEquals(30, perishableParcel.calculateDeliveryCost());
  }

}