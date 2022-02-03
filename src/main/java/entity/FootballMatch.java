package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NonNull
public class FootballMatch {

    private Team client;
    private int clientScore;
    private Team opponent;
    private int opponentScore;
    private LocalDate date;


}
