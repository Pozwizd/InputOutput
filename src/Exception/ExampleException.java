package Exception;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExampleException {



    public static void main(String[] args) {

        try {
            File file = new File("file.txt");
            FileReader fr = new FileReader(file);
        } catch (IOException e) {
            // обработка ошибки чтения файла
        }



        try(Connection conn = (Connection) ConnectionExample.getInstance();) {
            PreparedStatement stmt = (PreparedStatement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM table");
        } catch (SQLException e) {
            // обработка исключения запроса к БД
        }

        try {
            String input = "22.11.1111";
            Date date = (Date) new SimpleDateFormat("dd.MM.yyyy").parse(input);
        } catch (ParseException e) {
            // обработка ошибки разбора строки в дату
        }

        //Unchecked исключения:
        try {
            String name = null;
            int length = name.length();
        } catch (NullPointerException e) {
            // обработка ошибки обращения к null
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // обработка деления на 0
        }

        try {
            int[] array = new int[5];
            int x = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            // обработка индексации за пределы массива
        }

        try {
            int[] array = new int[5];
            int x = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            // обработка индексации за пределы массива
        }

        // Example


    }

}

