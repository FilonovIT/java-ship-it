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
    parcelPerichable2 = new PerishableParcel("description", 50, "deliveryAddress", 10, 15);
    allParcels.add(parcelPerichable2);

    parcelFragile1 = new FragileParcel("description", 25, "deliveryAddress", 10);
    reportParcels.add(parcelFragile1);
    parcelFragile2 = new FragileParcel("description", 50, "deliveryAddress", 10);
    reportParcels.add(parcelFragile2);
  }

    @Test
    public void calculateDeliveryCostStandartParcel() {
      Assertions.assertEquals(50, parcelStandart1.calculateDeliveryCost());  
    }

    @Test
    public void calculateDeliveryCostStandartParcel() {
      Assertions.assertEquals(100, parcelStandart2.calculateDeliveryCost());  
    }
  
    @Test
    public void calculateDeliveryCostPerishableParcel() {
      Assertions.assertEquals(50, parcelPerichable1.calculateDeliveryCost());  
    }

    @Test
    public void calculateDeliveryCostPerishableParcel() {
      Assertions.assertEquals(100, parcelPerichable2.calculateDeliveryCost());  
    }
  
    @Test
    public void calculateDeliveryFragileParcel() {
      Assertions.assertEquals(50, parcelFragile1.calculateDeliveryCost());  
    }

    @Test
    public void calculateDeliveryFragileParcel() {
      Assertions.assertEquals(100, parcelFragile2.calculateDeliveryCost());  
    }
  
    @Test 
    public void calculateDeliveryIsExpired() {
      Assertions.assertFalse(parcelPerichable1.isExpired(10, 15));
    }

  
  }
