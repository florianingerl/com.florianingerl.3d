package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Matrix;
import cgtools.Vector;

public class A07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile1();
		writeFile2();

	}
		private static void writeFile1() {
		
		Raytracer raytracer = new Raytracer();
		
		Camera camera = raytracer.getCamera();
		
		Direction rotationCenter = Vector.direction(0, 0, -880.0);
		Matrix transformMatrix = Matrix.translation( Vector.multiply(-1, rotationCenter) );
		transformMatrix = Matrix.multiply(Matrix.rotation(Vector.direction(1, 0, 0), 0 ), transformMatrix );
		transformMatrix = Matrix.multiply( Matrix.translation(rotationCenter), transformMatrix );
		camera.setTransformMatrix(transformMatrix);
		
		Group scene = raytracer.getScene();

		Material backgroundMaterial = new BackgroundMaterial(new Color(1.0, 1.0, 1.0));
		Background background = new Background(backgroundMaterial);
		scene.add(background);

		Material groundMaterial = new PerfectDiffuseMaterial(Color.green);
		Plane ground = new Plane(Vector.point(0.0, -200.0, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial);
		scene.add(ground);	


		final String filename = "doc/a07-1.png" ;
		
		
		//Baum 1
		Zylinder baum = new Zylinder( Vector.point(-500, -200.0, -1400.0), 40, 400, new PerfectDiffuseMaterial(Color.brown));
		scene.add(baum);
				
		Ball blaetter = new Ball() {
			{
				m = Vector.point(-500, 300, -1400);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter); 
		
		Ball blaetter1 = new Ball() {
			{
				m = Vector.point(-400, 320, -1400);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter1); 
		
		Ball blaetter2 = new Ball() {
			{
				m = Vector.point(-600, 350, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter2);
		
		Ball blaetter3 = new Ball() {
			{
				m = Vector.point(-550, 400, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter3);
		
		Ball blaetter4 = new Ball() {
			{
				m = Vector.point(-450, 420, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter4);
		
		Ball blaetter5 = new Ball() {
			{
				m = Vector.point(-600, 200, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter5);
		
		
		
		//Baum 2
		Zylinder baum2 = new Zylinder( Vector.point(350, -200.0, -1000.0), 40, 400, new PerfectDiffuseMaterial(Color.brown) );
		scene.add(baum2);
		
		Ball b1 = new Ball() {
			{
				m = Vector.point(350, 400, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b1);
		
		Ball b2 = new Ball() {
			{
				m = Vector.point(300, 450, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b2);
		
		Ball b3 = new Ball() {
			{
				m = Vector.point(250, 350, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b3);
		
		Ball b4 = new Ball() {
			{
				m = Vector.point(450, 350, -1000);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b4);
		
		//Baum 3
		Zylinder baum3 = new Zylinder( Vector.point(-350, -200.0, -500.0), 40, 400, new PerfectDiffuseMaterial(Color.brown) );
		scene.add(baum3);
		
		Ball blatt1 = new Ball() {
			{
				m = Vector.point(-350, 300, -500);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blatt1);
		
		Ball blatt2 = new Ball() {
			{
				m = Vector.point(-300, 350, -500);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blatt2);
		
		//Sonne 
		Ball sonne = new Ball() {
			{
				m = Vector.point(1300, 600, -1500);
				r = 100;
				material = new PerfectDiffuseMaterial(new Color(1,1,0));
			}
		};
		scene.add(sonne);
		

		A03.sample(raytracer.getImage(), raytracer);

		raytracer.getImage().write( filename );
		System.out.println("Wrote image: " + filename );

	}
private static void writeFile2() {
		
		Raytracer raytracer = new Raytracer();
		
		Camera camera = raytracer.getCamera();
		
		Direction rotationCenter = Vector.direction(0, 0, -880.0);
		Matrix transformMatrix = Matrix.translation( Vector.multiply(-1, rotationCenter) );
		transformMatrix = Matrix.multiply(Matrix.rotation(Vector.direction(1, 0, 0), -20 ), transformMatrix );
		transformMatrix = Matrix.multiply( Matrix.translation(rotationCenter), transformMatrix );
		camera.setTransformMatrix(transformMatrix);
		
		Group scene = raytracer.getScene();

		Material backgroundMaterial = new BackgroundMaterial(new Color(1.0, 1.0, 1.0));
		Background background = new Background(backgroundMaterial);
		scene.add(background);

		Material groundMaterial = new PerfectDiffuseMaterial(Color.green);
		Plane ground = new Plane(Vector.point(0.0, -200.0, 0.0), Vector.direction(0.0, 1.0, 0.0), groundMaterial);
		scene.add(ground);	


		final String filename = "doc/a07-2.png" ;
		
		
		//Baum 1
		Zylinder baum = new Zylinder( Vector.point(-500, -200.0, -1400.0), 40, 400, new PerfectDiffuseMaterial(Color.brown));
		scene.add(baum);
				
		Ball blaetter = new Ball() {
			{
				m = Vector.point(-500, 300, -1400);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter); 
		
		Ball blaetter1 = new Ball() {
			{
				m = Vector.point(-400, 320, -1400);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter1); 
		
		Ball blaetter2 = new Ball() {
			{
				m = Vector.point(-600, 350, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter2);
		
		Ball blaetter3 = new Ball() {
			{
				m = Vector.point(-550, 400, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter3);
		
		Ball blaetter4 = new Ball() {
			{
				m = Vector.point(-450, 420, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter4);
		
		Ball blaetter5 = new Ball() {
			{
				m = Vector.point(-600, 200, -1400);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(blaetter5);
		
		
		
		//Baum 2
		Zylinder baum2 = new Zylinder( Vector.point(350, -200.0, -1000.0), 40, 400, new PerfectDiffuseMaterial(Color.brown) );
		scene.add(baum2);
		
		Ball b1 = new Ball() {
			{
				m = Vector.point(350, 400, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b1);
		
		Ball b2 = new Ball() {
			{
				m = Vector.point(300, 450, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b2);
		
		Ball b3 = new Ball() {
			{
				m = Vector.point(250, 350, -1000);
				r = 200;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b3);
		
		Ball b4 = new Ball() {
			{
				m = Vector.point(450, 350, -1000);
				r = 150;
				material = new PerfectDiffuseMaterial(Color.green);
			}
		};
		scene.add(b4);
		
		//Baum 3
				Zylinder baum3 = new Zylinder( Vector.point(-350, -200.0, -500.0), 40, 400, new PerfectDiffuseMaterial(Color.brown) );
				scene.add(baum3);
				
				Ball blatt1 = new Ball() {
					{
						m = Vector.point(-350, 300, -500);
						r = 200;
						material = new PerfectDiffuseMaterial(Color.green);
					}
				};
				scene.add(blatt1);
				
				Ball blatt2 = new Ball() {
					{
						m = Vector.point(-300, 350, -500);
						r = 200;
						material = new PerfectDiffuseMaterial(Color.green);
					}
				};
				scene.add(blatt2);
		
		//Sonne 
		Ball sonne = new Ball() {
			{
				m = Vector.point(1300, 600, -1500);
				r = 100;
				material = new PerfectDiffuseMaterial(new Color(1,1,0));
			}
		};
		scene.add(sonne);
		

		A03.sample(raytracer.getImage(), raytracer);

		raytracer.getImage().write( filename );
		System.out.println("Wrote image: " + filename );
	}

}
