package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

public class Ball implements Shape {
	
	public Point m;
	public double r;
	public Material material; 
	
	
	@Override
	public Hit intersect(Ray ray) {
		
		Direction m = Vector.direction(this.m.x, this.m.y, this.m.z);
		Point x0 = Vector.subtract(ray.origin, m);
		
		double a = Vector.dotProduct(ray.d,  ray.d);
		double b = 2 * Vector.dotProduct(ray.d, x0);
		double c = Vector.dotProduct(x0, x0) - Math.pow(r, 2);
		
		double D =  Math.pow(b, 2) - 4 * a * c;
		if(D < 0)
			return null;
		D= Math.sqrt(D);
		double t1 = (-b + D ) / (2 * a);
		double t2 = (-b - D ) / (2 * a);
		
		double t = Double.POSITIVE_INFINITY;
		if( t1 >= ray.tmin ) {
			t = t1;
		}
		if( t2 >= ray.tmin ) {
			t = Math.min(t, t2);
		}
		if(t >= ray.tmax ) {
			return null;
		}
		Hit hit = new Hit();
		hit.t = t;
		hit.x = ray.pointAt(hit.t);
		hit.n = Vector.normalize( Vector.subtract(hit.x, this.m) );
		hit.material = this.material;
		
		return hit;
	}
	
	
	private BoundingBox boundingBox;
	@Override
	public BoundingBox bounds() {
		if(boundingBox == null)
			boundingBox = new BoundingBox(Vector.point(m.x - r, m.y - r, m.z - r), Vector.point(m.x + r, m.y + r, m.z + r) );
		return boundingBox;
	}
}
