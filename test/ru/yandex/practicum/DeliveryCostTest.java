package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCostTest<T> {

  private Parcel standardParcel = new StandardParcel("ПК", 50, "Москва", 12);
  private Parcel fragileParcel = new FragileParcel("Люстра", 12, "Самара", 10);
  private Parcel perishableParcel = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);


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

  private PerishableParcel perishableParcelIsExpired = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);
  private PerishableParcel perishableParcelIsExpiredZero = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);
  private PerishableParcel perishableParcelIsExpiredNegative = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);

  @Test
  public void testPerishableParcelisExpired() {
    Assertions.assertFalse(perishableParcelIsExpired.isExpired(10));
  }

  @Test
  public void testPerishableParcelisExpiredZero() {
    Assertions.assertFalse(perishableParcelIsExpiredZero.isExpired(35));
  }

  @Test
  public void perishableParcelIsExpiredNegative() {
    Assertions.assertTrue(perishableParcelIsExpiredNegative.isExpired(50));
  }

  private final List<T> listTest = new ArrayList<>();
  private ParcelBox parcelBox = new ParcelBox(100);

  private PerishableParcel perishableParcelIsExpiredParcelBox = new PerishableParcel("Картошка", 10, "Воронеж", 15, 20);

  // как реализовать тесты для добавления посылки не могу сообразить.

}