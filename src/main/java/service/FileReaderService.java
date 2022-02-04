package service;

import com.fileManager.FileReader;
import entity.SoccerMatch;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FileReaderService {

    private final FileReader fileReader = new FileReader();

    public List<SoccerMatch> read(String uri){
        val fileResult = fileReader.handleFile(uri);
        List<SoccerMatch> listResult = new ArrayList<>();
        for (String[] line : fileResult) {
            SoccerMatch match = SoccerMatch.builder()
                    .client(line[0])
                    .opponent(line[1])
                    .clientScore(Integer.parseInt(line[2]))
                    .opponentScore(Integer.parseInt(line[3]))
                    .date(LocalDate.parse(line[4], DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .build();
            listResult.add(match);
        }
        return listResult;
    }
}
