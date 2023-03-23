import java.util.ArrayList;
import java.util.HashMap;

/*
Разработать программу, имитирующую поведение коллекции HashSet.
В программе содать метод add добавляющий элемент,
метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
*Реализовать все методы из семинара.
Формат данных Integer.
 */
public class DRJava6 {
    // реализовать заполнение без повторений эл-ов (HashMap, без использования Set)
    public static void main(String[] args) {

        MySet ms = new MySet();
        //метод add добавляющий элемент:
        ms.add(1);
        ms.add(3);
        ms.add(1);
        ms.add(3);
        ms.add(4);
        ms.add(10);
        ms.add(2);
        ms.add(3);
        ms.add(10);
        // вывод строки множеств:
        ms.print();
        //
        ms.unite(ms);
        ms.print();
        //
        ms.size();
        ms.print();
        // вывести элемент по индексу
        System.out.println(ms.get(2));
        // вывести ключи(у нас там эл-ты) в виде списка
        System.out.println(ms.toList());
        // вывести эл-ты списка до названной переменной
        System.out.println(ms.toListUpToElement(2));


    }
}

class MySet {
    private HashMap<Integer, Object> mySet;
    private static final Object OBJECT = new Object();  // финализированный статичный объект, для экономии памяти (ссылка на него)
    public MySet() {
        this.mySet = new HashMap<>();
    }
    public void add(Integer number) {
        this.mySet.putIfAbsent(number, OBJECT);
    }
    public void  print() {
        mySet.forEach((k, v) -> System.out.print(k + " "));
        System.out.println();
    }
    public void unite(MySet otherSet) {
        otherSet.mySet.forEach((k, v) -> this.add(k));
    }

    public int size() {
        return this.mySet.size();
    }
    public int get(int index) {
        return (int) this.mySet.keySet().toArray()[index];
    }
    public ArrayList<Integer> toList() {
        return new ArrayList<Integer>(this.mySet.keySet());
    }
    public ArrayList<Integer> toListUpToElement(int element) {
        if (!mySet.containsKey(element)) return null;

        ArrayList<Integer> output = new ArrayList<>();
        for (int k:
                mySet.keySet()) {
            output.add(k);
            if (k == element) break;
        }
        return output;
    }

}
