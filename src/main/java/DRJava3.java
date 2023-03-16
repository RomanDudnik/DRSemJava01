/*
    1.Реализовать алгоритм сортировки слиянием
    2.Пусть дан произвольный список целых чисел, удалить из него чётные числа
    3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    4.Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
    5.Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
    6.Повторить пятый пункт но с LinkedList.
    7.Сравнить время работы пятого и шестого пунктов.
 Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

public class DRJava3 {
    public static void main(String[] args) {
        //1.Реализовать алгоритм сортировки слиянием
        int len = 10;
        ArrayList<Integer> lst = arrLst(len);
        System.out.println("Исходный лист: " + lst);
        lst = new ArrayList<>(mergeSort(lst));
        System.out.println("Сортированный лист: " + lst);

        //2.Пусть дан произвольный список целых чисел, удалить из него чётные числа
        ArrayList<Integer> lst1 = arrLst(len);
        System.out.println("Исходный Лист 1: " + lst1);
        evenNumsDel(lst1);
        System.out.println("Лист 1 без четных чисел: " + lst1);

        //3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        ArrayList<Integer> lst2 = arrLst(len);
        System.out.println("Исходный Лист 2: " + lst2);
        int min = minNum(lst2);
        System.out.println("Минимальное число Листа 2: " + min);
        int max = maxNum(lst2);
        System.out.println("Максимальное число Листа 2: " + max);
        double mid = sumNum(lst2)/lst2.size();
        System.out.println("Среднее арифмитическое число Листа 2: " + mid);

        //4.Дано два целочисленных списка, объеденить их не допуская элементы второго списка
        // уже встречающиеся в первом.
        ArrayList<Integer> lst3 = arrLst(len);
        System.out.println("Исходный Лист 3: " + lst3);
        ArrayList<Integer> lst4 = arrLst(len);
        System.out.println("Исходный Лист 4: " + lst4);
        ArrayList<Integer> sumLst = sumLst(lst3, lst4);
        System.out.println("Объединение Лист3 + Лист4: " + sumLst);

        //5.Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
        long point = System.currentTimeMillis();
        ArrayList<Integer> lst5 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            lst5.add(0, 0);
        }
        System.out.println("Исходный Лист 5: " + lst5);

        long arrayListTime = System.currentTimeMillis() - point;

        //6. Повторить пятый пункт но с LinkedList.
        point = System.currentTimeMillis();
        LinkedList<Integer> lst6 = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            lst6.addFirst(0);
        }
        System.out.println("Исходный Лист 6: " + lst6);
        long linkedListTime = System.currentTimeMillis() - point;


        //7. Сравнить время работы пятого и шестого пунктов.
        System.out.println("Время работы пятого пункта = " + arrayListTime);
        System.out.println("Время работы шестого пункта = " + linkedListTime);
    }

    public static ArrayList<Integer> arrLst(Integer size) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lst.add(new Random().nextInt(size));
        }
        return lst;
    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> mrg) {
        if (mrg.size() <= 1) {
            return mrg;
        }
        ArrayList<Integer> left = new ArrayList<>(mrg.subList(0, mrg.size() / 2));
        ArrayList<Integer> right = new ArrayList<>(mrg.subList(mrg.size() / 2, mrg.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

        ArrayList<Integer> sort = new ArrayList<>(Arrays.asList(new Integer[left.size() + right.size()]));

        for (int k = 0, i = 0, j = 0; k < sort.size(); k++) {
            sort.set(k, i <left.size() && (j == right.size() || left.get(i) < right.get (j)) ? left.get(i++) : right.get(j++));
        }
        return sort;
    }

    public static ArrayList<Integer> evenNumsDel(ArrayList<Integer> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) % 2 == 0) {
                lst.remove(i);
                i--;
            }

        }
        return lst;
    }

    public static int minNum(ArrayList<Integer> lst) {
        int min = lst.get(0);
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) < min) {
                min = lst.get(i);
            }
        }
        return min;
    }

    public static int maxNum(ArrayList<Integer> lst) {
        int max = lst.get(0);
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) > max) {
                max = lst.get(i);
            }
        }
        return max;
    }

    public static int sumNum(ArrayList<Integer> lst) {
        int sum = lst.get(0);
        for (int i = 0; i < lst.size(); i++) {
                sum += lst.get(i);
        }
        return sum;
    }

    public static ArrayList<Integer> sumLst(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
        ArrayList<Integer> sumList = new ArrayList<>(lst1);
        for (Integer num : lst2) {
            if (!lst1.contains(num)) {
                sumList.add(num);
            }
        }
        return sumList;
    }



}
