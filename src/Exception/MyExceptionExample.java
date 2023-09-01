package Exception;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class MyExceptionExample {

    public static void validate(int age) throws MyException {
        if(age < 0) {
            throw new MyException("Возраст не может быть отрицательным");
        }
    }

    public static void main(String[] args) {
        try {
            validate(-5);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

}