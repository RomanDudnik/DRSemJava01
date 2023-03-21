/*
Ввод с консоли в формате Ф.И.О Возраст пол
Выход из режима вода по горячей кнопке
Вывод несортированного списка в формате Иванов И.И. 32M
Два варианта продолжения, либо вывод списка сортированного по возрасту и полу либо завершение приложения.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;

public class DRJava4 {
    static LinkedList<ArrayList<String>> contacts = new LinkedList<>();

    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        getData();
        System.out.println("Список контактов: ");
        printContacts();
        getSort();

    }

    private static ArrayList<String> getRecord() {
        ArrayList<String> newRecord = new ArrayList<>();
        System.out.println("Введите Фамилию: ");
        String lastName = myScanner.nextLine();
        newRecord.add(lastName);
        System.out.println("Введите Имя: ");
        String firstName = myScanner.nextLine();
        newRecord.add(firstName);
        System.out.println("Введите Отчество: ");
        String middleName = myScanner.nextLine();
        newRecord.add(middleName);
        System.out.println("Введите год рождения: ");
        String age = myScanner.nextLine();
        newRecord.add(age);
        System.out.println("Введите пол: ");
        String gen = myScanner.nextLine();
        newRecord.add(gen);
        return newRecord;
    }

    private static void printContacts() {
        for (ArrayList<String> record :
                contacts) {
            System.out.print(record.get(0) + " ");
            System.out.print(record.get(1).toUpperCase().charAt(0) + ".");
            System.out.print(record.get(2).toUpperCase().charAt(0) + ". ");
            System.out.print(record.get(3));
            System.out.println(record.get(4));
        }

    }

    private static void sortAgeContacts(LinkedList<ArrayList<String>> contacts) {
        Comparator<ArrayList<String>> cmprAge = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (Integer.parseInt(t1.get(3)) > Integer.parseInt(t2.get(3))) return 1;
                else if (Integer.parseInt(t1.get(3)) < Integer.parseInt(t2.get(3))) return -1;
                else return 0;

            }
        };
        System.out.println("\nСортировка по году рождения: ");
        contacts.sort(cmprAge);
        printContacts();

    }

    private static void sortGenContacts(LinkedList<ArrayList<String>> contacts) {
        Comparator<ArrayList<String>> cmprGender = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> t1, ArrayList<String> t2) {
                if (t1.get(4).charAt(0) > t2.get(4).charAt(0)) return 1;
                else if (t1.get(4).charAt(0) < t2.get(4).charAt(0)) return -1;
                else return 0;

            }
        };
        contacts.sort(cmprGender);
        System.out.println("\nСортировка по полу: ");
        printContacts();
    }

    private static void getData() {
        String command;
        System.out.println("\nВведите '1' для ввода новой записи\n Введите '2' для завершения ввода данных\n");
        command = myScanner.nextLine();
        while (command.equals("1")) {
            contacts.add(getRecord());
            System.out.println("\nВведите '1' для ввода новой записи\n Введите '2' для завершения ввода данных\n");
            command = myScanner.nextLine();
        }
    }
    private static void getSort() {
        String command;
        System.out.println("\nВведите '1' для сортировки по возросту и полу\n Введите '2' для выхода");
        command = myScanner.nextLine();
        while (command.equals("1")) {
            sortAgeContacts(contacts);
            sortGenContacts(contacts);
            System.out.println("\nВведите '1' для сортировки по возросту и полу\n Введите '2' для выхода");
            command = myScanner.nextLine();
        }
    }

}
