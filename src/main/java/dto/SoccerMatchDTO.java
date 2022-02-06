package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoccerMatchDTO {
    public String clientName = "";
    public String opponentName = "";
    public String clientScore = "";
    public String opponentScore = "";
    public String date = "";
}
