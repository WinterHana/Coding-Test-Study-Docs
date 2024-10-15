import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[firstLine[0]][];
        for (int i = 0; i < firstLine[0]; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = solution(map, firstLine[0], firstLine[1]);
        System.out.println(answer);

        br.close();
    }

    static int solution(int[][] map, int n, int m) {
        List<Cctv> cctvs = new ArrayList<>();
        Set<Coord> walls = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = map[i][j];
                if (val != 0 && val != 6) {
                    cctvs.add(new Cctv(new Coord(i, j), map[i][j], 0));
                }
                if (val == 6) {
                    walls.add(new Coord(i, j));
                }
            }
        }
        int max = recur(cctvs, map, walls, 0);
        return n * m - max;
    }

    static int recur(List<Cctv> cctvs, int[][] map, Set<Coord> walls, int k) {
        int max = getCoveredCount(cctvs, map, walls);
        for (int i = k; i < cctvs.size(); i++) {
            if (cctvs.get(i).direction == 3) {
                continue;
            }

            List<Cctv> newCctvs = new ArrayList<>();
            for (int j = 0; j < cctvs.size(); j++) {
                if (j == i) {
                    newCctvs.add(cctvs.get(j).turnRight());
                } else {
                    newCctvs.add(cctvs.get(j));
                }
            }
            max = Math.max(max, recur(newCctvs, map, walls, i));
        }
        return max;
    }

    static int getCoveredCount(List<Cctv> cctvs, int[][] map, Set<Coord> walls) {
        Set<Coord> coveredCoords = new HashSet<>();
        for (Coord wall : walls) {
            coveredCoords.add(wall);
        }
        for (Cctv cctv : cctvs) {
            switch (cctv.type) {
                case 1:
                    fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
                    break;
                case 2:
                    fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 2) % 4, cctv, map, coveredCoords);
                    break;
                case 3:
                    fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 1) % 4, cctv, map, coveredCoords);
                    break;
                case 4:
                    fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 1) % 4, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 2) % 4, cctv, map, coveredCoords);
                    break;
                case 5:
                    fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 1) % 4, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 2) % 4, cctv, map, coveredCoords);
                    fillCoverageOfSingleDirection((cctv.direction + 3) % 4, cctv, map, coveredCoords);
                    break;
                default:
                    throw new RuntimeException();
            }
            fillCoverageOfSingleDirection(cctv.direction, cctv, map, coveredCoords);
        }
        return coveredCoords.size();
    }

    static void fillCoverageOfSingleDirection(int direction, Cctv cctv, int[][] map, Set<Coord> coveredCoords) {
        int startRow = cctv.coord.row;
        int startCol = cctv.coord.col;
        int idx = 0;
        coveredCoords.add(cctv.coord);
        while (true) {
            idx++;
            int nextRow = startRow;
            int nextCol = startCol;
            switch (direction) {
                case 0:
                    nextRow = startRow - idx;
                    break;
                case 1:
                    nextCol = startCol + idx;
                    break;
                case 2:
                    nextRow = startRow + idx;
                    break;
                case 3:
                    nextCol = startCol - idx;
                    break;
                default:
                    throw new RuntimeException();
            }

            if (nextRow < 0 || nextRow >= map.length) {
                break;
            }
            if (nextCol < 0 || nextCol >= map[0].length) {
                break;
            }
            
            coveredCoords.add(new Coord(nextRow, nextCol));
            if (map[nextRow][nextCol] == 6) {
                break;
            }
        }
    }

    static class Cctv {
        final Coord coord;
        final int type;
        final int direction;

        Cctv(Coord coord, int type, int direction)  {
            this.coord = coord;
            this.type = type;
            this.direction = direction;
        }

        Cctv turnRight() {
            return new Cctv(this.coord, this.type, (this.direction + 1) % 4);
        }
    }

    static class Coord {
        final int row;
        final int col;

        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coord)) {
                return false;
            }
            Coord target = (Coord)obj;
            return this.row == target.row
                    && this.col == target.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.row, this.col);
        }
    }
}