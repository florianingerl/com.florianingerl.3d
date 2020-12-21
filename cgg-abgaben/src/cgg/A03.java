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
		sample(image, spheres);

		final String filename = "doc/a03-three-spheres.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}


	private static int n = 10;

	private static class PixelSetter implements Runnable {
		private int x;
		private int y;

		private Image image;
		private Sampler sampler;

		PixelSetter(Sampler sampler, Image image, int x, int y) {
			this.sampler = sampler;
			this.image = image;
			this.x = x;
			this.y = y;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Color color = black;
			for (int xi = 0; xi < n; xi++) {
				for (int yi = 0; yi < n; yi++) {
					double xr = Math.random();
					double yr = Math.random();
					double xs = x + (xi + xr) / n;
					double ys = y + (yi + yr) / n;
					color = Color.add(color, sampler.getColor(new Point2D(xs, ys)));
				}
			}
			color = Color.divide(color, n * n);
			GammaCorrector.correct(color);
			image.setPixel(x, y, color);

		}
	}

	public static void sample(Image image, Sampler sampler) {
		ExecutorService pool = Executors.newFixedThreadPool(4);

		for (int x = 0; x < image.width; x++) {
			for (int y = 0; y < image.height; y++) {
				
				pool.execute(new PixelSetter(sampler, image, x,y) );
			}
		}
		
		System.out.println("Submitted all task to thread pool!");
		
		pool.shutdown();
		
		System.out.println("Now we wait for all threads to finish!");
	}

}
