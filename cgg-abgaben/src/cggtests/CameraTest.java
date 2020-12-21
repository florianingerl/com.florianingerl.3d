package cggtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import cgg.A03;
import cgg.Camera;
import cgg.Image;
import cgg.Ray;
import cgtools.Direction;
import cgtools.Point2D;
import cgtools.Vector;

public class CameraTest {
	
	private Camera camera = new Camera(Math.PI /2, new Image(10,10));
	
	private void testCalcRayThroughImagePoint(Point2D p, Direction expectedDir) {
		Ray r = camera.generateRay(p);
		Direction d= Vector.normalize(r.d);
		BallTest.assertEqualsVector(expectedDir, d);
	}
	
	@Test
	public void testCalcRayThroughImagePoint() {
		
		Ray r1 = camera.generateRay(new Point2D(4, 5));
		BallTest.assertEqualsVector(Vector.point(0, 0, 0), r1.origin);
		
		// Tests
		Point2D p = new Point2D(0,0);
		Direction expectedDir = Vector.direction(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3));
		testCalcRayThroughImagePoint(p, expectedDir);
		
		p = new Point2D(5,5);
		expectedDir = Vector.direction(0, 0, -1);
		testCalcRayThroughImagePoint(p, expectedDir);
		
		p = new Point2D(10,10);
		expectedDir = Vector.direction(1/ Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3));
		testCalcRayThroughImagePoint(p, expectedDir);

	}

}
