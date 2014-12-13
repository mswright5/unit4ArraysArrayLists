import javax.swing.JFrame;
import java.util.Scanner;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class RadarViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        Scanner in = new Scanner(System.in);
        // create the radar, set the monster location, set the velocity of monster,
        // and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        
        System.out.print("Enter the monster's change in X: ");
        final int DX = in.nextInt();
        System.out.print("Enter the monster's change in Y: ");
        final int DY = in.nextInt();
        
        System.out.print("What is the monster's starting row? ");
        final int monsterRow = in.nextInt();
        System.out.print("What is the monster's starting column? ");
        final int monsterCol = in.nextInt();
        
        Radar radar = new Radar(ROWS, COLS, DX, DY, monsterRow, monsterCol);
        radar.setNoiseFraction(0.00);
        radar.scan();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        while(radar.scan() == false){
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            frame.repaint();
        }
           
        System.out.println("The monster's velocity is: ");
        int[] velocity = radar.getMonsterVelocity();
        System.out.println("DX: " + velocity[0]);
        System.out.println("DY: " + velocity[1]);
        //for(int i = 0; i < 100; i++)
        //{
        //    Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
        //    if(radar.scan() == true){break;}
            
        //    frame.repaint();
        // }
    }

}
