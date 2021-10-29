package ru.geekbrains.j2l2;

public class HomeWorkApp {
    public static void main(String[] args) {
        String[][] arr = new String[][] {
                {"0", "1", "2", "3"},
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"12", "13", "14", "15"}
        };
        try{
            try{
                int result = arrays(arr);
                System.out.println(result);
            } catch(MyArraySizeException e) {
                System.out.println("Размер массива превышен!");
            }
        }
        catch(MyArrayDataException e) {
            System.out.println("Неправильное значение массива! Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }


    public static int arrays(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if(arr.length != 4) {
            throw new MyArraySizeException();
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for(int j = 0; j < arr[i].length; j++) {
                try{
                    count += Integer.parseInt(arr[i][j]);
                }
                catch(NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
