package ru.netology;

import ru.netology.exceptionExtensions.MyArrayDataException;
import ru.netology.exceptionExtensions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        try {
            String[][] myArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
            String[][] myArray1 = {{"1", "2", "3"}, {"5", "6", "7"}, {"9", "10", "11"}, {"13", "14", "15"}};
            String[][] myArray2 = {{"ASDA", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
            firstTask(myArray1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void firstTask(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }
        int[][] arrayInteger = new int[4][4];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInteger[i][j] = Integer.parseInt(array[i][j]);
                    sum += arrayInteger[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }

            }

        }

        for (int[] ints : arrayInteger) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
