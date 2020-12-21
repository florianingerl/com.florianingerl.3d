package cgg;

import cgtools.Color;
import cgtools.Vector;

public class A06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile1();
		writeFile2();

	}

	private static void writeFile1() {
		Raytracer raytracer = new Raytracer();
		Group scene = raytracer.getScene();

		Material backgroundMaterial = new BackgroundMaterial(new Color(1.0, 1.0, 1.0));
		Background background = new Background(backgroundMaterial);
		scene.add(background);

		Material groundMaterial = new PerfectDiffuseMaterial(Color.white);
		Plane ground = new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial);
		scene.add(ground);	


		final String filename = "doc/a06-mirrors-glass-1.png" ;

		Ball ballGreen = new Ball() {
			{
				m = Vector.point(0.0, -0.3, -1.0);
				r = 0.2;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(ballGreen);

		Ball ballBlue = new Ball() {
			{
				m = Vector.point(0.0, 0.0, -2.5);
				r = 0.6;
				material = new PerfectDiffuseMaterial(Color.blue);
			}
		};
		scene.add(ballBlue); 

		Ball ballGlass = new Ball() {
			{
				m = Vector.point(-1.0, 0.0, -2.0);
				r = 0.4;
				material = new TransparentMaterial(1.3);
			}
		};
		scene.add(ballGlass);



		Ball ballGlass2 = new Ball() {
			{
				m = Vector.point(0.5, 0.2, -1.5);
				r = 0.6;
				material = new TransparentMaterial(1.3);
			}
		};
		scene.add(ballGlass2);


		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();

		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);

	}

	private static void writeFile2() {

		Raytracer raytracer = new Raytracer();
		Group scene = raytracer.getScene();

		Material backgroundMaterial = new BackgroundMaterial(new Color(1.0, 1.0, 1.0));
		Background background = new Background(backgroundMaterial);
		scene.add(background);

		Material groundMaterial = new PerfectDiffuseMaterial(Color.white);
		Plane ground = new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial);
		scene.add(ground);	

		final String filename = "doc/a06-mirrors-glass-2.png";

		Ball ballNPM = new Ball() {
			{
				m = Vector.point(1.25, 0.2, -2.5);
				r = 0.8;
				material = new NotPolishedMetallMaterial(Color.white, 0.9);
			}
		};
		scene.add(ballNPM);

		Ball ballPM = new Ball() {
			{
				m = Vector.point(-1.25, 0.2, -2.5);
				r = 0.8;
				material = new PolishedMetallMaterial(Color.white, 0.9);
			}
		};
		scene.add(ballPM);

		Ball ballRed = new Ball() {
			{
				m = Vector.point(0.0, -0.3, -1.5);
				r = 0.2;
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		scene.add(ballRed);
		
		Ball ballRed1 = new Ball() {
			{
				m = Vector.point(0.0, 0.05, -1.5);
				r = 0.2;
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		scene.add(ballRed1);
		
		Ball ballRed2 = new Ball() {
			{
				m = Vector.point(0.0, 0.4, -1.5);
				r = 0.2;
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		scene.add(ballRed2);



		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();

		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);

	}

}
