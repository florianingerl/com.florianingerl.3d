package cgg;

import cgtools.Color;
import cgtools.Vector;

public class A05 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Raytracer raytracer = new Raytracer();
		Group scene = raytracer.getScene();
		
		Material backgroundMaterial = new BackgroundMaterial( new Color( 1.0, 1.0, 1.0 ));
		Background background = new Background(backgroundMaterial);
		scene.add(background);
		
		Material groundMaterial = new PerfectDiffuseMaterial( Color.gray ); 
		Plane ground = new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial );
		scene.add(ground);
		
		Ball ball1 = new Ball() {
			{
				m = Vector.point(-2.0, 0.25, -2.5);
				r = 0.5;
				material = new PerfectDiffuseMaterial(Color.red);
			}
		};
		scene.add(ball1);
		Ball ball2 = new Ball() {
			{
				m = Vector.point(0.0, 0.3, -2.5 );
				r = 0.35;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(ball2);
		Ball ball3 = new Ball() {
			{
				m = Vector.point(1.5, 0.0, -2.5);
				r = 0.7;
				material = new PerfectDiffuseMaterial(Color.blue);
			}
		};
		scene.add(ball3);
		Ball ball4 = new Ball() {
			{
				m = Vector.point(-1., 0.5, -2.5);
				r = 0.2;
				material = new PerfectDiffuseMaterial(Color.white);
			}
		};
		scene.add(ball4);
		
		
		A03.sample(raytracer.getImage(), raytracer);
		
		final String filename = "doc/a05-diffuse-spheres.png";
		raytracer.getImage().write(filename);
		System.out.println("Wrote image: " + filename);
		
	}

}
