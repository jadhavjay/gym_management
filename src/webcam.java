import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.github.sarxos.webcam.Webcam;

public class webcam {
public static void main(String args[]) throws Throwable  {
	try {
	
	Webcam webcam = Webcam.getDefault();
	webcam.open();
	
		ImageIO.write(webcam.getImage(), "PNG", new File("C:\\photo.png"));
		webcam.close();
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Error while capturing Image!!");
	}
		}
}
