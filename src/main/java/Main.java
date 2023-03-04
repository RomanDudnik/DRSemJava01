// Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)

import java.util.Random;

public class Main {
    public static void main (String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int min = 0;
        int max = 2000;
        int i = randNum(min, max);
        System.out.println("Ваше случайное число - " +i);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        int bin = Integer.toBinaryString(i).length();
        short n = bigBit(i);
        System.out.println("Старший значащий бит - " +n);

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int [] m1 = multArray(i , n);
        System.out.println("Размер массива m1 = " + m1.length);

        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int [] m2 = nonMultArray(i , n);
        System.out.println("Размер массива m1 = " + m2.length);

    }
    static int randNum(int min,int max) {
        Random random = new Random();
        int num = random.nextInt(min, max);
        return num;
    }

    static short bigBit(int num) {
        short count = 0;
        while (num != 0) {
            count++;
            num /= 2;
        }
        return count;
    }

    static int[] multArray(int num, short bit) {
        int count = 0;
        for(int i = num; i <= Short.MAX_VALUE; i++) {
            if(i % bit == 0) {
                count++;
            }
        }
        int[] arr = new int[count];
        count = 0;
        for(int j = num; j <= Short.MAX_VALUE; j++) {
            if(j % bit == 0) {
                arr[count] = j;
                count++;
            }
        }
        return (arr);
    }

    static int[] nonMultArray(int num, short bit) {
        int count = 0;
        for(int i = num; i <= Short.MIN_VALUE; i++) {
            if(i % bit != 0) {
                count++;
            }
        }
        int[] arr = new int[count];
        count = 0;
        for(int j = num; j <= Short.MIN_VALUE; j++) {
            if(j % bit != 0) {
                arr[count] = j;
                count++;
            }
        }
        return (arr);
    }
}
