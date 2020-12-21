package cgg;

import static cgtools.Color.black;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import cgg.A02.Discs;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import cgtools.Point2D;
import cgtools.Sampler;
import cgtools.Vector;

public class A03 {

	public static double GAMMA = 2.2;

	public static void main(String[] args) {

		Image image = new Image(500, 500);
		Camera camera = new Camera(Math.PI / 2, image);

		RaytraceSpheres spheres = new RaytraceSpheres(camera);
		MultiThreadedImageCreator mtic = new MultiThreadedImageCreator(4, camera.getImage(), spheres);
		mtic.createImage();

		final String filename = "doc/a03-three-spheres.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}




}
