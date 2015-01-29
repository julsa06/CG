import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Graham {
	private Point[] points;

	Comparator<Point> comp = new Comparator<Point>() {
		@Override
		public int compare(Point p0, Point p1) {
			if (points[0].rightRotate(p0, p1)) {
				return -1;
			}
			return 1;
		}
	};

	public Graham(Point[] points) {
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

		Arrays.sort(points, 1, points.length, comp);

		List<Point> hull = new ArrayList<Point>();
		hull.add(points[0]);
		hull.add(points[1]);

		for (int i = 2; i < points.length; i++) {
			Point p1 = hull.get(hull.size() - 1);
			Point p0 = hull.get(hull.size() - 2);
			while ((hull.size() > 2) && (p0.rightRotate(points[i], p1))) {
				p1 = p0;
				hull.remove(hull.size() - 1);
				p0 = hull.get(hull.size() - 2);
			}
			hull.add(points[i]);
		}

		return hull;

	}

}
