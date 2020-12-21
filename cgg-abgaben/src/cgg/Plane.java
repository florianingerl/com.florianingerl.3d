package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

public class Plane implements Shape {

	private Point p;
	private Direction n;
	private Material material;
	private double d = Double.MAX_VALUE;
	
	public Plane(Point p, Direction n, Material material) {
		this.p = p;
		this.n = Vector.normalize(n );
		this.material = material;
	}
	
	@Override
	public Hit intersect(Ray ray) {
		Hit hit = new Hit();
		hit.t = Vector.dotProduct( Vector.subtract(p, ray.origin) , n ) / Vector.dotProduct(ray.d, n);
		if(!(hit.t>=ray.tmin && hit.t <= ray.tmax))
			return null;
		hit.x = ray.pointAt(hit.t);
		if(Vector.length( Vector.subtract(hit.x, p)) > d)
			return null;
		
		hit.material = material;
		hit.n = Vector.normalize(n);
		
		return hit;
	}

}
