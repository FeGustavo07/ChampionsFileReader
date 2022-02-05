package controller;

import entity.SoccerMatch;
import entity.TeamBoard;
import lombok.val;
import repository.SoccerMatchRepository;
import repository.TeamBoardRepository;
import service.FileReaderService;
import service.FileWriterService;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;


public class FileManagerController {

    private final FileReaderService fileReaderService = new FileReaderService();
    private final FileWriterService fileWriterService = new FileWriterService();
    private final SoccerMatchRepository matchRepository = new SoccerMatchRepository();
    private final TeamBoardRepository teamBoardRepository = new TeamBoardRepository();

    public static void main(String[] args) {
        new FileManagerController().start();
    }
    public void start() {
        this.read("src/main/resources/brasileirao2020.csv");


    }

    public void read(String path){
        HashSet<SoccerMatch> matches = fileReaderService.read(path);
        this.matchRepository.addAll(matches);
    }
     public void fillsTeamTable() {
         val ordered = orderByDateAndName(matchRepository.getAllRegisters());
         val tableByClient = groupByClient(ordered);
         for (String key : tableByClient.keySet()) {
             TeamBoard board = new TeamBoard(key);
             for (SoccerMatch soccerMatch : tableByClient.get(key)){
                 board.add(soccerMatch);
             }
             this.teamBoardRepository.add(board);
         }
     }

     public void WriteResultsFile(){

     }

    private TreeMap<String, List<SoccerMatch>> groupByClient(TreeSet<SoccerMatch> ordered) {
        return new TreeMap<>(
                ordered.stream().collect(groupingBy(match -> match.getClient().getName())));
    }


    private TreeSet<SoccerMatch> orderByDateAndName(HashSet<? extends SoccerMatch> toOrder){
        return new TreeSet<>(toOrder);
    }

    private TreeSet<TeamBoard> orderByHighestPontuation(TreeSet<TeamBoard> toOrder){
        TreeSet<TeamBoard> list = new TreeSet<>(Collections.reverseOrder());
        list.addAll(toOrder);
        return list;
    }

}
