/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> tm = new TreeMap<String, Double>();
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        while (file.ready()) {
            String[] fields = file.readLine().split(" ");
            Double a = Double.parseDouble(fields[1]);
            Double value = tm.get(fields[0]);
            tm.put(fields[0], (value == null)? a : value + a);
        }
        file.close();

        // looking for a rich
        double max = 0;
        for (Map.Entry<String, Double> item : tm.entrySet())
            if (item.getValue() > max)
                max = item.getValue();

        // output
        for (Map.Entry<String, Double> item : tm.entrySet())
            if (item.getValue() == max)
                System.out.println(item.getKey());
    }
}