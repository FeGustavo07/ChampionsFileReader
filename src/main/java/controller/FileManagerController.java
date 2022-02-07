package controller;

import lombok.Getter;
import service.DataProcessorService;


@Getter
public class FileManagerController {


    private final DataProcessorService data = new DataProcessorService();


    public void readFile(String path) {
        this.data.read(path);
    }

    public void writeEachTeamsFile(String uri) {
        data.WriteEachTeamsFile(uri);
    }

    public void writeClassificationFile(String uri) {
        data.WriteClassificationFile(uri);
    }
}



