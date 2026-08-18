package ru.yandex.practicum;

public class DeliveryCostTest {
  public static Parcel;
  
  @BeforeEach
  public void beforeEach() {
    List<Parcel> allParcels = new ArrayList<>();
    List<Parcel> reportParcels = new ArrayList<>();

    parcelStandart1 = new StandartParcel("description", 25, "deliveryAddress", 10);
    allParcels.add(parcelStandart1);
    parcelStandert2 = new StandartParcel("description", 50, "deliveryAddress", 10);
    allParcels.add(parcelStandart2);

    parcelPerichable1 = new PerishableParcel("description", 25, "deliveryAddress", 10, 15);
    allParcels.add(parcelPerichable1);
    parcelPerichable2 = new PerishableParcel("description", 25, "deliveryAddress", 10, 15);
    allParcels.add(parcelPerichable2);

    parcelFragile1 = new FragileParcel("description", 25, "deliveryAddress", 10);
    reportParcels.add(parcelFragile1);
    parcelFragile2 = new FragileParcel("description", 25, "deliveryAddress", 10);
    reportParcels.add(parcelFragile2);
  }

  @Test
  public void testCalculateDeliveryCostStandartParcel() {
    int value = parcelStandert1.calculateDeliveryCost();
    int valueP = 50;
    Assertions.assertEquals(value, valueP);
  }
  
  @Test
  public void testCalculateDeliveryCostStandartParcel() {
    int value = parcelStandert2.calculateDeliveryCost();
    int valueP = 100;
    Assertions.assertEquals(value, valueP);
  }

  @Test
  public void testCalculateDeliveryCostPerishableParcel() {
    int value = parcelPerichable1.calculateDeliveryCost();
    int valueP = 50;
    Assertions.assertEquals(value, value1);
  }
  
  @Test
  public void testCalculateDeliveryCostPerishableParcel() {
    int value = parcelPerichable2.calculateDeliveryCost();
    int valueP = 50;
    Assertions.assertEquals(value, value1);
  }
  
  @Test
  public void testCalculateDeliveryCostFragileParcel() {
    int value = parcelFragile1.calculateDeliveryCost();
    int valueP = 50;
    Assertions.assertEquals(value, value1);
  }
  
  @Test
  public void testCalculateDeliveryCostFragileParcel() {
    int value = parcelFragile2.calculateDeliveryCost();
    int valueP = 50;
    Assertions.assertEquals(value, value1);
  }
}
