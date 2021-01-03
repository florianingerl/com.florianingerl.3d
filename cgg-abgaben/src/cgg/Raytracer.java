package cgg;

import cgtools.Color;
import cgtools.Direction;
import cgtools.Point2D;
import cgtools.Sampler;
import cgtools.Vector;

public class Raytracer implements Sampler {

	private Camera camera = new Camera(Math.PI /3, new Image(900,500) );
	private Group scene = new Group();
	
	public Raytracer() {
		
	}	
	
	@Override
	public Color getColor(Point2D p) {
		Ray ray = camera.generateRay(p);
		return calculateRadiance( ray, 5);
		
	}
	
	public Color calculateRadiance(Ray ray, int depth) {
		
		if(depth == 0) return Color.black;
		
		Hit hit = scene.intersect(ray);
		MaterialHitProps properties = hit.material.getHitProps(ray, hit);
		
		if(properties.scatteredRay != null) {
			Color result = Color.black;
			if(properties.transmittedRay != null ) {
				result = Color.multiply(properties.albedoTrans, calculateRadiance(properties.transmittedRay, depth - 1) );
			}
			return Color.add(result, properties.emission , Color.multiply(properties.albedo , calculateRadiance(properties.scatteredRay, depth - 1) ) );
		}
		else {
			return properties.emission;
		}
	}
	
	public Image getImage() {
		return camera.getImage();
	}
	
	public Group getScene() {
		return scene;
	}
	

	
	public static Color lightSurface(Direction normal, Color color) {
		Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5) );
		Color ambient = Color.multiply(0.1, color);
		double f = 0.9 * Math.max(0, Vector.dotProduct(lightDir, normal) );
		Color diffuse = Color.multiply(f, color);
		return Color.add(ambient, diffuse);
		
		
	}
	
	public Camera getCamera() {
		return camera;
	}

}



