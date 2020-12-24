package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Matrix;
import cgtools.Vector;

public class ConeTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raytracer raytracer = new Raytracer();

		Camera camera = raytracer.getCamera();

		Direction rotationCenter = Vector.direction(0, 0, -880.0);
		Matrix transformMatrix = Matrix.translation(Vector.multiply(-1, rotationCenter));
		transformMatrix = Matrix.multiply(Matrix.rotation(Vector.direction(1, 0, 0), 0), transformMatrix);
		transformMatrix = Matrix.multiply(Matrix.translation(rotationCenter), transformMatrix);
		camera.setTransformMatrix(transformMatrix);

		Group scene = raytracer.getScene();

		Material backgroundMaterial = new BackgroundMaterial(new Color(1.0, 1.0, 1.0));
		Background background = new Background(backgroundMaterial);
		scene.add(background);

		Group g1 = new Group();
		Matrix m = Matrix.translation(Vector.direction(0, -200, -880));
		g1.transformation = new Transformation(m);
		scene.add(g1);

		Material groundMaterial = new PerfectDiffuseMaterial(Color.green);
		Plane ground = new Plane(Vector.point(0.0, 0.0, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial);
		g1.add(ground);

		double distanceBallGoal = 500;

		Ball football = new Ball() {
			{
				r = 30;
				m = Vector.point(60, 30, distanceBallGoal);
				material = new PerfectDiffuseMaterial(Color.white);
			}
		};
		g1.add(football);

		Cone cone = new Cone(Vector.point(0, 0, 0), 30, 100, new PerfectDiffuseMaterial(Color.red) );
		g1.add(cone);
		
		Group g2 = new Group();
		g2.add(cone);
		g1.add(g2);
		g2.transformation = new Transformation( Matrix.rotation(Vector.direction(1, 0, 0), -75) );
		
		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();

		final String filename = "doc/cone_test_app.png";
		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);
	}

}
