package controller;

import java.util.Timer;
import java.util.TimerTask;

class kingSpeed extends TimerTask  {

	private int period= 7000;
	Timer timer = new Timer();


	@Override
	public void run() {
		System.out.println("the speed in now " + period/1000);
		period = period - 1000;
		timer.cancel();
		Timer timer = new Timer();
		timer.schedule(new kingMovement(), 0, period);
		// TODO Auto-generated method stub
		
	}
}