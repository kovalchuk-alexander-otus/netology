package ru.maki;

public class Math {

  public static final int IDX_SQUARE = 0;
  public static final int IDX_LENGTH = 1;
  
  // Сумматор трех целых чисел
  public static int adder(int a, int b, int c) {
    return a+b+c;
  }

  // Универсальный сумматор целых чисел - на любое количество входящих аргуметов
  public static int adderU (int[] argument) {
    //System.out.println(argument[0]);
    //System.out.println(argument.toString());
    int resultI = 0;
    
    for (int number : argument) {
      //System.out.println(number);
      resultI += number;
    }
    
    return resultI;
  }

  // Информация по кругу: площадь круга (см²) и длина окружности (см)
  // radius - радиус круга в см.
  public static double[] getCircleInfo (double radius){
    /*double[] result = {0,0};
    result[0] = Math.PI * Math.pow(radius, 2);
    result[1] = 2 * Math.PI * radius;*/
    double[] result = { java.lang.Math.PI * java.lang.Math.pow(radius, 2)
                      , 2 * java.lang.Math.PI * radius };
    return result;
  }

}