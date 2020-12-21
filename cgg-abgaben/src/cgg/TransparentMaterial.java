package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Vector;

public class TransparentMaterial implements Material {

	private double n = 1.0;

	public TransparentMaterial(double n) {
		this.n = n;
	}

	@Override
	public MaterialHitProps getHitProps(Ray ray, Hit hit) {
		MaterialHitProps mhp = new MaterialHitProps();

		mhp.emission = Color.black;

		Direction d = Vector.subtract(ray.d, Vector.multiply(2 * Vector.dotProduct(ray.d, hit.n), hit.n));
		mhp.scatteredRay = new Ray();
		mhp.scatteredRay.d = Vector.normalize(d);
		mhp.scatteredRay.tmin = Math.pow(10, -4);
		mhp.scatteredRay.origin = hit.x;

		double n1, n2;
		double c = (-1) * Vector.dotProduct(hit.n, ray.d);
		if( c > 0) {
			n1 = 1.0;
			n2 = n;
		}
		else {
			n1 = n;
			n2 = 1.0;
		}
		
		double r = n1 / n2;
		
		double D = 1 - r * r * (1 - c * c);
		if (D >= 0) {
			mhp.transmittedRay = new Ray();
			mhp.transmittedRay.d = Vector.normalize( Vector.add(Vector.multiply(r, ray.d), Vector.multiply(r * c - Math.sqrt(D), hit.n)) );
			mhp.transmittedRay.origin = hit.x;
			mhp.transmittedRay.tmin = Math.pow(10, -4);
			
			double R = Math.pow(n1-n2/(n1+n2), 2);
			R = R + (1 - R) * Math.pow( 1 - c, 5 );
			mhp.albedo = new Color(R, R, R);
			
			mhp.albedoTrans = new Color(1-R, 1-R, 1-R);
		} else {
			mhp.albedo = Color.white;
		}

		return mhp;
	}

}
