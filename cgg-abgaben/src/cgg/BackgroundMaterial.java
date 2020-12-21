package cgg;

import cgtools.Color;

public class BackgroundMaterial implements Material {

	private Color emission;
	
	public BackgroundMaterial(Color emission) {
		this.emission = emission;
	}
	
	@Override
	public MaterialHitProps getHitProps(Ray ray, Hit hit) {
		MaterialHitProps mhp = new MaterialHitProps();
		
		mhp.albedo = Color.black;
		mhp.scatteredRay = null;
		mhp.emission = emission; //Farbe des Himmels in Strahlrichtung
		
		return mhp;
	}

}
