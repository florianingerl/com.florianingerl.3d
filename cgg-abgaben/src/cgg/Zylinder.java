package cgg;

import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

public class Zylinder implements Shape {

	private double radius;
	private double height;
	private Point pos;
	private Material material;

	public Zylinder(Point pos, double radius, double height, Material material) {
		this.pos = pos;
		this.radius = radius;
		this.height = height;
		this.material = material;
	}

	@Override
	public Hit intersect(Ray ray) {

		Direction m = Vector.direction(pos.x, pos.y, pos.z);
		Point x0 = Vector.subtract(ray.origin, m);

		double a = Math.pow(ray.d.x, 2) + Math.pow(ray.d.z, 2);
		double b = 2 * (x0.x * ray.d.x + x0.z * ray.d.z);
		double c = Math.pow(x0.x, 2) + Math.pow(x0.z, 2) - Math.pow(radius, 2);

		double t = Double.POSITIVE_INFINITY;
		int intersect = 0;
		
		double D = Math.pow(b, 2) - 4 * a * c;
		if (D >= 0) {
			D = Math.sqrt(D);
			double t1 = (-b + D) / (2 * a);
			double t2 = (-b - D) / (2 * a);

			Point p = ray.pointAt(t1);
			
			if (t1 >= ray.tmin && pos.y <= p.y && p.y <= pos.y + height) {
				t = t1;
				intersect = 1;
			}
			p = ray.pointAt(t2);
			if (t2 >= ray.tmin && t2 < t && pos.y <= p.y && p.y <= pos.y + height) {
				t = t2;
				intersect = 2;
			}
		}

		if (ray.d.y != 0) {
			double t3 = -x0.y / ray.d.y;
			if (t3 >= ray.tmin && t3 < t
					&& Math.pow(x0.x + t3 * ray.d.x, 2) + Math.pow(x0.z + t3 * ray.d.z, 2) <= Math.pow(radius, 2)) {
				t = t3;
				intersect = 3;
			}

			double t4 = (height - x0.y) / ray.d.y;
			if (t4 >= ray.tmin && t4 < t 
					&& Math.pow(x0.x + t4 * ray.d.x, 2) + Math.pow(x0.z + t4 * ray.d.z, 2) <= Math.pow(radius, 2)) {
				t = t4;
				intersect = 4;
			}
		}

		if (t >= ray.tmax) {
			return null;
		}
		Hit hit = new Hit();
		hit.t = t;
		hit.x = ray.pointAt(hit.t);
		if (intersect == 3) {
			hit.n = Vector.direction(0, 0, -1);
		} else if ( intersect == 4 ) {
			hit.n = Vector.direction(0, 0, 1);
		} else {
			hit.n = Vector.normalize(Vector.subtract(hit.x, Vector.point(pos.x, hit.x.y, pos.z)));
		}
		hit.material = this.material;

		return hit;

	}
	
	@Override
	public BoundingBox bounds() {
		return new BoundingBox( Vector.point(pos.x - radius, pos.y, pos.z - radius), Vector.point(pos.x + radius, pos.y + height, pos.z + radius) );
	}

}
