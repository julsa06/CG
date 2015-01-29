import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("hull.in"));
		int n = in.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			points[i] = new Point(x, y);
		}

		PrintWriter out = new PrintWriter(new File("hull.out"));
		List<Point> hullGr = new Graham(points).ConvexHull();
		out.println("Graham scan:");
		for (Point p : hullGr) {
			out.println(p);
		}

		out.println();

		out.println("Jarvis March:");
		List<Point> hullJv = new Jarvis(points).ConvexHull();
		for (Point p : hullJv) {
			out.println(p);
		}

		out.close();
	}
}
