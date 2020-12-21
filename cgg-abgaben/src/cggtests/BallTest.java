package cggtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cgg.Ball;
import cgg.Hit;
import cgg.Ray;
import cgtools.Vector;
import junit.framework.Assert;

public class BallTest {

	@Test
	public void testIntersectionBallWithRay() {
		
		//1.Test
		Ball b = new Ball() {
			{
				m = Vector.point(0, 0, -2);
				r = 1;
			}
		};
		Ray ray = new Ray() {
			{
				origin = Vector.point(0,0,0);
				d = Vector.direction(0,0,-1);
			}
		};
		Hit expectedHit = new Hit() {
			{
				n = Vector.direction(0, 0, 1);
				x = Vector.point(0, 0, -1);
			}
		};
		testIntersect(b, ray, expectedHit);
		
		
		//2.Test
		b = new Ball() {
			{
				m = Vector.point(0, 0, -2);
				r = 1;
			}
		};
		ray = new Ray() {
			{
				origin = Vector.point(0,0,0);
				d = Vector.direction(0,1,-1);
			}
		};
		testIntersect(b, ray, null);
		
		
		//3.Test
		b = new Ball() {
			{
				m = Vector.point(0, -1, -2);
				r = 1;
				}
		};
		
		ray = new Ray() {
			{
				origin = Vector.point(0, 0, 0);
				d  = Vector.direction(0,0,-1);
			}
		};
	    expectedHit = new Hit() {
			{
				n = Vector.direction(0, 1,0);
				x = Vector.point(0,0,-2);
			}
		};
		testIntersect(b, ray, expectedHit);
		
		//4.Test
		b = new Ball() {
			{
				m = Vector.point(0, 0, -2);
				r = 1;
				}
		};
		
		ray = new Ray() {
			{
				origin = Vector.point(0, 0, -4);
				d  = Vector.direction(0,0,-1);
			}
		};
		
		testIntersect(b, ray, null);
		
		
		//5.Test
		b = new Ball() {
			{
			  m = Vector.point(0,0,-4);
			  r = 1;
			}
		};
		ray = new Ray() {
			{
				origin = Vector.point(0,0,0);
				d = Vector.direction(0, 0, -1);
				tmax = 2;
			}
		};
		
		testIntersect(b, ray, null);
		
		
	}

	private static void testIntersect(Ball b, Ray ray, Hit expectedHit) {

		Hit hit = b.intersect(ray);
		if(expectedHit == null) {
			Assert.assertNull(hit);
			return;
		}
		Assert.assertNotNull(hit);
		
		assertEqualsVector(expectedHit.n, hit.n);
		assertEqualsVector(expectedHit.x, hit.x);
		
		System.out.println("n: " + hit.n.x + " " + hit.n.y + " " + hit.n.z);
		System.out.println("x: " + hit.x.x + " " + hit.x.y + " " + hit.x.z);

		System.out.println();
	}
	
	private static final double delta = 0.0000000001;
	
	public static void assertEqualsVector(Vector n1, Vector n2) {
		
		Assert.assertEquals(n1.x, n2.x, delta);
		Assert.assertEquals(n1.y, n2.y, delta);
		Assert.assertEquals(n1.z, n2.z, delta);
	}

}
