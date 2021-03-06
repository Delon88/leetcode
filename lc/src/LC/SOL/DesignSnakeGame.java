package LC.SOL;

import javafx.geometry.Pos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {
    class SnakeGame {

        class Position {
            int x, y;
            public Position(int x, int y ) {
                this.x = x;
                this.y = y ;
            }
            @Override
            public int hashCode() {
                return x * 31 + y;
            }

            @Override
            public boolean equals(Object o) {
                if ( o == null || !(o instanceof Position)) return false;
                Position p = (Position) o;
                return this.x == p.x && this.y == p.y;
            }
        }

        LinkedList<Position> snake;
        int[][] food;
        Set<Position> set;
        int row;
        int col;
        int foodIndex;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.food =food;
            foodIndex = 0;
            row = height;
            col = width;
            set = new HashSet<>();
            snake = new LinkedList<>();
            Position p = new Position(0 , 0);
            set.add(p);
            snake.add(p);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            Position head = snake.getFirst();
            Position next = new Position(head.x, head.y);
            switch (direction) {
                case "U": next.x--;break;
                case "D": next.x++;break;
                case "L": next.y--;break;
                default:  next.y++;
            }
            set.remove(snake.getLast());
            if ( next.x < 0 || next.y < 0 || next.x >= row || next.y >= col || set.contains(next)) {
                return -1;
            }
            snake.addFirst(next);
            set.add(next);
            if ( foodIndex < food.length && food[foodIndex][0] == next.x && food[foodIndex][1] == next.y) {
                set.add(snake.getLast());
                foodIndex++;
            } else {
                snake.removeLast();
            }
            return foodIndex;
        }
    }
}
