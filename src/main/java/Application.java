import controller.FileManagerController;
import exception.NotParsableLine;

public class Application {


    public static void main(String[] args)  {
        try {
            new FileManagerController().run();
        } catch (NotParsableLine e) {
            e.printStackTrace();
        }
    }
}
