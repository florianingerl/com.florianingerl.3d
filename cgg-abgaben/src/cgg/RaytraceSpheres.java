package cgg;

import java.util.LinkedList;
import cgtools.Color;
import java.util.List;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point2D;
import cgtools.Sampler;
import cgtools.Vector;

public class RaytraceSpheres implements Sampler {

	private Camera camera;
	public Background background = new Background( new BackgroundMaterial( new Color(105/255.0, 105/255.0, 105/255.0) ) );
	private List<Ball> balls = new LinkedList<Ball>();

	public RaytraceSpheres(Camera camera) {
		
		this.camera = camera;
		
		final double z = - 2 * camera.getImage().width / (2 * Math.tan(camera.getPhi() / 2) );
		
		Ball ball = new Ball() {
			{
				m = Vector.point(0,0,z);
				r =  camera.getImage().width / 4;
				material = new PerfectDiffuseMaterial( new Color(1,0,0) );
			}
		};
		
		Ball ball2 = new Ball() {
			{
				m = Vector.point(-camera.getImage().width/4, camera.getImage().height/4, z - 400);
				r = camera.getImage().width / 3;
				material = new PerfectDiffuseMaterial( new Color(0,1,0) );
			}
		};
		
		Ball ball3 = new Ball() {
			{
				m = Vector.point(camera.getImage().width/3, -camera.getImage().height/3, z + 100);
				r = camera.getImage().width / 5;
				material = new PerfectDiffuseMaterial(new Color(0,0,1));
			}
		};
		
		balls.add(ball);
		balls.add(ball2);
		balls.add(ball3);
	}
	
	@Override
	public Color getColor(Point2D p) {
		
		Ray ray = camera.generateRay(p);
		
		double z = -Double.MAX_VALUE;
		
		
		Color c = null;
		for(Ball ball : balls) {
			Hit hit = ball.intersect(ray);
			if(hit == null)
				continue;
			if(hit.x.z > z) {
				z = hit.x.z;
				c = Raytracer.lightSurface(hit.n, Color.black );
			}
		}
		
		if(c==null)
			c = new Color(0,0,0);
		return c;
	}
	

	
	
	
}
