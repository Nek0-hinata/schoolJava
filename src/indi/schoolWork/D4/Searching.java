package indi.schoolWork.D4;

import indi.structures.queue.LinkedQueue;

import java.util.Scanner;

public class Searching {
    public static int move[][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    public static void main(String[] args) {
        LinkedQueue<Point> queue = new LinkedQueue<>();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int finX = scanner.nextInt();
        int finY = scanner.nextInt();
        int times = 0;
        int[][] num = new int[m + 1][];
        int[][] vis = new int[m + 1][];
        for (int i = 0; i < m; i++) {
            num[i] = new int[n + 1];
            vis[i] = new int[n + 1];
            for (int j = 0; j < n; j++) {
                num[i][j] = scanner.nextInt();
                vis[i][j] = 0;
            }
        }
        queue.push(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point tmp = queue.pop();
            vis[tmp.getX()][tmp.getY()] = 1;
            for (int j = 0; j < 4; j++) {
                int nx = tmp.getX() + move[j][0];
                int ny = tmp.getY() + move[j][1];
                int dis = tmp.getDistance();
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && vis[nx][ny] != 1) {
                    if (nx == finX - 1 && ny == finY - 1) {
                        times++;
                        System.out.println("找到出路！距离为" + (dis + 1));
                    }
                    queue.push(new Point(nx, ny, dis + 1));
                    vis[nx][ny] = 1;
                }
            }
        }
        System.out.println("路径数量为" + times);
    }
}

class Point {
    private int x;
    private int y;
    private int distance;

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}