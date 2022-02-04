package entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NonNull
public class SoccerMatch  implements Comparable<SoccerMatch>{

    private String client;
    private int clientScore;
    private String opponent;
    private int opponentScore;
    private LocalDate date;

    @Override
    public int compareTo(SoccerMatch soccerMatch) {
        int dateCompare = date.compareTo(soccerMatch.getDate());
        if (dateCompare != 0) {
            return dateCompare;
        }
        int opponentCompare = opponent.compareTo(soccerMatch.getOpponent());
        if (opponentCompare != 0){
            return opponentCompare;
        }
        return client.compareTo(soccerMatch.getClient());
    }


}
