package cgg;

import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

public class Cone implements Shape {

	private Point pos;
	private double r;
	private double h;
	private Material material;

	public Cone(Point pos, double r, double h, Material material) {
		this.pos = pos;
		this.r = r;
		this.h = h;
		this.material = material;
	}

	@Override
	public Hit intersect(Ray ray) {

		Direction m = Vector.direction(pos.x, pos.y, pos.z);
		Point x0 = Vector.subtract(ray.origin, m);

		double a = Math.pow(ray.d.x, 2) + Math.pow(ray.d.z, 2) - Math.pow(r * ray.d.y / h, 2);
		double b = 2 * (x0.x * ray.d.x + x0.z * ray.d.z + r * r * ray.d.y / h * (1 + x0.y / h));
		double c = x0.x * x0.x + x0.z * x0.z + r * r * (-1 + x0.y / h * (2 - x0.y / h));

		double D = Math.pow(b, 2) - 4 * a * c;

		double t = Double.POSITIVE_INFINITY;
		int type = 0;
		
		if (D >= 0) {

			D = Math.sqrt(D);
			double t1 = (-b + D) / (2 * a);
			double t2 = (-b - D) / (2 * a);

			if (t1 >= ray.tmin) {
				t = t1;
			}
			if (t2 >= ray.tmin) {
				t = Math.min(t, t2);
			}
		}
		
		if(ray.d.y != 0) {
			double t3 = -x0.y / ray.d.y;
			if(t3 >= ray.tmin && t3 < t && Math.pow(x0.x + t3 * ray.d.x, 2) + Math.pow(x0.z + t3*ray.d.z, 2) <= r*r ) {
				t = t3;
				type = 1;
			}
		}
		
		if (t >= ray.tmax) {
			return null;
		}
		
		Hit hit = new Hit();
		hit.t = t;
		hit.x = ray.pointAt(hit.t);
		hit.material = this.material;
		
		if(type == 1) {
			hit.n = Vector.direction(0, -1, 0);
		}
		else {
			hit.n = Vector.direction(hit.x.x, hit.x.y - Math.sqrt(hit.x.x*hit.x.x + hit.x.z * hit.x.z) * r / h, hit.x.z);
			hit.n = Vector.normalize(hit.n);
		}

		return hit;
	}

	@Override
	public BoundingBox bounds() {
		return BoundingBox.everything;
	}

}
