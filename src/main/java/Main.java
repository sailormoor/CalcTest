public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);
        calc.println.accept(c);

        // При приведенных данных выдается арифметическая ошибка (деление на 0 запрещено).
        // Я сделала новую мат.операцию newDevide, которая сначала проверяется, больше ли делитель 0,
        // если больше - выполняется деление, если нет - возвращается 0.

//       int c = calc.newDevide.apply(a, b);
//       calc.println.accept(c);
    }
}
