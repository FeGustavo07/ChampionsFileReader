package exception;

import lombok.*;

@Getter
@AllArgsConstructor
public class NotParsableLine extends Exception{
    private String message;

    public void getErrorMessage() {
        System.out.println("dropped row cannot be converted");
        System.out.println();
    }

}