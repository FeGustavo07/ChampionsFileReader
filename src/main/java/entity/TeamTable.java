package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class TeamTable implements Comparable<TeamTable> {
    private String name;
    private int victories;
    private int ties;
    private int defeats;
    private int pontuation = 0;
    private LinkedHashSet<SoccerMatch> matches = new LinkedHashSet<>();

    public TeamTable(String name) {
        this.name = name;
    }

    public void add(SoccerMatch match) {
        this.matches.add(match);
    }

    public String getformatedTextResult() {
        return String.format("%s;%d;%d;%d;%d;",
                this.name, this.victories, this.ties, this.defeats, this.pontuation
        );
    }

    @Override
    public int compareTo(@NotNull TeamTable teamTable) {
        int pontuationCompare = this.pontuation - teamTable.getPontuation();
        if (pontuationCompare != 0) {
            return pontuationCompare;
        }
        int victoriesCompare = this.victories - teamTable.getVictories();
        if (victoriesCompare != 0) {
            return victoriesCompare;
        }
        return this.name.compareTo(teamTable.name);
    }
}