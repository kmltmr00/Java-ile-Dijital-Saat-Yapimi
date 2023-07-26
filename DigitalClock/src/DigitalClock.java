
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.*;
import java.text.*;
import java.awt.Font;
public class DigitalClock extends JFrame  {

	private JFrame frame;
	private JLabel timeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DigitalClock clock=new DigitalClock();
		clock.start();
	}

	/**
	 * Create the frame.
	 */
	public DigitalClock() {
		frame=new JFrame("Dijital Saat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Arial",Font.PLAIN,50));

		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,150);
		frame.setVisible(true);
	}
	public void start() {
		Thread updateThread =new Thread(() ->{
			while(true) {
				SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
				String time=dateFormat.format(new Date());
				timeLabel.setText(time);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			}
		});
		updateThread.start();
	}
}
