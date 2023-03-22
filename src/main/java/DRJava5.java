import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/*
    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    Пусть дан список сотрудников: ...
    Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности имён.
    *Популярность не имён а номеров телефонов
 */
public class DRJava5 {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(6845923, "Иван Иванов");
        phoneBook.put(7563212, "Светлана Петрова");
        phoneBook.put(3241592, "Иван Иванов");
        phoneBook.put(7535463, "Кристина Белова");
        phoneBook.put(3426877, "Анна Мусина");
        phoneBook.put(1578312, "Анна Крутова");
        phoneBook.put(3446878, "Иван Юрин");
        phoneBook.put(1567654, "Петр Лыков");
        phoneBook.put(7894532, "Павел Чернов");
        phoneBook.put(1584632, "Петр Чернышов");
        phoneBook.put(1524354, "Мария Федорова");
        phoneBook.put(2558631, "Марина Светлова");
        phoneBook.put(1447526, "Мария Савина");
        phoneBook.put(3669984, "Мария Рыкова");
        phoneBook.put(1231234, "Марина Лугова");
        phoneBook.put(4456789, "Анна Владимирова");
        phoneBook.put(1234645, "Иван Мечников");
        phoneBook.put(1234547, "Петр Петин");
        phoneBook.put(5568952, "Иван Ежов");
        actionsRecord(phoneBook);
        nameSum(phoneBook);

    }

    private static HashMap<Integer, String> actionsRecord(HashMap<Integer, String> pb) {
        input:
        while (true) {
            System.out.print("\n Что требуется?\n" +
                    "Введите номер :\n 1 - Добавить контакт \n 2 - Удалить контакт \n " +
                    "3 - Найти контакт \n 4 - Вывести список \n q - выйти \n");
            String input = myScanner.nextLine();
            switch (input) {
                case ("1"):
                    System.out.println("Введите имя и фамилию ч/з пробел: ");
                    String name = myScanner.nextLine();
                    System.out.println("Введите номер телефона: ");
                    int key = myScanner.nextInt();
                    pb.putIfAbsent(key, name);
                    System.out.println(pb);
                    break;
                case ("2"):
                    System.out.println("Введите номер телефона, для удаления контакта: ");
                    key = myScanner.nextInt();
                    pb.remove(key);
                    System.out.println(pb);
                    break;
                case ("3"):
                    System.out.println("Введите Имя и Фамилию ч/з пробел");
                    name = myScanner.nextLine();
                    for (var item : pb.entrySet())
                        if (item.getValue().equals(name)) {
                            System.out.println(name + " Тел:" + item.getKey());
                        }

                    break;
                case ("4") :
                    System.out.println(pb);
                    break;
                case ("q") :
                    break input;
            }
        }
        return pb;
    }
    private static void nameSum (HashMap<Integer, String> pb) {
        System.out.println("Введите имя : ");
        String name = myScanner.nextLine();
        int index = 0;
        for (var item: pb.values()) {
            String tmp = item;
            tmp = tmp.substring(0, tmp.lastIndexOf(" "));
            if (tmp.equals(name)) {
                index += 1;
            }
        }
        System.out.println(name + " есть " + index + " Раз/раза");
    }

}
