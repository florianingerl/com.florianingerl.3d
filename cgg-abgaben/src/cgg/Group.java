package cgg;

import java.util.LinkedList;
import java.util.List;

import cgtools.Matrix;

public class Group implements Shape {

	private List<Shape> shapes = new LinkedList<Shape>();
	
	public Transformation transformation;
	
	public void add(Shape shape) {
		shapes.add(shape);
	}
	
	@Override
	public Hit intersect(Ray ray) {
		Ray ray2 = transformation == null ? ray : transformation.transformFromWorld(ray);
		
		if(! bounds().intersect(ray2) ) return null;
		
		Hit hit = null;
		for(Shape shape : shapes) {
			Hit h = shape.intersect(ray2);
			if(hit == null || (h != null &&  h.t < hit.t ) ) {
				hit = h;
			}
		}
		if(hit != null && transformation != null) transformation.transformToWorld(hit);
		
		return hit;
	}
	
	private BoundingBox boundingBox;
	@Override
	public BoundingBox bounds() {
		if(boundingBox == null) {
			boundingBox = BoundingBox.empty;
			for(Shape shape: shapes) {
				boundingBox = boundingBox.extend(shape.bounds() );
			}
		}
		return boundingBox;
	}

}
