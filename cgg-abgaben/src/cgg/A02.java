package cgg;

import java.util.ArrayList;

import cgtools.*;
import static cgtools.Color.*;

public class A02 {

	final static int WIDTH = 1024;
	final static int HEIGHT = 512;
	
	final static double GAMMA = 2.2;
	
	static class Disc {
		Point2D middlePoint;
		Color color;
		double radius;
		

		public Disc(Point2D middlePoint, double radius, Color color) {
			this.middlePoint = middlePoint;
			this.radius = radius;
			this.color = color;
		}

		void draw(Image image) {
			for(int x = 0; x!= image.width; ++x) {
				for(int y = 0; y!= image.height; ++y) {
					if( isPointInDisc(new Point2D(x,y))) {
						image.setPixel(x, y, this.color);
					}
				}
			}
		}

		boolean isPointInDisc(Point2D p) {
			double d = Math.sqrt( Math.pow(p.x-middlePoint.x,2) + Math.pow(p.y-middlePoint.y, 2) );
			if (d <= radius) {
				return true;
			}
			return false;
		}

	}
	
	
	static class Discs implements Sampler {

		ArrayList<Disc> discs = new ArrayList<Disc>();

		public Discs(int count) {
			Random rn = new Random();
			
			for (int i = 0; i < count; i++) {

				Point2D middlePoint = new Point2D(rn.nextInt(WIDTH), rn.nextInt(HEIGHT));
				Disc disc = new Disc(middlePoint, rn.nextInt(1000),
						new Color(rn.nextDouble(), rn.nextDouble(), rn.nextDouble()));

				discs.add(disc);
			}

		}

		public Color getColor(Point2D p) {
			Color clr = black;
			double radius = Double.MAX_VALUE;
			for (Disc disc : discs) {
				if (disc.isPointInDisc(p) && disc.radius < radius ) {
					radius = disc.radius;
					clr = disc.color;
				}

			}
			return clr;
		}
	}
	
	public static void main(String[] args) {
		
		final String filename = "doc/a02-discs.png";
		final String filename1 = "doc/a02-discs-supersampling.png";

		Image image = new Image(WIDTH, HEIGHT);
		Discs discs = new Discs(100);
		
		
		
		for(int x=0; x!= image.width; ++x) {
			for(int y =0; y != image.height; ++y) {
				Color clr = discs.getColor(new Point2D(x,y));
				
				GammaCorrector.correct(clr);
				
				image.setPixel(x, y, clr);
			}
		}
		
		
		image.write(filename);
		System.out.println("Wrote image: " + filename);
		A03.sample(image, discs);

		image.write(filename1);
		System.out.println("Wrote image: " + filename1);
	}

}
