package lebedeva;

/**
 * @author Lebedeva Maria
 */
interface StringValidator {

    // Проверяет строку на корректность
    boolean isValid();

    // Если последний вызов isValid обнаружил ошибку, возвращает
    // позицию, в которой обнаружена ошибка
    int getErrorPos();

    // Если последний вызов isValid обнаружил ошибку, возвращает
    // сообщение об ошибке
    String getErrorMessage();
}
