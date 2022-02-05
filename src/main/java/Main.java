//import entity.SoccerMatch;
//import entity.TeamBoard;
//import lombok.val;
//import repository.SoccerMatchRepository;
//import repository.TeamBoardRepository;
//import service.FileReaderService;
//import service.FileWriterService;
//import utils.filters.OrderByPontuation;
//
//import java.util.*;
//
//import static java.util.stream.Collectors.groupingBy;
//
//public class Main {
//
//
//    public static void main(String[] args) {
////        FileReaderService fileReaderService = new FileReaderService();
////        FileWriterService fileWriterService = new FileWriterService();
////        SoccerMatchRepository matchRepository = new SoccerMatchRepository();
////        TeamBoardRepository teamBoardRepository = new TeamBoardRepository();
//
//
////        List<SoccerMatch> matches = fileReaderService.read("src/main/resources/brasileirao2020.csv");
// //       matchRepository.addAll(matches);
//
//
//        // Ordenação da lista
////        matchRepository.getAllRegisters().sort(
////                Comparator.comparing(SoccerMatch::getDate)
////                        .thenComparing((SoccerMatch soccerMatch) -> soccerMatch.getOpponent().getName())
////        );
//
//        // Separação por times
//
//        ArrayList<SoccerMatch> table = new ArrayList<>(matchRepository.getAllRegisters());
//        TreeMap<String, List<SoccerMatch>> tableByClient = new TreeMap<>(
//                table.stream().collect(groupingBy(match -> match.getClient().getName())));
//
//        //adiciona os times do map para o o team board repository
//        for(String teamName : tableByClient.keySet()){
//            val board = new TeamBoard(teamName);
//            tableByClient.get(teamName).forEach(board::add);
//            teamBoardRepository.add(board);
//        }
//
//
//
//        //tableByClient.forEach((key, value) -> System.out.println(key + " " + value));
//
//        System.out.println(tableByClient);
////        tPorClient.forEach((team, history) -> {
////            System.out.println();
////            System.out.println("Team: " + team);
////            System.out.println();
////            for (SoccerMatch match : history) {
////                System.out.println(match);
////            }
////        });
//
//        // Criando lista do time
//        List<SoccerMatch> corinthians = tableByClient.get("Corinthians");
//
//        System.out.println(corinthians);
//
////        System.out.println(repository.getAllRegisters());
////        System.out.println(LocalDate.parse("1995-10-12"));
//
//
//        for(TeamBoard board : teamBoardRepository.getAllBoards()) {
//            fileWriterService.writeBoard(board);
//            System.out.println(board.getformatedTextResult());
//        }
//
//        System.out.println("---------------------------------");
//
//        //ordena pela pontuação
//        OrderByPontuation orderFilter = new OrderByPontuation();
//        val highestPontuation = orderFilter.orderByHighestPontuation(teamBoardRepository.getAllBoards());
//
//        for (TeamBoard teamBoard : highestPontuation) {
//            System.out.println(teamBoard.getformatedTextResult());
//        }
//
//
//        //System.out.println(teamBoardRepository.getOrderedByPontuation());
//
//
//
//    }
//}
