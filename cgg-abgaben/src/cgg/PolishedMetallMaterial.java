package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Vector;

public class PolishedMetallMaterial implements Material {

	private Color color;
	private double R;
	
	public PolishedMetallMaterial(Color color, double R) {
		this.color = color;
		this.R = R;
	}
	
	@Override
	public MaterialHitProps getHitProps(Ray ray, Hit hit) {
		
		MaterialHitProps mhp = new MaterialHitProps();
		
		mhp.emission = Color.black;
		mhp.albedo = Color.multiply( R, color );
		
		Direction d = Vector.subtract(ray.d , Vector.multiply(2*Vector.dotProduct(ray.d, hit.n), hit.n) );
		mhp.scatteredRay = new Ray();
		mhp.scatteredRay.d = Vector.normalize(d);
		mhp.scatteredRay.tmin = Math.pow(10, -4);
		mhp.scatteredRay.origin = hit.x;
		
		return mhp;
	}

}
