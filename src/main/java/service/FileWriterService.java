package service;

import com.fileManager.FileWriter;
import entity.SoccerMatch;
import entity.TeamBoard;

import java.util.ArrayList;

public class FileWriterService {

    private final FileWriter writer = new FileWriter();

    public void writeTeamsFile(TeamBoard board, String baseUri) {
        String fileType = ".txt";
        ArrayList<String> toWrite = new ArrayList<>();
        String fileName = String.format("%s%s%s", baseUri, board.getName(), fileType);
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
        writer.writeSeparateTeams(toWrite, fileName, baseUri);
    }

    public void writeBoard(TeamBoard board, String path) {
        String uri = path + "classification.txt";
        writer.writeChampionshipStandings(board.getformatedTextResult(), uri, path);
    }

}

