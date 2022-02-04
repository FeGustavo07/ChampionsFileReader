package entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NonNull
@Getter
public class SoccerMatch  implements Comparable<SoccerMatch>{

    private LocalDate date;
    private String client;
    private int clientScore;
    private int opponentScore;
    private String opponent;

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
