package cgg;

import cgtools.Matrix;
import cgtools.Point;
import cgtools.Point2D;
import cgtools.Vector;

public class Camera {

	private double phi;
	private Image image;
	private Matrix transformMatrix = Matrix.identity();
	
	public Camera(double phi, Image image) {
		this.phi = phi;
		this.image = image;
	}
	
	public void setTransformMatrix(Matrix matrix) {
		this.transformMatrix = matrix;
	}
	
	public Ray generateRay(Point2D p) {
		Ray ray = new Ray();
		ray.origin = Vector.point(0, 0, 0);

		double z = -image.height / (2 * Math.tan(phi / 2));

		Point x = Vector.point(p.x - image.width / 2, -(p.y - image.height / 2), z);
		ray.d = Vector.subtract(x, ray.origin);
		ray.d = Vector.normalize(ray.d);
		
		ray.origin = Matrix.multiply(transformMatrix, ray.origin );
		ray.d = Matrix.multiply(transformMatrix, ray.d);

		return ray;
	}

	public Image getImage() {
		return image;
	}

	public double getPhi() {
		// TODO Auto-generated method stub
		return phi;
	}
	
}
