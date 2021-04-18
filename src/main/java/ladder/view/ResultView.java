package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ResultView {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String ROOT = "|";

    private final LadderResult ladderResult;
    private final Players players;

    public ResultView(Players players, LadderResult ladderResult) {
        this.players = players;
        this.ladderResult = ladderResult;
    }

    public void showLadderDrawResult() {
        printHeader();
        printPlayers();
        printNewLine();
        printLadder();
    }

    private void printHeader() {
        printNewLine();
        System.out.println("사다리 결과");
        printNewLine();
    }

    private void printLadder() {
        ladderResult.getLines()
                .forEach(line -> printLine(line.getPoints()));
    }

    private void printLine(List<Point> points) {
        StringBuffer sb = new StringBuffer();
        sb.append(indent());
        points.forEach(point -> {
            sb.append(ROOT);
            sb.append(makeRightLine(point));
        });
        System.out.println(sb);
    }

    private String makeRightLine(Point point) {
        if (point.hasRightDirection()) {
            return times(DASH);
        }
        return times(SPACE);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printPlayers() {
        Optional.of(players)
                .map(Players::allPlayers)
                .orElseThrow(IllegalArgumentException::new)
                .forEach(player -> System.out.print(padLeft(player.getName(), Player.MAX_SIZE + 1)));
    }

    public void printPrize(Prize prize) {
        prize.getHitResults()
                .forEach(hit -> System.out.print(padLeft(hit, Player.MAX_SIZE + 1)));
    }

    private String padLeft(String inputString, int padCount) {
        return String.format("%1$" + padCount + "s", inputString);
    }

    private static String indent() {
        return Stream.generate(() -> SPACE)
                .limit(Player.MAX_SIZE)
                .reduce("", (a, b) -> a + b);
    }

    private String times(String target) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < Player.MAX_SIZE; i++) {
            sb.append(target);
        }
        return sb.toString();
    }
}