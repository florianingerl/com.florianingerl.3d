package cgg;

import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

public class Ray {
	
	public Point origin;
	public Direction d;
	
	public double tmin = 0;
	public double tmax = Double.POSITIVE_INFINITY;
	
	
	public Point pointAt(double t) {
		return Vector.add(origin , Vector.multiply(d, t) ); // x0 + t * d
	}
	
	public boolean contains(double t) {
		return t>= tmin && t <= tmax;
	}

}
