package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntersectionOfCircles_22 {

    static class Point {
        private int coordX;
        private int coordY;

        public Point(int x, int y) {
            this.coordX = x;
            this.coordY = y;
        }

        public int getCoordX() {
            return coordX;
        }

        public int getCoordY() {
            return coordY;
        }
    }

    static class Circle extends Point {
        private int radius;

        public Circle(int x, int y, int radius) {
            super(x, y);
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstValues = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondValues = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Circle circle1 = new Circle(firstValues[0], firstValues[1], firstValues[2]);
        Circle circle2 = new Circle(secondValues[0], secondValues[1], secondValues[2]);

        if (intersect(circle1, circle2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    static boolean intersect(Circle circle1, Circle circle2) {
        int xRes = circle1.getCoordX() - circle2.getCoordX();
        int yRes = circle1.getCoordY() - circle2.getCoordY();
        double desc = Math.sqrt(xRes * xRes + yRes * yRes);

        if (desc <= circle1.getRadius() + circle2.getRadius()) {
            return true;
        } else {
            return false;
        }
    }
}
