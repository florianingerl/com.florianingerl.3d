package cgg;

import cgtools.*;

public class Image {
	private double[] data;
	int width;
	int height;
	

	public Image(int width, int height) {
		this.width=width;
		this.height=height;
		// zu überprüfen
		data = new double [width * height * 3];
	}

	public void setPixel(int x, int y, Color color) {
		  int i = (width * y + x) * 3;
		  data[i+0]= color.r;
		  data[i+1]= color.g;
		  data[i+2]= color.b;
	}

	public void write(String filename) {
		ImageWriter.write(filename, data, width, height);
	}
}
