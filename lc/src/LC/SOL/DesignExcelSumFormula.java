package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class DesignExcelSumFormula {
    class Excel {

        Cell[][] table;

        public Excel(int H, char W) {
            table = new Cell[H + 1][W - 'A' + 1];
        }

        public void set(int r, char c, int v) {
            if (table[r][c - 'A'] == null) table[r][c - 'A'] = new Cell(v);
            table[r][c - 'A'].setValue(v);
        }

        public int get(int r, char c) {
            if (table[r][c - 'A'] == null) return 0;
            else return table[r][c - 'A'].getValue();
        }

        public int sum(int r, char c, String[] strs) {
            if (table[r][c - 'A'] == null) {
                table[r][c - 'A'] = new Cell(strs);
            } else {
                table[r][c - 'A'].setFormula(strs);
            }
            return table[r][c - 'A'].getValue();
        }

        class Cell {
            int val = 0;
            Map<Cell, Integer> formula = new HashMap<>();

            public Cell(int val) {
                formula.clear();
                this.val = val;
            }

            public Cell(String[] arr) {
                setFormula(arr);
            }

            public void setValue(int v) {
                formula.clear();
                val = v;
            }

            public void setFormula(String[] arr) {
                formula.clear();
                for (String a : arr) {
                    if (a.indexOf(":") < 0) {
                        int[] pos = getPos(a);
                        addCell(pos[0], pos[1]);
                    } else {
                        String[] pos = a.split(":");
                        int[] start = getPos(pos[0]);
                        int[] end = getPos(pos[1]);
                        for (int i = start[0]; i <= end[0]; i++) {
                            for (int j = start[1]; j <= end[1]; j++) {
                                addCell(i, j);
                            }
                        }
                    }
                }
            }

            public void addCell(int r, int c) {
                if (table[r][c] == null) table[r][c] = new Cell(0);
                formula.put(table[r][c], formula.getOrDefault(table[r][c], 0) + 1);
            }

            int[] getPos(String c) {
                int[] pos = new int[2];
                pos[1] = c.charAt(0) - 'A';
                pos[0] = Integer.parseInt(c.substring(1));
                return pos;
            }

            int getValue() {
                if (formula.isEmpty()) return this.val;
                int sum = 0;
                for (Cell cell : formula.keySet()) {
                    sum += cell.getValue() * formula.get(cell);
                }
                return sum;
            }
        }
    }
}
