package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final HashMap<Integer, String> hashMap = new HashMap<>();

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

                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Трекинг");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int number;
        Parcel parcel;
        int timeToLive;

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
                break;
            case 2:
                parcelInformation();
                parcel = new FragileParcel(hashMap.get(1), Integer.parseInt(hashMap.get(2)), hashMap.get(3), Integer.parseInt(hashMap.get(4)));
                allParcels.add(parcel);
                break;
            case 3:
                parcelInformation();
                System.out.println("Введите количество дней, пока посылка не испортится:");
                timeToLive = scanner.nextInt();
                parcel = new PerishableParcel(hashMap.get(1), Integer.parseInt(hashMap.get(2)), hashMap.get(3), Integer.parseInt(hashMap.get(4)), timeToLive);
                allParcels.add(parcel);
                break;
            default:
                System.out.println("Неверно выбран тип посылки!");
                break;
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        // Посчитать общую стоимость всех доставок и вывести на экран
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Сумма " + sum);
    }

    private static void parcelInformation() {
        String description;
        String weight;
        String deliveryAddress;
        String sendDay;

        System.out.println("Введите описание посылки:");
        description = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        weight = scanner.nextLine();
        System.out.println("Введите адрес назначения:");
        deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправления:");
        sendDay = scanner.nextLine();

        hashMap.put(1, description);
        hashMap.put(2, weight);
        hashMap.put(3, deliveryAddress);
        hashMap.put(4, sendDay);
    }
}

