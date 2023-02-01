package HW3;

// package hw3;

import static HW3.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class hw3 {
    public static ArrayList<Point> findPath(int[][] map) {
        ArrayList<Point> path = new ArrayList<Point>();
        findPath(map.length - 1, map[0].length - 1, map, path);
        return path;
    }

    private static boolean findPath(int x, int y, int[][] map, ArrayList<Point> path) {
        if (x < 0 || y < 0) return false;
        if (map[x][y] == 0) return false;
        Point p = new Point(x, y);
        if (x == 0 && y == 0) {
            path.add(p);
            return true;
        }
        boolean success = findPath(x - 1, y, map, path);
        if (!success) success = findPath(x, y - 1, map, path);
        if (success) path.add(p);
        return success;
    }

    public static ArrayList<Point> findPathDP(int[][] map) {
        ArrayList<Point> path = new ArrayList<Point>();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
        findPathDP(map.length - 1, map[0].length - 1, map, path, cache);
        return path;
    }

    private static boolean findPathDP(int x, int y, int[][] map, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        if (x < 0 || y < 0) return false;
        if (map[x][y] == 0) return false;
        Point p = new Point(x, y);
        if (cache.containsKey(p)) return cache.get(p);
        if (x == 0 && y == 0) {
            path.add(p);
            return true;
        }
        boolean success = findPathDP(x - 1, y, map, path, cache);
        if (!success) success = findPathDP(x, y - 1, map, path, cache);
        if (success) path.add(p);
        cache.put(p, success);
        return success;
    }

   
    public static ArrayList<ArrayList<Point>> findAllPaths(int[][] map) {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        findAllPaths(map.length - 1, map[0].length - 1, map, new ArrayList<Point>(), result);
        return result;
    }

    // передача в массив
    @SuppressWarnings("unchecked")
    private static void findAllPaths(int x, int y, int[][] map,
            ArrayList<Point> path, ArrayList<ArrayList<Point>> result) {
        if (x < 0 || y < 0) return;
        if (map[x][y] == 0) return;
        Point p = new Point(x, y);
        path.add(0, p);
        if (x == 0 && y == 0) {
            result.add((ArrayList<Point>) path.clone());
        }
        findAllPaths(x - 1, y, map, path, result);
        findAllPaths(x, y - 1, map, path, result);
        path.remove(p);
    }

    public static ArrayList<ArrayList<Point>> findAllPaths2(int[][] map) {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        Point[] path = new Point[2 * map.length - 1];
        findAllPaths2(map.length - 1, map[0].length - 1, map, path, path.length - 1, result);
        return result;
    }

    // передача массива в буфер
    private static void findAllPaths2(int x, int y, int[][] map,
            Point[] path, int index, ArrayList<ArrayList<Point>> result) {
        if (x < 0 || y < 0) return;
        if (map[x][y] == 0) return;
        Point p = new Point(x, y);
        path[index] = p;
        if (x == 0 && y == 0) {
            result.add(new ArrayList<Point>(Arrays.asList(path)));
        }
        findAllPaths2(x - 1, y, map, path, index - 1, result);
        findAllPaths2(x, y - 1, map, path, index - 1, result);
    }

    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point that = (Point) o;
            return x == that.x && y == that.y;
        }
        public int hashCode() {
            return Integer.valueOf(x).hashCode() *
                   Integer.valueOf(y).hashCode();
        }
    }

    //тест
    public static void main(String[] args) {
        int[][] map = {{1,1,1,1},
                       {1,0,1,1},
                       {1,1,0,1},
                       {1,1,1,1}};
        println((findPath(map)));
        println(findPathDP(map));
        println(findAllPaths(map));
        println(findAllPaths2(map));
    }
}