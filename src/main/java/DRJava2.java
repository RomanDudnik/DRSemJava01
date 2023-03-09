/*
1.Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
2.Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
3.*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
4.Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
5.Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
6.Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
7.*Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
 */
public class DRJava2 {
    public static void main(String[] args) {
        //1.Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        String string1 = "Hello World!";
        String string2 = "Hello";
        SearchString(string1, string2);

        //2.Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга
        // (вхождение в обратном порядке).
        String string3 = "Tenet";
        String string4 = "teneT";
        RevString(string3, string4);

        //3.*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        int ind = string4.length() - 1;
        String reverse = RevRecStr(string4, ind);
        System.out.println("Перевертыш слово - " + reverse);

        //4.Дано два числа, например 3 и 56, необходимо составить следующие строки:
        // 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        int num1 = 3;
        int num2 = 56;
        StringBuilder sum = new StringBuilder().append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        StringBuilder sub = new StringBuilder().append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        StringBuilder mult = new StringBuilder().append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
//        System.out.println(sum + " " +  sub + " " + mult);
        System.out.println(sum + "\n" +  sub + "\n" + mult);

        //5.Замените символ “=” на слово “равно”.
        // Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        String str_del = "=";
        String str_ins = "равно";
//        StringBuilder sum_del_ins = DelInsEquals(sum, str_del, str_ins);
//        StringBuilder sub_del_ins = DelInsEquals(sub, str_del, str_ins);
//        StringBuilder mult_del_ins = DelInsEquals(mult, str_del, str_ins);
//        System.out.println(sum_del_ins + "\n" +  sub_del_ins + "\n" + mult_del_ins);

        //6.Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().

        StringBuilder sum_eq = ReplaceEquals(sum, str_del, str_ins);
        StringBuilder sub_eq = ReplaceEquals(sub, str_del, str_ins);
        StringBuilder mult_eq = ReplaceEquals(mult, str_del, str_ins);
        System.out.println(sum_eq + "\n" +  sub_eq + "\n" + mult_eq);

    }
    static void SearchString(String str1, String str2) {
        if (str1.contains(str2) == true) {
            System.out.println("Слово есть в строке");
        }
        else{
            System.out.println("Такого слова в строке нет");
        }
    }

    static void RevString(String str1, String str2) {
        if (str1.equals(new StringBuilder(str2).reverse().toString()) == true) {
            System.out.println("ДА! Строки являются вращением");
        }
        else {
            System.out.println("НЕТ! Строки не зеркальные!");
        }
    }

    static String RevRecStr(String str, int i) {
        String rev = "";
        if (i >= 0) {
            return str.charAt(i) + RevRecStr(str, i - 1);
        }
        return rev;
    }

    static StringBuilder DelInsEquals (StringBuilder str, String del, String ins) {
        StringBuilder str_rep = str.insert(str.indexOf(del), ins).deleteCharAt(str.indexOf(del));
        return str_rep;
    }

    static StringBuilder ReplaceEquals(StringBuilder str, String del, String ins) {
        StringBuilder str_rep = str.replace(str.indexOf(del), str.indexOf(del) + 1, ins);
        return str_rep;
    }

}
