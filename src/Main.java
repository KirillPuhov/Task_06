//При некоторых заданных х (допустимые значения х - интервал (-R, R)), n и e, определяемых
//вводом, вычислить:
// 1) сумму n слогаемых  заданного вида;
// 2) сумму тех слагаемых, которые по абсолютной величине больше e;
// 3) сумму тех слагаемых, которые по абсолютной величине больше e / 10;
// 4) значение функции с помощью методов Math;
//cos(x)=1-x^2/2!+x^4/4!-x^6/6!+... (R=infinity)

import java.util.Scanner;

public class Main {
    public static void main(String[] argv){
        double x = input("Введите x: ");
        int n = (int)input("Введите n: ");
        double e = input("Введите e: ");

        printResult(x, n, e);
    }

    public static double input(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextDouble();
    }

    public static void printResult(double x, int n, double e){
        double sumItem = 0;
        double sumItemMoreAbsolute = 0;
        double sumItemMoreAbsoluteDivided10 = 0;

        double current = 1;
        double denominator = 1;
        sumItem += current;

        if (Math.abs(current) > e) {
            sumItemMoreAbsolute += current;
        }
        if (Math.abs(current) > e/10.0){
            sumItemMoreAbsoluteDivided10 += current;
        }
        int i = 1;
        int degree = 2;
        int odd = -1;
        while (true){
            double numerator = Math.pow(x, degree);
            denominator *= i;

            if(i % 2 != 0 || denominator == 1.0){
                i++;
                continue;
            }

            current = numerator/denominator * odd;

            if (i <= n) {
                sumItem += current;
            }
            if (Math.abs(current) > e) {
                sumItemMoreAbsolute += current;
            }
            if (Math.abs(current) > e/10.0){
                sumItemMoreAbsoluteDivided10 += current;
            }
            if ( i >= n && Math.abs(current) < e/10.0){
                break;
            }
            i++;
            degree += 2;
            odd *= -1;
        }

        System.out.println(sumItem);
        System.out.println(sumItemMoreAbsolute);
        System.out.println(sumItemMoreAbsoluteDivided10);

        System.out.println(Math.cos(x));
    }
}
