package service;

import com.fileManager.FileWriter;
import entity.SoccerMatch;
import entity.TeamBoard;
import repository.TeamBoardRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FileWriterService {

    private final FileWriter writer = new FileWriter();

    public void writeTeamsFile(TeamBoard board){

        ArrayList<String> toWrite = new ArrayList<>();

        String path = "src/main/resources/resultsByTeams/" + board.getName() + ".txt";

        for (SoccerMatch match : board.getMatches()) {
            String message = String.format("%s;%s;%d;%d;%s",
                    match.getClient().getName(),
                    match.getOpponent().getName(),
                    match.getClient().getGoals(),
                    match.getOpponent().getGoals(),
                    match.getDate().toString()
            );
            toWrite.add(message);
        }
        writer.writeSeparateTeams(toWrite, path);
    }
  
    public void writeBoard(TeamBoard board) {
        String path = "src/main/resources/championshipStandings/table.txt";
        writer.writeChampionshipStandings(board.GetformatedTextResult(), path);
    }

}

