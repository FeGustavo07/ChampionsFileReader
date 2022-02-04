package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;

@Data
@EqualsAndHashCode
public class TeamBoard {
    private String name;
    private int victories;
    private int ties;
    private int defeats;
    private int pontuation = 0;
    private HashSet<SoccerMatch> matches = new HashSet<>();

    public TeamBoard(String name) {
        this.name = name;
    }

    public void add(SoccerMatch match) {
        this.setResults(match);
        this.matches.add(match);
    }

    public String GetformatedTextResult() {
        return String.format("%s;%d;%d;%d;%d;\n",
                this.name, this.victories, this.ties, this.defeats, this.pontuation
        );
    }

    private void setResults(SoccerMatch match) {
        if (match.getClient().getGoals() > match.getOpponent().getGoals()) {
            this.pontuation += 3;
            this.victories += 1;
        } else if (match.getClient().getGoals() == match.getOpponent().getGoals()) {
            this.pontuation += 1;
            this.ties += 1;
        } else {
            this.defeats += 1;
        }
    }

}