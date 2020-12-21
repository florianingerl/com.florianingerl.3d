package cgg;

import cgtools.Color;
import cgtools.Vector;

public class A04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raytracer raytracer = new Raytracer();
		
		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();
		
		final String filename = "doc/a04-3-spheres.png";
		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);
		
		
		Group shapes = raytracer.getScene();
		Ball ball = new Ball() {
			{
				m = Vector.point(-2.0, -0.25, -2.5);
				r = 0.5;
				material = new PerfectDiffuseMaterial(  Color.white );
			}
		};
		shapes.add(ball);
		shapes = raytracer.getScene();
		Ball ballW = new Ball() {
			{
				m = Vector.point(-2.0, 0.3, -2.5);
				r = 0.4;
				material = new PerfectDiffuseMaterial(  Color.white );
			}
		};
		shapes.add(ballW);
		shapes = raytracer.getScene();
		Ball ballWi = new Ball() {
			{
				m = Vector.point(-2.0, 0.75, -2.5);
				r = 0.25;
				material = new PerfectDiffuseMaterial(  Color.white );
			}
		};
		shapes.add(ballWi);
		
		shapes = raytracer.getScene();
		Ball ball2 = new Ball() {
			{
				m = Vector.point(2.0, -0.25, -2.5);
				r = 0.5;
				material = new PerfectDiffuseMaterial(  Color.gray );
			}
		};
		shapes.add(ball2);
		shapes = raytracer.getScene();
		Ball ballg = new Ball() {
			{
				m = Vector.point(2.0, 0.3 , -2.5);
				r = 0.4;
				material = new PerfectDiffuseMaterial(  Color.gray );
			}
		};
		shapes.add(ballg);
		shapes = raytracer.getScene();
		Ball ballgr = new Ball() {
			{
				m = Vector.point(2.0, 0.7, -2.5);
				r = 0.25;
				material = new PerfectDiffuseMaterial(  Color.gray );
			}
		};
		shapes.add(ballgr);
		
		shapes = raytracer.getScene();
		Ball ball3 = new Ball() {
			{
				m = Vector.point(0.0, 0.3, -2.5);
				r = 0.4;
				material = new PerfectDiffuseMaterial(  Color.green );
			}
		};
		shapes.add(ball3);
		
		shapes = raytracer.getScene();
		Ball ball4 = new Ball() {
			{
				m = Vector.point(0.0, 0.75, -2.5);
				r = 0.25;
				material = new PerfectDiffuseMaterial(  Color.green );
			}
		};
		shapes.add(ball4);
		
		shapes = raytracer.getScene();
		Ball ballr = new Ball() {
			{
				m = Vector.point(-1.0, 0.3, -2.5);
				r = 0.5;
				material = new PerfectDiffuseMaterial(  Color.red );
			}
		};
		shapes.add(ballr);
		shapes = raytracer.getScene();
		Ball ballre = new Ball() {
			{
				m = Vector.point(-1.0, 0.85, -2.5);
				r = 0.25;
				material = new PerfectDiffuseMaterial(  Color.red );
			}
		};
		shapes.add(ballre);
		shapes = raytracer.getScene();
		Ball ballb = new Ball() {
			{
				m = Vector.point(1.0, 0.3, -2.5);
				r = 0.5;
				material = new PerfectDiffuseMaterial(  Color.blue );
			}
		};
		shapes.add(ballb);
		shapes = raytracer.getScene();
		Ball ballbl = new Ball() {
			{
				m = Vector.point(1.0, 0.85, -2.5);
				r = 0.25;
				material = new PerfectDiffuseMaterial(  Color.blue );
			}
		};
		shapes.add(ballbl);
		
		
		mtic = new MultiThreadedImageCreator(4, raytracer.getImage(), raytracer);
		mtic.createImage();
		
		final String filename2 = "doc/a04-scene.png";
		raytracer.getImage().write(filename2);
		System.out.println("Wrote image: " + filename2);
		
	}

}
