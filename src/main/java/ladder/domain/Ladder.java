package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder() {
        this(new ArrayList<>());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void add(Line line) {
        lines.add(line);
    }

    public int arrivalPoint(int startLine, int startPoint) {
        int currentPoint = startPoint;
        for (int i = startLine; i < lines.size(); i++) {
            currentPoint = lines.get(i).move(currentPoint);
        }
        return currentPoint;
    }

    public List<Line> getLines() {
        return lines;
    }
}