package cgg;

import java.util.Random;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Vector;

public class PerfectDiffuseMaterial implements Material {

	public static Random random = new Random();
	
	private Color color;
	
	public PerfectDiffuseMaterial(Color color) {
		this.color = color;
	}
	
	@Override
	public MaterialHitProps getHitProps(Ray ray, Hit hit) {
		MaterialHitProps mhp = new MaterialHitProps();
		mhp.emission = Color.black;
		
		
		double x = 100, y = 100, z = 100;
		while( Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) > 1 ) {
			x = random.nextDouble();
			y = random.nextDouble();
			z = random.nextDouble();
		}
		Direction d = Vector.add(hit.n, Vector.direction(x, y, z) ) ;
		d = Vector.normalize(d);
		
		Ray scatteredRay = new Ray();
		scatteredRay.origin = hit.x;
		scatteredRay.d = d;
		scatteredRay.tmin = Math.pow(10, -4);
		
		mhp.scatteredRay = scatteredRay;
		
		mhp.albedo = Color.multiply(this.color,	Math.abs( Vector.dotProduct(hit.n, ray.d) ) );
		
		return mhp;
	}

}
