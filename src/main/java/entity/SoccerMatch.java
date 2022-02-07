package entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
@NonNull
@EqualsAndHashCode
public class SoccerMatch implements Comparable<SoccerMatch> {

    private String clientName;
    private Integer clientScore;
    private String opponentName;
    private Integer opponentScore;
    private LocalDate date;

    @Override
    public int compareTo(SoccerMatch soccerMatch) {
        int dateCompare = date.compareTo(soccerMatch.getDate());
        if (dateCompare != 0) {
            return dateCompare;
        }
        int opponentCompare = this.clientName.compareTo(soccerMatch.getClientName());
        if (opponentCompare != 0) {
            return opponentCompare;
        }
        return clientName.compareTo(soccerMatch.getClientName());
    }
}
