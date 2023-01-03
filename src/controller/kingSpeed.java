package controller;

import java.util.Timer;
import java.util.TimerTask;

class kingSpeed extends TimerTask  {

	private int period= 7000;
	Timer timer = new Timer();


	@Override
	public void run() {
		period = period - 1000;
		System.out.println("the speed in now " + period/1000);
		timer.cancel();
//		Timer timer = new Timer();
		GameController.getTimer2().schedule(new kingMovement(), 0, period);
		// TODO Auto-generated method stub
		
	}
}