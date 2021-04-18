package ladder.domain;

import ladder.util.RandomUtil;

public class BodyPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public BodyPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Point point() {
        if (previousPoint.hasRightDirection()) {
            return new Point(previousPoint.nextIndex(), new Direction(true, false));
        }
        return new Point(previousPoint.nextIndex(), new Direction(false, RandomUtil.trueOrFalse()));
    }
}