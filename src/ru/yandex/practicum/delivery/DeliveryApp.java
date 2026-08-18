package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final HashMap<Integer, String> hashMap = new HashMap<>();
    private static final List<FragileParcel> reportParcels = new ArrayList<>();

    private static final ParcelBox standartParcelBox = new ParcelBox(100);
    private static final ParcelBox fragileParcelBox = new ParcelBox(100);
    private static final ParcelBox perishableParcelBox = new ParcelBox(100);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    // System.out.println("Введите имя посылки:");
                    // String nameParcel = scanner.nextLine();
                    // for (Parcel parcel : reportParcels) {
                    //    if (parcel.description.equals(nameParcel)) {
                    //        System.out.println("Введите локацию:");
                    //        String newLocation = scanner.nextLine();
                    //        parcel.reportStatus(newLocation);
                    //    }
                    // }
                    System.out.println("Введите локацию:");
                    String newLocation = scanner.nextLine();
                    for (FragileParcel parcel : reportParcels) {
                        System.out.println(parcel.description);
                        parcel.reportStatus(newLocation);
                    }
                    break;
                case 5:
                    int typeBox;
                    System.out.println("Введите тип коробки:");
                    System.out.println("1 - Стандартная");
                    System.out.println("2 - Хрупкая");
                    System.out.println("3 - Скоропортящаяся");
                    typeBox = scanner.nextInt();
                    scanner.nextLine();
                    if (typeBox == 1) {
                        standartParcelBox.getAllParcels();
                    } else {
                        if (typeBox == 2) {
                            fragileParcelBox.getAllParcels();
                        } else {
                            perishableParcelBox.getAllParcels();
                        }
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        // Посчитать общую стоимость всех доставок и вывести на экран
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
//        System.out.println("Сумма " + sum); // потом удалить

        for (Parcel parcel : reportParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Сумма " + sum);
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }

        for (Parcel parcel : reportParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Трекинг");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int number;
        Parcel parcel;
        int timeToLive;
        int currentDay;

        System.out.println("Введите тип посылки:");
        System.out.println("1 - Обычная");
        System.out.println("2 - Хрупкая");
        System.out.println("3 - Скоропортящаяся");
        number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1:
                parcelInformation();
                parcel = new StandardParcel(hashMap.get(1), Integer.parseInt(hashMap.get(2)), hashMap.get(3), Integer.parseInt(hashMap.get(4)));
                allParcels.add(parcel);
                standartParcelBox.addParcel(parcel);
                break;
            case 2:
                parcelInformation();
                parcel = new FragileParcel(hashMap.get(1), Integer.parseInt(hashMap.get(2)), hashMap.get(3), Integer.parseInt(hashMap.get(4)));
                reportParcels.add((FragileParcel) parcel);
                fragileParcelBox.addParcel(parcel);
                break;
            case 3:
                parcelInformation();
                System.out.println("Введите количество дней, пока посылка не испортится:");
                timeToLive = scanner.nextInt();
                System.out.println("Введите текущий день месяца:");
                currentDay = scanner.nextInt();
                scanner.nextLine();
                parcel = new PerishableParcel(hashMap.get(1), Integer.parseInt(hashMap.get(2)), hashMap.get(3), Integer.parseInt(hashMap.get(4)), timeToLive);

                if (!((PerishableParcel) parcel).isExpired(currentDay)) {
                    allParcels.add(parcel);
                    perishableParcelBox.addParcel(parcel);
                } else {
                    System.out.println("Посылка испортилась!"); }
                break;
            default:
                System.out.println("Неверно выбран тип посылки!");
                break;
                }
        }

    private static void parcelInformation() {
        String description;
        int weight;
        String deliveryAddress;
        String sendDay;

        System.out.println("Введите описание посылки:");
        description = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        weight = scanner.nextInt();
        scanner.nextLine();
        if (weight <= 0) {
            System.out.println("Значение должно быть больше 0! Введите корректные данные!");
            return;
        }
        System.out.println("Введите адрес назначения:");
        deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправления:");
        sendDay = scanner.nextLine(); // день месяца, в который посылка была отправлена

        hashMap.put(1, description);
        hashMap.put(2, String.valueOf(weight)); // костыль
        hashMap.put(3, deliveryAddress);
        hashMap.put(4, sendDay);
    }
}


