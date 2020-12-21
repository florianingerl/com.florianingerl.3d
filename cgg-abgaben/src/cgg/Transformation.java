package cgg;

import cgtools.Matrix;
import cgtools.Vector;

public class Transformation {

	public Matrix mToWorld;
	public Matrix mFromWorld;
	public Matrix mToWorldNormal;
	
	public Transformation(Matrix mToWorld) {
		this.mToWorld = mToWorld;
		mFromWorld = Matrix.invert(mToWorld);
		mToWorldNormal = Matrix.transpose(mFromWorld);
	}
	
	public Ray transformFromWorld(Ray ray) {
		Ray ray2 = new Ray();
		ray2.tmin = ray.tmin;
		ray2.tmax = ray.tmax;
		ray2.origin = Matrix.multiply(mFromWorld, ray.origin);
		ray2.d = Vector.normalize( Matrix.multiply(mFromWorld, ray.d) );
		return ray2;
	}
	
	public void transformToWorld(Hit hit) {
		hit.n = Vector.normalize( Matrix.multiply(mToWorldNormal, hit.n ) );
		hit.x = Matrix.multiply(mToWorld, hit.x);
	}
	
}
