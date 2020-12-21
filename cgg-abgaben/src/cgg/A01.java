package cgg;

import static cgtools.Color.*;

import cgtools.*;

public class A01 {

	public static void main(String[] args) {
		final int width = 160;
		final int height = 90;
		final String filename = "doc/a01-image.png";
		final String filename2 = "doc/a01-disc.png";
		final String filename3 = "doc/a01-disc-checkered.png";

		class ConstantColor {
			Color color;

			ConstantColor(Color color) {
				this.color = color;
			}

			Color getColor(double x, double y) {
				return color;
			}
		}

		class Kreisscheibe {
			Color color;

			
			Kreisscheibe(Color color) {
				this.color = color;
			}

			Color getColor(double x, double y) {
				return color;
			}
			
		}

		class Schachbrettmuster {
			Color color;

			Schachbrettmuster(Color color) {
				this.color = color;
			}

			Color getColor(double x, double y) {
				return color;
			}
		}

		Image image = new Image(width, height);

		ConstantColor allGray = new ConstantColor(gray);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				image.setPixel(x, y, allGray.getColor(x, y));
			}
		}

		image.write(filename);
		System.out.println("Wrote image: " + filename);

		// schwarzer Hintergrund
		Image image2 = new Image(width, height);

		ConstantColor allblack = new ConstantColor(black);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				image2.setPixel(x, y, allblack.getColor(x, y));
			}
		}
		// roter Kreis

		double PI = 3.1415926535;
		double i, angle, x1, y1;

		for (i = 0; i < 360; i += 0.1) {
			for (int j = 0; j < 35; j += 1) {
				angle = i;
				x1 = j * Math.cos(angle * PI / 180);
				y1 = j * Math.sin(angle * PI / 180);
				image2.setPixel((int) (80 + x1), (int) (45 + y1), red);


			}
		} 
		image2.write(filename2);
		System.out.println("Wrote image: " + filename2); 

		// Schachbrettmuster
		Image image3 = new Image(width,height);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {

				if (y < height / 8) {
					if (x < width / 8 || x > (2 * width / 8) && x < (3 * width / 8) || x > (4 * width / 8) && x < (5 * width / 8)
							|| x > (6 * width / 8) && x < (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if (y > height / 8 && y<(2*height/8)) {
					if (x > width / 8 && x < (2 * width / 8) || x > (3 * width / 8) && x < (4 * width / 8) || x > (5 * width / 8)
							&& x < (6 * width / 8) || x > (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if  ( y > (2 * height / 8) && y < (3 * height / 8)){
					if (x < width / 8 || x > (2 * width / 8) && x < (3 * width / 8) || x > (4 * width / 8) && x < (5 * width / 8)
							|| x > (6 * width / 8) && x < (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if (y > 3*height / 8 && y<(4*height/8)) {
					if (x > width / 8 && x < (2 * width / 8) || x > (3 * width / 8) && x < (4 * width / 8) || x > (5 * width / 8)
							&& x < (6 * width / 8) || x > (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if  ( y > (4 * height / 8) && y < (5 * height / 8)){
					if (x < width / 8 || x > (2 * width / 8) && x < (3 * width / 8) || x > (4 * width / 8) && x < (5 * width / 8)
							|| x > (6 * width / 8) && x < (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if (y > 5*height / 8 && y<(6*height/8)) {
					if (x > width / 8 && x < (2 * width / 8) || x > (3 * width / 8) && x < (4 * width / 8) || x > (5 * width / 8)
							&& x < (6 * width / 8) || x > (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if  ( y > (6 * height / 8) && y < (7 * height / 8)){
					if (x < width / 8 || x > (2 * width / 8) && x < (3 * width / 8) || x > (4 * width / 8) && x < (5 * width / 8)
							|| x > (6 * width / 8) && x < (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
				if (y > 7 * height / 8 ) {
					if (x > width / 8 && x < (2 * width / 8) || x > (3 * width / 8) && x < (4 * width / 8) || x > (5 * width / 8)
							&& x < (6 * width / 8) || x > (7 * width / 8)) {
						image3.setPixel(x, y, white);
					}
				}
			}
		}

		for (i = 0; i < 360; i += 0.1) {
			for (int j = 0; j < 35; j += 1) {
				angle = i;
				x1 = j * Math.cos(angle * PI / 180);
				y1 = j * Math.sin(angle * PI / 180);
				image3.setPixel((int) (80 + x1), (int) (45 + y1), red);
			}
		} 

		image3.write(filename3);
		System.out.println("Wrote image: " + filename3);

	}
}
