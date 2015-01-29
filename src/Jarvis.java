import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jarvis {
	private Point[] points;

	public Jarvis(Point[] points) {
		this.points = Arrays.copyOf(points, points.length);
	}

	private void leftmostPoint() {
		for (int i = 1; i < points.length; i++) {
			if (points[0].getX() > points[i].getX()) {
				Point tmp = points[0];
				points[0] = points[i];
				points[i] = tmp;
			}
		}
	}

	public List<Point> ConvexHull() {
		leftmostPoint();

		List<Point> hull = new ArrayList<Point>();
		hull.add(points[0]);
		for (int i = 1; i < points.length; i++) {
			int rm = i; // rightmost point

			for (int j = i + 1; j < points.length; j++) {
				if (points[i - 1].rightRotate(points[j], points[rm])) {
					rm = j;
				}
			}

			if (points[i - 1].rightRotate(points[0], points[rm])) {
				break;
			}

			Point tmp = points[i];
			points[i] = points[rm];
			points[rm] = tmp;
			hull.add(points[i]);
		}

		return hull;

	}

}
