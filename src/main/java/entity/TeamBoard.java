package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import java.util.LinkedHashSet;

@Data
@EqualsAndHashCode
public class TeamBoard implements Comparable<TeamBoard> {
    private String name;
    private int victories;
    private int ties;
    private int defeats;
    private int pontuation = 0;
    private LinkedHashSet<SoccerMatch> matches = new LinkedHashSet<>();

    public TeamBoard(String name) {
        this.name = name;
    }

    public void add(SoccerMatch match) {
        this.setResults(match);
        this.matches.add(match);
    }

    public String getformatedTextResult() {
        return String.format("%s;%d;%d;%d;%d;",
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

    @Override
    public int compareTo(@NotNull TeamBoard o) {
        return this.pontuation - o.getPontuation();
    }

}