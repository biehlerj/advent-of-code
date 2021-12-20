package day17;

public class Day17 {
    private final int xMin;
    private final int xMax;
    private final int yMin;
    private final int yMax;

    public Day17() {
        String input = "target area: x=153..199, y=-114..-75";
        String[] xs = input.substring(input.indexOf("x=") + 2, input.indexOf(",")).split("\\..");
        String[] ys = input.substring(input.indexOf("y=") + 2).split("\\..");
        xMin = Integer.parseInt(xs[0]);
        xMax = Integer.parseInt(xs[1]);
        yMin = Integer.parseInt(ys[0]);
        yMax = Integer.parseInt(ys[1]);
    }

    public int highestY () {
        return (Math.abs(yMin) - 1) * (Math.abs(yMin)) / 2;
    }

    public int numVelocitiesWithinTarget() {
        int minXVelocity, maxXVelocity, minYVelocity, maxYVelocity;
        int count = 0;
        maxXVelocity = xMax;
        minYVelocity = yMin;
        minXVelocity = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * xMin)) / 2);
        maxYVelocity = Math.abs(yMin) - 1;

        for (int x = minXVelocity; x <= maxXVelocity; x++) {
            for (int y = minYVelocity; y <= maxYVelocity; y++) {
                if (runSimulation(x, y))
                    count++;
            }
        }
        return count;
    }

    private boolean runSimulation(int xV, int yV) {
        int xP = 0, yP = 0;

        while (xP <= xMax && yP >= yMin) {
            xP += xV;
            yP += yV;

            if (xV > 0)
                xV--;
            yV--;

            if (xP >= xMin && xP <= xMax && yP >= yMin && yP <= yMax)
                return true;
        }
        return false;
    }
}
