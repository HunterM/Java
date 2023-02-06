package HW4;

import java.util.Comparator;
import java.util.Random;

public class Point {

    int X;
    int Y;
    int id;

    public Point(int X, int Y, int id) {
        this.X = X;
        this.Y = Y;
        this.id = id;
    }

    public Point(Point a) {
        this.X = a.getX();
        this.Y = a.getY();
        this.id = a.getID();
    }

    public Point(int id) {
        Random random = new Random();
        this.X = random.nextInt();
        this.Y = random.nextInt();
        this.id = id;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public static final Comparator<Point> COMPARE_BY_X = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            return a.getX() - b.getX();
        }
    };

    public static final Comparator<Point> COMPARE_BY_Y = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            return a.getY() - b.getY();
        }
    };

    @Override
    public String toString() {
        return "Point{" + "X=" + X + ", Y=" + Y + ", id=" + id + '}';
    }

}
