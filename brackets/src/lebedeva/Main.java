package lebedeva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.next();

        StringValidator validator = new StringValidatorImpl(incoming);

        if (validator.isValid()) {
            System.out.println(validator.getErrorMessage());
        } else {
            System.out.println(validator.getErrorMessage());
            System.out.println("Ошибка на позиции: " + validator.getErrorPos());
        }
    }
}
