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
        float x = input("Введите x: ");
        int n = (int)input("Введите n: ");
        float e = input("Введите e: ");

        System.out.println(calculateSumTerms(n, x));
        System.out.println(calculateSumTermsMore(e, false, n, x));
        System.out.println(calculateSumTermsMore(e, true, n, x));
        System.out.println(calculateOriginalExpression(x));
    }

    public static float input(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextInt();
    }

    private static double calculateSumTerms(int n, double x){
        int oddCounter = 0;
        double sum = 0;

        for(int i = 0; i < n; i+=2){
            double expression = calculateNthElementValue(i, x);

            if(oddCounter % 2 == 0){
                sum += expression;
            }else{
                sum -= expression;
            }
            oddCounter++;
        }

        return sum;
    }

    private static double calculateSumTermsMore(double e, boolean isEDivTen, int n, double x){
        int oddCounter = 0;
        double sum = 0;

        double eValue = e;

        if(isEDivTen)
            eValue = e/10;

        for(int i = 0; i < n; i+=2){
            double expression = calculateNthElementValue(i, x);

            if(Math.abs(expression) > eValue){
                if(oddCounter % 2 == 0){
                    sum += expression;
                }else{
                    sum -= expression;
                }
                oddCounter++;
            }
        }

        return sum;
    }

    private static double calculateNthElementValue(int n, double x){
        double numerator = Math.pow(x, n);
        double denumerator = factorial(n);

        return numerator / denumerator;
    }

    public static double factorial(double f) {
        double result = 1;
        for (double i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    private static double calculateOriginalExpression(double x){
        return Math.cos(x);
    }
}
