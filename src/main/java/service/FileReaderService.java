package service;

import com.fileManager.FileReader;
import lombok.val;

public class FileReaderService {

    private final FileReader fileReader = new FileReader();

    public void read(String uri){
         val fileResult = fileReader.handleFile(uri);

    }
}
