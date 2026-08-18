public class ParcelBox<T extends Parcel> {
  private static final List<T> listT = new ArrayList<>();
  private int weightMax; 

  public ParcelBox(int weightMax) {
    this.weightMax = weightMax;
  }
  
  public void addParcel(T value) {
    if ((weightMax - value.weight) == 0 || (weightMax - value.weight) > value.weight) {
      listT.add(value);
      weightMax -= value.weight;
    } else {
      System.out.println("Create new box!");
    }
  }

  public void getAllParcels(List<T> listT) {
    for (T element : listT) {
      System.out.println(element);
    }
  }
}
