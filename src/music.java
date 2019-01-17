import java.io.File;

import jaco.mp3.player.MP3Player;

public class music {
	public static void main(String args[]) {

	MP3Player mp= new MP3Player(new File("C:\\Users\\User\\eclipse-workspace\\gym_management\\src\\personal_alarm_buzzer.mp3"));
	mp.play();
}}
