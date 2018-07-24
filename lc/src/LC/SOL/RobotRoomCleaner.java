package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        int curDir = 0;
        dfs(robot, 0, 0, 0, set);
    }

    void dfs(Robot robot, int curDir, int i, int j, Set<String> set) {
        String pos = i + "," + j;
        if (set.contains(pos)) {
            return;
        }
        set.add(pos);
        robot.clean();
        for (int k = 0; k < 4; k++) {
            if (robot.move()) {
                int x = i, y = j;
                if (curDir == 0) {
                    x = i - 1;
                } else if (curDir == 90) {
                    y = j + 1;
                } else if (curDir == 180) {
                    x = i + 1;
                } else if (curDir == 270) {
                    y = j - 1;
                }
                dfs(robot, curDir, x, y, set);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            curDir += 90;
            curDir %= 360;
        }
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}