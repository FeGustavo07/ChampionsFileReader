package exception;

import lombok.*;

@Getter
@AllArgsConstructor
public class NotParsableLine extends Exception{
    private String message;

    public void getErrorMessage() {
        System.out.println("\n dropped row cannot be converted \n");
    }

}
