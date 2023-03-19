package com.prac.ds.math;

/**
 * 
 * Calculate the angle between the hour hand and minute hand.
 * 
 * Example 1:
 * 
 * Input: H = 9 , M = 0 Output: 90 Explanation: The minimum angle between hour
 * and minute hand when the time is 9 is 90 degress.
 * 
 * Example 2: Input: H = 3 , M = 30 Output: 75 Explanation: The minimum angle
 * between hour and minute hand when the time is 3:30 is 75 degress.
 *
 * In 12 hours , hour hand can do 360 degrees , so per hour hour hand will do 30
 * degrees.
 * 
 * Similarly in 60 minutes, minute hand can do 360 degrees, so in 1 minute, the
 * minute hand will do 6 degree rotation.
 * 
 * Also keep in mind while the minute hand is moving the hour hand will move
 * along with it. Like in 60 minutes , the hour hand rotates 30 degrees
 * 
 * So per minute the hour hand rotates 0.5 degrees.
 * 
 * Now simply find the difference between the hour and minute hand store it in
 * result.
 * 
 * Now check whether result or 360 - result, which is smaller and return it as
 * the result.
 */
public class AngleBetweenHourAndMinuteHand1344 {

	public static void main(String[] args) {
		System.out.println("angle :" + getAngle(3, 30));
		System.out.println("angle :" + getAngle1(3, 30));

	}

	public static double getAngle(int hour, int minutes) {
		double angleHour = hour * 30, angleMinutes = minutes * 6;
		angleHour = angleHour + 0.5 * (minutes);
		double res = Math.abs(angleHour - angleMinutes);
		return Math.min(res, 360 - res);

	}

	public static int getAngle1(int H, int M) {
		// code here
		// (1Minute = 6 degree=360/60)
		// 1hour= 30 degree = 360/12)
		double angle = (double) Math.abs(5.5 * M - 30 * H);
		if (angle > 180) {
			return (int) (360 - angle);
		}
		return (int) angle;
	}

}
