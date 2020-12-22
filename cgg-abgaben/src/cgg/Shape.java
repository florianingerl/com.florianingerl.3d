package cgg;

public interface Shape {

	public Hit intersect(Ray ray);
	
	public BoundingBox bounds();
}
