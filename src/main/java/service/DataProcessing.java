package service;

import entity.SoccerMatch;
import entity.TeamBoard;
import lombok.Getter;
import lombok.val;
import repository.SoccerMatchRepository;
import repository.TeamBoardRepository;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@Getter
public class DataProcessing {


    private final String URI_SOURCE_FILE = "src/main/resources/santander811matchesResult.csv";
    private final String URI_PATH_SAVE_TEAMS_FILE = "src/main/resources/resultsByTeams/";
    private final String URI_PATH_SAVE_CLASSIFICATION_FILE = "src/main/resources/championshipStandings/";

    private final FileReaderService fileReaderService = new FileReaderService();
    private final FileWriterService fileWriterService = new FileWriterService();
    private final SoccerMatchRepository matchRepository = new SoccerMatchRepository();
    private final TeamBoardRepository teamBoardRepository = new TeamBoardRepository();


    public void read(String path) {
        HashSet<SoccerMatch> matches = fileReaderService.read(path);
        this.matchRepository.addAll(matches);
    }

    public void fillsTeamTable() {
        val ordered = orderByDateAndName(matchRepository.getAllRegisters());
        val tableByClient = groupByClient(ordered);
        for (String key : tableByClient.keySet()) {
            TeamBoard board = new TeamBoard(key);
            for (SoccerMatch soccerMatch : tableByClient.get(key)) {
                board.add(soccerMatch);
            }
            this.teamBoardRepository.add(board);
        }
    }

    public void WriteEachTeamsFile() {
      teamBoardRepository.getAllBoards().forEach(
               value -> fileWriterService.writeTeamsFile(value, URI_PATH_SAVE_TEAMS_FILE)
        );
    }

    public void WriteClassificationFile() {
        val classification = orderByHighestPontuation(teamBoardRepository.getAllBoards());
        classification.forEach(
                board -> fileWriterService.writeBoard(board, URI_PATH_SAVE_CLASSIFICATION_FILE));
    }

    private TreeMap<String, List<SoccerMatch>> groupByClient(TreeSet<SoccerMatch> ordered) {
        return new TreeMap<>(
                ordered.stream().collect(groupingBy(match -> match.getClient().getName())));
    }


    private TreeSet<SoccerMatch> orderByDateAndName(HashSet<? extends SoccerMatch> toOrder) {
        return new TreeSet<>(toOrder);
    }

    private TreeSet<TeamBoard> orderByHighestPontuation(HashSet<TeamBoard> toOrder) {
        TreeSet<TeamBoard> list = new TreeSet<>(Collections.reverseOrder());
        list.addAll(toOrder);
        return list;
    }

}
