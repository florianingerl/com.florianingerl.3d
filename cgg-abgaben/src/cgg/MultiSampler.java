package cgg;

import static cgtools.Color.black;

import cgtools.Color;
import cgtools.Point2D;
import cgtools.Sampler;

public class MultiSampler {

	private static int n = 10;
	
	public static Color multiSample(int x, int y, Sampler sampler) {
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
		return Color.divide(color, n * n);
	}
}
