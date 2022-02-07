package exception;

import lombok.Getter;

@Getter
public class NotParsableLine extends Exception {
    private final String message;


    public NotParsableLine(String message) {
        super(message);
        this.message = message;
    }

    public void getErrorMessage() {
        System.err.println("dropped row cannot be converted");
    }

}
