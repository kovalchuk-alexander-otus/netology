import java.util.*;
import java.text.*;

class Main {
  public static Scanner scanner = new Scanner(System.in);
  public static DecimalFormat decimalFormat = new DecimalFormat("#.##");
  
  public static void main(String[] args) {
    getSum();
    getCircleInfo();
    scanner.close();
  }

  // Сумматор (диалог)
  public static void getSum() {

    beautifier("Сумматор");
    
    System.out.print("Введите первое число: ");
    int a = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int b = scanner.nextInt();
    System.out.print("Введите третье число: ");
    int c = scanner.nextInt();

    //System.out.println("Сумма чисел = " + math.adder(a, b, c));

    int[] arg = {a, b, c};
    /*int[] newArg = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    for (int i=0;i<arg.length;i++){
      newArg[i] = arg[i];
    }
    newArg[arg.length] = 100;*/
    
    System.out.println("Сумма чисел = " + ru.maki.Math.adderU(arg));
  }

  // Расчет площади круга и длины окружности (диалог)
  public static void getCircleInfo() {

    beautifier("Расчет площади круга и длины окружности");
    
    System.out.print("Введите радиус окружности в сантиметрах: ");
    double radius = scanner.nextDouble();

    double[] results = ru.maki.Math.getCircleInfo(radius);
    System.out.println("Площадь круга: " + decimalFormat.format(results[ru.maki.Math.IDX_SQUARE]) + " см.кв.");
    System.out.println("Длина окружности: " + decimalFormat.format(results[ru.maki.Math.IDX_LENGTH]) + " см.");
  }

  // шапка для ДЗ
  public static void beautifier (String topic) {
    System.out.println("");
    System.out.println("");
    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    System.out.println(topic);
    System.out.println("_________________________________");
    System.out.println("");
  }
}