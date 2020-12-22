package cgg;

import cgtools.Color;
import cgtools.Vector;

public class Background implements Shape{

	private Material material;
	
	public Background(Material material) {
		this.material = material;
	}
	
	@Override
	public Hit intersect(Ray ray) {
		// TODO Auto-generated method stub
		Hit hit = new Hit() {
			{
				double infty = Double.POSITIVE_INFINITY;
				t = infty;
				x = Vector.point(infty, infty, infty);
			    material = Background.this.material;
			    		
				n = Vector.direction(0,0,1);
			}
		};
		
		return hit;
	}
	
	@Override
	public BoundingBox bounds() {
		return BoundingBox.everything;
	}

}
