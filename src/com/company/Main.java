package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int K = Integer.parseInt(parts[2]);

        int[] integerArr = new int[N];

        String[] parts_2 = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            integerArr[i] = Integer.parseInt(parts_2[i]);
        }

        HashSet<int[]> trueMap = perebor(M, K, integerArr);

        for (int[] ints: trueMap){
            String s = "";
            for (int i: ints){
                s += (i+1) + " ";
            }
            System.out.println(s);
            //writer.write(s);
        }


        reader.close();
        writer.close();
    }

    public static HashSet<int[]> perebor(int m, int k, int[] integerArr){
        HashSet<int[]> trueMap = new HashSet<int[]>();

        HashSet<int[]> map;
        map = CreatMap(k, integerArr);

        for (int[] ints: map){
            int proizved = 1;

            for (int i: ints){
                proizved *= integerArr[i];
            }

            if (proizved == m){
                trueMap.add(ints);
            }
        }


        return trueMap;
    }

    public static HashSet<int[]> CreatMap(int k, int[] intArr){
        HashSet<int[]> map = new HashSet<int[]>();
        int[] newIntArr = intArr;
        int[] key;

        if (k > 0){
            key = new int[k];

            for (int i = 0; i < intArr.length; i++){

                if(intArr[i] != 0) {

                    int odlNum = newIntArr[i];
                    newIntArr[i] = 0;
                    key[k - 1] = i;

                    if(k != 1) {
                        HashSet<int[]> map_2 = CreatMap(k - 1, newIntArr);
                        for (int[] key_2 : map_2) {
                            for (int j = 0; j < key_2.length; j++) {
                                key[j] = key_2[j];
                            }
                            map.add(key.clone());
                        }
                    }else {
                        map.add(key.clone());
                    }

                    newIntArr[i] = odlNum;
                }

            }

        }
        k--;

        return map;
    }
}
