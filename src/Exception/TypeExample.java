package Exception;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TypeExample {
}




class CheckedExceptionEx {

    public static void main(String[] args) {
        File file = new File("fileException.txt");

        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file: " + file);
        }
    }

    public static void readFile(File file) throws FileNotFoundException {
        FileReader fr = new FileReader(file);
    }
}

class UncheckedExceptionEx {
    // NullPointerException
    public static void main(String[] args) {

        Integer value = null;
        System.out.println(value.toString());
    }
}


class ErrorExceptionEx{
    // OutOfMemoryErrorDemo
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Integer.MAX_VALUE);
    }

}