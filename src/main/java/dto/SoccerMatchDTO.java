package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoccerMatchDTO {
    private String clientName;
    private String opponentName;
    private String clientScore;
    private String opponentScore;
    private String date;
}
