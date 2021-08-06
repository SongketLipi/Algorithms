import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

// A helping class to create point objects
class Point {
    int x; // x coordinate
    int y; // y coordinate

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}

public class ConvexHull {
    // A slave method to get orientation
    public static int GetOrientation(Point p, Point q, Point r) {
        int value = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (value == 0)
            return 0; // collinear
        if (value > 0) 
            return 1; // clockwise since (+) value 
        else  
            return 2; // counterclockwise since (-) value
    }

    // Prints convex hull of a set of n points.
    public static void ComputeConvexHull(Point[] points) {
        int numberOfPoints = points.length;
        if (numberOfPoints < 3)
            return;

        Vector<Point> hulls = new Vector<Point>();

        int currentLeftMostPointindex = 0;
        for (int index = 1; index < numberOfPoints; index++)
            if (points[index].x < points[currentLeftMostPointindex].x)
                currentLeftMostPointindex = index;

        
        int p = currentLeftMostPointindex; 
        int q;
        do {
            hulls.add(points[p]);
            q = (p + 1) % numberOfPoints;
            for (int i = 0; i < numberOfPoints; i++) {
                // should we update q?
                if (GetOrientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }
            p = q;
        } while (p != currentLeftMostPointindex);

        // The coordinates of the points
        System.out.println("The coordinates of the points for the hull are: ");
        for (Point point : hulls)
            System.out.println(point.toString());
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Please enter how many points are there :");
        int numberOfPoints = in.nextInt();

        Point[] points = new Point[numberOfPoints];

        System.out.println("Please enter the points: ");
        for(int i = 1; i <= numberOfPoints; i++){
            int x;
            int y;
            System.out.println("Please enter the value of x for point "+ i + ": ");
            x = in.nextInt();
            System.out.println("Please enter the value of y for point "+ i + ": ");
            y = in.nextInt();
            points[i-1] = new Point(x, y);
        }
        ComputeConvexHull(points);
    }

}
