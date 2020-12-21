package cgg;

import cgtools.Color;

public class GammaCorrector {

	private static double GAMMA = 2.2;
	
	public static void correct(Color clr) {
		double intensity = clr.intensity();
		clr.b /= intensity;
		clr.g /= intensity;
		clr.r /= intensity;

		double gintensity = Math.pow(intensity, 1 / GAMMA);

		clr.b *= gintensity;
		clr.g *= gintensity;
		clr.r *= gintensity;
	}
}
