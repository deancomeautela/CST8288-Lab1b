/**
 * network is the package for class placement
 */
package network;
//import statements
import java.lang.Math;
import javax.swing.JOptionPane;
/**
 * This class is a simulation of Shannon's Theorem. The user is asked to 
 * enter a bandwidth and signal-to-noise ratio, after which the program
 * will print the result.
 * @author    Richard Barney
 * @version   1.0.0 January 19, 2015
 */
public class ShannonsTheorem {
	/** Double used for bandwidth input (hertz). */
	private double bandwidth;
	/** Double used for signal-to-noise ratio input (decibels). */
	private double signalToNoise;
	
	/** 
	 * Default constructor.
	 **/
	public ShannonsTheorem() { }

	/**
	 * Get method that returns the bandwidth (hertz).
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { return bandwidth; }
	/**
	 * Get method that returns the signal-to-noise ratio (decibels).
	 * @return	signalToNoise	double containing the signal-to-noise ratio.
	 */
	public double getSignalToNoise() { return signalToNoise; }
	/**
	 * Private get method that returns the maximum data rate in bits per second.
	 * @param    hertz    		double to represent bandwidth in hertz.
	 * @param    signalToNoise	double to represent signal-to-noise ratio (decibels).
	 * @return maximum data rate in bits per second as a double.
	 */
	private double getMaximumDataRate(double hertz, double signalToNoise) { return (hertz *  (Math.log(1+Math.pow(10, signalToNoise/10)) / Math.log(2))); }
	/**
	 * Get method that returns the result of getMaximumDataRate.
	 * @return maximum data rate in bits per second as a double.
	 */
	public double getMaximumDataRate() { return getMaximumDataRate(bandwidth, signalToNoise); }

	/**
	 * Set method for bandwidth.
	 * @param    h    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { this.bandwidth = bandwidth;}
	/**
	 * Set method for signal-to-noise ratio.
	 * @param    snr   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { this.signalToNoise = signalToNoise;}
	
	/**
	 * Returns all data entered by user and displays maximum data rate
	 * @return String 
	 */
	 public String toString() {
		 return	"["
		 			+ "After calculating Shannon's Theorem with a bandwidth of "
		 			+ getBandwidth()
		 			+ "hertz and a\nsignal-to-noise ratio of "
		 			+ getSignalToNoise()
		 			+ " decibels, the result is "
		 			+ String.format("%.2f",getMaximumDataRate())
		 			+ " bits-per-second.]";
	} // end toString method

	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a string array.
	 */
	public static void main (String args[]) {
		boolean validationLoop = true; // boolean used to loop for data validation
		String sBandwidth, sSignalToNoise;
		ShannonsTheorem app = new ShannonsTheorem();
		JOptionPane.showMessageDialog(null, "Welcome to Richard Barney's Shannon's Theorem calculator!", "Hello!", JOptionPane.PLAIN_MESSAGE);
		do { // get bandwidth input, keep looping as long as validationLoop is true
			try {
				do {
					sBandwidth = JOptionPane.showInputDialog(null, "Please enter the bandwidth.", "Enter hertz", JOptionPane.QUESTION_MESSAGE);
					if (sBandwidth == null) { // if user clicks cancel, quit the program
						JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					app.setBandwidth(Double.parseDouble(sBandwidth));
				} while (Double.parseDouble(sBandwidth) <= 0);
				validationLoop = false; // stop looping for data validation if input is valid
			} catch (NumberFormatException e) { // catch invalid input
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
			}
		} while (validationLoop); // end get bandwidth input
		validationLoop = true; // set boolean to true again for second loop for data validation
		do { // get signal-to-noise ratio input, keep looping as long as validationLoop is true
			try {
				do {
					sSignalToNoise = JOptionPane.showInputDialog(null, "Please enter the signal-to-noise ratio.", "Enter signal-to-noise ratio", JOptionPane.QUESTION_MESSAGE); // ask for SNR
					if (sSignalToNoise == null) { // if user clicks cancel, quit the program
						JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					app.setSignalToNoise(Double.parseDouble(sSignalToNoise));
				} while (Double.parseDouble(sSignalToNoise) <= 0);
				validationLoop = false; // stop looping for data validation if input is valid
			} catch (NumberFormatException e) { // catch invalid input
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
			}	
		} while (validationLoop); // end get signal-to-noise ratio input
		JOptionPane.showMessageDialog(null, app, "Result", JOptionPane.PLAIN_MESSAGE); // display result
	} // end method main
} // end class ShannonsTheorem