package nextstep.ladder.domain.line;

import nextstep.ladder.util.StreamUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineFactory {

    private static final Random RANDOM = new Random();

    private LineFactory() {
    }

    public static Line createLine(int numberOfPoints) {
        List<Point> points = Stream.generate(Point::new)
                                   .limit(numberOfPoints)
                                   .collect(Collectors.toList());

        StreamUtils.pairStream(points)
                   .forEach(pair -> tryToConnect(pair.getFirst(), pair.getSecond()));

        return new Line(points);
    }

    private static void tryToConnect(Point leftPoint, Point rightPoint) {
        if (!leftPoint.isConnectedAnotherPoint() && RANDOM.nextBoolean()) {
            leftPoint.connectTo(rightPoint);
            rightPoint.connectTo(leftPoint);
        }
    }

}