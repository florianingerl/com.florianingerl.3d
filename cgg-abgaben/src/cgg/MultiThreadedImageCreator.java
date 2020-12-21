package cgg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import cgtools.Color;
import cgtools.Sampler;

public class MultiThreadedImageCreator {
	
	private int n;
	private Image image;
	private Sampler sampler;
	
	private class PixelSetter implements Runnable {

		private int x;
		private int y;
		
		PixelSetter(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public void run() {
			Color color = MultiSampler.multiSample(x, y, sampler);
			GammaCorrector.correct(color);
			image.setPixel(x, y, color);
		}
	}
	
	
	public MultiThreadedImageCreator(int numThreads, Image image, Sampler sampler) {
		this.n = numThreads;
		this.image = image;
		this.sampler = sampler;
	}
	
	
	public void createImage() {
		ExecutorService pool = Executors.newFixedThreadPool(n);

		for (int x = 0; x < image.width; x++) {
			for (int y = 0; y < image.height; y++) {
				pool.execute(new PixelSetter(x,y) );
			}
		}
		
		System.out.println("Submitted all task to thread pool!");
		
		pool.shutdown();
		try {
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Now we wait for all threads to finish!");
	}
}
