package service;

import com.fileManager.FileReader;
import entity.SoccerMatch;
import lombok.Getter;
import lombok.val;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class FileReaderService {

    private final FileReader fileReader = new FileReader();

    public HashSet<SoccerMatch> read(String uri) {
        val fileResult = fileReader.handleFile(uri);
        HashSet<SoccerMatch> listResult = new HashSet<>();

        //teste
//        for (String[] line : fileResult) {
//            try {
//                Integer.parseInt(line[2]);
//                Integer.parseInt(line[3]);
//                LocalDate.parse(line[4]);
//            } catch ()
//
//        }


        for (String[] line : fileResult) {
            SoccerMatch match = SoccerMatch.builder()
                    .client(line[0], Integer.parseInt(line[2]))
                    .opponent(line[1], Integer.parseInt(line[3]))
                    .date(LocalDate.parse(line[4], DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    .build();
            listResult.add(match);
        }
        return listResult;
    }
}
