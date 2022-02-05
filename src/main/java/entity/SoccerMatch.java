package entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NonNull
@EqualsAndHashCode
public class SoccerMatch  implements Comparable<SoccerMatch>{

    private Team client;
    private Team opponent;
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

    @Override
    public int compareTo(SoccerMatch soccerMatch) {
        int dateCompare = date.compareTo(soccerMatch.getDate());
        if (dateCompare != 0) {
            return dateCompare;
        }
        int opponentCompare = opponent.getName().compareTo(soccerMatch.getOpponent().getName());
        if (opponentCompare != 0){
            return opponentCompare;
        }
        return client.getName().compareTo(soccerMatch.getClient().getName());
    }


}
