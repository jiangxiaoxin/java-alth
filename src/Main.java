import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//
//        CustomException customException = new CustomException("111");
//        System.out.println(customException.getClass().getName());

        System.out.println("main");



    }




}

class CustomException extends Throwable {
    private String _msg;
    public CustomException(String msg) {
        super(msg);
        this._msg = msg;
    }
}

class Score<T> {
    public T data;
    public Score(T data) {
        this.data = data;
    }
}