package ru.netology.exceptionExtensions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Ошибка преобразования данных в ячейке [%d][%d]: '%s'", row, col, value));
    }
}
