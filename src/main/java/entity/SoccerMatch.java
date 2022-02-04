package entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NonNull
@EqualsAndHashCode
public class SoccerMatch  {//implements Comparable<SoccerMatch>{

    private Team client;
    //private int clientScore;
    private Team opponent;
    //private int opponentScore;
    private LocalDate date;

    public static class SoccerMatchBuilder{
        public SoccerMatchBuilder client(String name, int goals){
            this.client = Team.builder().name(name).goals(goals).build();
            return this;
        }
        public SoccerMatchBuilder opponent(String name, int goals){
            this.opponent = Team.builder().name(name).goals(goals).build();
            return this;
        }
    }

//    @Override
//    public int compareTo(SoccerMatch soccerMatch) {
//        int dateCompare = date.compareTo(soccerMatch.getDate());
//        if (dateCompare != 0) {
//            return dateCompare;
//        }
//        int opponentCompare = opponent.compareTo(soccerMatch.getOpponent());
//        if (opponentCompare != 0){
//            return opponentCompare;
//        }
//        return client.compareTo(soccerMatch.getClient());
//    }


}
