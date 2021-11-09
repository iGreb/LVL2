package ru.geekbrains.j2l5;

import java.util.Arrays;

public class HomeWorkApp {
    private static final int SIZE = 1000;
    private static final int HALF = SIZE / 2;

    private static final float[] CALCULATE(float[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }

    public static void main(String[] args) {
        HomeWorkApp methods = new HomeWorkApp();
        methods.methodOne();
        methods.methodTwo();
    }

    public static void methodOne() {
        float[] array = new float[SIZE];
        for(int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        System.out.println("Создан первый массив: \n" + Arrays.toString(array) + "\n");

        long start = System.currentTimeMillis();
        System.out.println("Время выполнения: \n" + start + "ms" + "\n");

        CALCULATE(array);
        System.out.println("Значения массива изменены: \n" + (Arrays.toString(array)) + "\n");

        long finish = System.currentTimeMillis();
        System.out.println("Время окончания метода \n" + finish + "ms" + "\n");
        System.out.println("Общее время работы: \n" + (System.currentTimeMillis() - start) + "ms" + "\n");
    }

    public static void methodTwo() {
        float[] array = new float[SIZE];
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        float[] mergedArray = new float[SIZE];
        for(int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        System.out.println("Создан второй массив: \n" + Arrays.toString(array) + "\n");

        long start = System.currentTimeMillis();
        System.out.println("Время выполнения: \n" + start + "ms" + "\n");

        System.arraycopy(array, 0, leftHalf, 0, HALF);
        System.arraycopy(array, HALF, rightHalf, 0, HALF);
        System.out.println("Массив разбит на первую половину: \n" + (Arrays.toString(leftHalf)) + "\n" +
                "И вторую половину: \n" + (Arrays.toString(rightHalf)) + "\n");

        new Thread() {
            public void run() {
                float[] a1 = CALCULATE(leftHalf);
                System.arraycopy(a1, 0, leftHalf, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = CALCULATE(rightHalf);
                System.arraycopy(a2, 0, rightHalf, 0, a2.length);
            }
        }.start();

        System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(rightHalf, 0, mergedArray, HALF, HALF);
        System.out.println("Две половины снова соединены в один общий массив: \n" + (Arrays.toString(mergedArray)) + "\n");

        long finish = System.currentTimeMillis();
        System.out.println("Время окончания метода \n" + finish + "ms" + "\n");
        System.out.println("Общее время работы: \n" + (System.currentTimeMillis() - start) + "ms");
    }
}
