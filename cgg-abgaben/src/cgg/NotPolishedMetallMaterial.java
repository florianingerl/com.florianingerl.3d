package cgg;

import java.util.Random;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Vector;

public class NotPolishedMetallMaterial implements Material {

	private static Random random = new Random();
	public double s = 0.1;
	
	private Color color;
	private double R;
	
	public NotPolishedMetallMaterial(Color color, double R) {
		this.color = color;
		this.R = R;
	}
	
	@Override
	public MaterialHitProps getHitProps(Ray ray, Hit hit) {
		MaterialHitProps mhp = new MaterialHitProps();
		
		mhp.emission = Color.black;
		mhp.albedo = Color.multiply(R, color);
		
		Direction d = Vector.subtract(ray.d , Vector.multiply(2*Vector.dotProduct(ray.d, hit.n), hit.n) );
		double x = 1.0, y = 1.0 , z = 1.0;
		while( Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) > 1) {
			x = random.nextDouble();
			y = random.nextDouble();
			z = random.nextDouble();
		}
		
		d = Vector.add(d, Vector.multiply(s,Vector.direction(x, y, z) ) );
		mhp.scatteredRay = new Ray();
		mhp.scatteredRay.d = Vector.normalize(d);
		mhp.scatteredRay.origin = hit.x;
		mhp.scatteredRay.tmin = Math.pow(10, -4);
		
		return mhp;
	}

}
