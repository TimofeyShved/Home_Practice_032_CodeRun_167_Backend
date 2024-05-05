# Бекенд

<div align="center"><h2> CodeRun </h2></div>

>Уровень: <font color="red">**сложная**</font>

167. Произведение

___

Задача
--------

У Васи есть массив A длины N из неотрицательных целых чисел и число M. 
Необходимо выбрать ровно K элементов массива A, чтобы их произведение было в точности равно M.

### Формат ввода
Первая строка входного файла содержит три числа N, M, K (1≤K≤N≤5000^9,0≤M≤10) — размер массива A, произведение, которое нужно построить, и количество выбираемых элементов соответственно.

Вторая строка входного файла содержит N неотрицательных целых чисел Ai (0 ≤ Ai ≤ 10^9) — элементы массива A.

Гарантируется, что ответ всегда существует.

### Формат вывода
Выведите K различных натуральных чисел — индексы выбранных элементов массива A. 
Если решений несколько, выведите любое. Индексы можно выводить в произвольном порядке.

### Ограничения

<table border="3">
<tr>
<td>

Ограничение времени

</td><td>

1 с

</td></tr>
<td>

Ограничение памяти

</td><td>

256 МБ

</td></tr>
</table>

Пример 1
<table border="3">
<tr>
<td>

Ввод

</td><td>

7 27 2

9 1 1 27 3 27 3

</td></tr>
<td>

Вывод

</td><td>

4 2

</td></tr>
</table>

Пример 2
<table border="3">
<tr>
<td>

Ввод

</td><td>

7 60 4

30 1 1 3 10 6 4

</td></tr>
<td>

Вывод

</td><td>

5 6 3 2

</td></tr>
</table>


>Можно было объяснить проще (-_-;)・・・
>
>Как видим пример №1, выше (7, 27, 2), 7 значений, произведение чисел должно дать 27, чисел всего 2.
>
>А теперь мы должы посмтреть на цифры (9 1 1 27 3 27 3), какие 2 числа подходят...
> 
>Видим что есть 4 пары: 2 * 4, 3 * 4, 2 * 6, 3 * 6. Но так как нам нужна одна пара, то оэтому вывод: 4 2



___
Решение:
--------

~~~Java
    // Получение всех возмоэных комбинаций

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
~~~

Не проходит по времени и формату вывода (￢_￢)


Итог: 
--------

>- [ ] Есть готовое решение 
>- [X] Свой код написан 
