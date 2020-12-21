package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Matrix;
import cgtools.Vector;

public class A09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile1();

	}

	private static void writeFile1() {

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
				m = Vector.point(0, 30, distanceBallGoal);
				material = new PerfectDiffuseMaterial(Color.white);
			}
		};
		g1.add(football);

		Ball schneemannKopf = new Ball() {
			{
				r = 50;
				m = Vector.point(0, 180, -20);
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		g1.add(schneemannKopf);

		Ball schneemannKörper = new Ball() {
			{
				r = 100;
				m = Vector.point(0, 50, -20);
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		g1.add(schneemannKörper);

		/*
		 * double length = 1000.0; double width = 150; double height = 400.0;
		 * 
		 * double radiusPfosten = 20.0;
		 * 
		 * Group g2 = new Group(); g1.add(g2); Matrix m2 =
		 * Matrix.translation(Vector.direction(0, 0, -distanceBallGoal / 2));
		 * g2.transformation = new Transformation(m2);
		 * 
		 * Zylinder pfosten = new Zylinder(Vector.point(0, 0, 0), radiusPfosten, height,
		 * new PerfectDiffuseMaterial(Color.white));
		 * 
		 * for (int i = -1; i <= 1; i = i + 2) { Group g = new Group(); g2.add(g);
		 * Matrix m3 = Matrix.translation(Vector.direction(i * length / 2, 0, 0));
		 * g.transformation = new Transformation(m3); g.add(pfosten);
		 * 
		 * Group g3 = new Group(); g2.add(g3); Matrix m4 =
		 * Matrix.translation(Vector.direction(i * length / 2, 0, -width));
		 * g3.transformation = new Transformation(m4); g3.add(pfosten); }
		 * 
		 * Zylinder latte = new Zylinder(Vector.point(0, 0, 0), radiusPfosten, length,
		 * new PerfectDiffuseMaterial(Color.white)); double radiusNet = 5.0; Zylinder
		 * netBack = new Zylinder(Vector.point(0, 0, 0), radiusNet, length, new
		 * PerfectDiffuseMaterial(Color.white)); Group lgNetBack = new Group(); Matrix
		 * m9 = Matrix.rotation(Vector.direction(0, 0, 1), -90); lgNetBack.add(netBack);
		 * lgNetBack.transformation = new Transformation(m9);
		 * 
		 * int numNet = 10; double d = height / numNet;
		 * 
		 * 
		 * Zylinder zylSide = new Zylinder(Vector.point(0, 0, 0), radiusNet, width, new
		 * PerfectDiffuseMaterial(Color.white)); Group g11 = new Group();
		 * g11.add(zylSide); g11.transformation = new
		 * Transformation(Matrix.rotation(Vector.direction(1, 0, 0), -90));
		 * 
		 * d = height / numNet;
		 * 
		 * Zylinder zylNetBack = new Zylinder(Vector.point(0, 0, 0), radiusNet, height,
		 * new PerfectDiffuseMaterial(Color.white));
		 * 
		 * int anzNet = 10; double e = length / anzNet;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * anzNet = 5; e = width / anzNet;
		 * 
		 * Group lgLatte = new Group(); lgLatte.add(latte); Matrix m10 =
		 * Matrix.rotation(Vector.direction(0, 0, 1), -90); lgLatte.transformation = new
		 * Transformation(m10);
		 * 
		 * { Group lg1 = new Group(); g2.add(lg1); lg1.add(lgLatte); Matrix m5 =
		 * Matrix.translation(Vector.direction(-length / 2, height, 0));
		 * lg1.transformation = new Transformation(m5);
		 * 
		 * }
		 * 
		 * { Group lg1 = new Group(); lg1.add(lgLatte); g2.add(lg1); Matrix m5 =
		 * Matrix.translation(Vector.direction(-length / 2, height, -width));
		 * lg1.transformation = new Transformation(m5); }
		 * 
		 * Zylinder zylinderBack = new Zylinder(Vector.point(0, 0, 0), radiusPfosten,
		 * width, new PerfectDiffuseMaterial(Color.white)); Group lgLatteBack = new
		 * Group(); lgLatteBack.add(zylinderBack); Matrix m6 =
		 * Matrix.rotation(Vector.direction(1, 0, 0), -90); lgLatteBack.transformation =
		 * new Transformation(m6);
		 * 
		 * for (int i = -1; i <= 1; i = i + 2) { Group lg3 = new Group(); g2.add(lg3);
		 * lg3.add(lgLatteBack); Matrix m7 = Matrix.translation(Vector.direction(i *
		 * length / 2, height, 0)); lg3.transformation = new Transformation(m7); }
		 */

		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();

		final String filename = "doc/a09-benchmark-scene.png";
		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);

	}

}
