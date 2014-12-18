import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RadarTest
{
    @Test
    public void testMonsterPositiveDXDY(){
        // create the radar, set the monster location, set the velocity of monster,
        // and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        
        final int DX = 2;
        final int DY = 3;
        
        final int monsterRow = 0;
        final int monsterCol = 0;
        
        Radar radar = new Radar(ROWS, COLS, DX, DY, monsterRow, monsterCol);
        radar.setNoiseFraction(0.01);
        radar.scan();
        
        
        // perform as many scans of the radar with a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        while(radar.scan() == false){

        }
        
        int[] velocity = radar.getMonsterVelocity();
        int dx = velocity[0] - 5;
        int dy = velocity[1] - 5;
        assertEquals(dx , 2);
        assertEquals(dy , 3);
    }
    
    @Test
    public void testMonsterNegativeDXDY(){
        // create the radar, set the monster location, set the velocity of monster,
        // and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        
        final int DX = -4;
        final int DY = -1;
        
        final int monsterRow = 50;
        final int monsterCol = 90;
        
        Radar radar = new Radar(ROWS, COLS, DX, DY, monsterRow, monsterCol);
        radar.setNoiseFraction(0.01);
        radar.scan();
        
        
        // perform as many scans of the radar with a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        while(radar.scan() == false){
        }
        
        int[] velocity = radar.getMonsterVelocity();
        int dx = velocity[0] - 5;
        int dy = velocity[1] - 5;
        assertEquals(dx , -4);
        assertEquals(dy , -1);
    }
    
    @Test
    public void testMonsterPositiveAndNegativeDXDY(){
        // create the radar, set the monster location, set the velocity of monster,
        // and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        
        final int DX = -3;
        final int DY = 3;
        
        final int monsterRow = 10;
        final int monsterCol = 90;
        
        Radar radar = new Radar(ROWS, COLS, DX, DY, monsterRow, monsterCol);
        radar.setNoiseFraction(0.01);
        radar.scan();
        
        
        // perform as many scans of the radar with a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        while(radar.scan() == false){
        }
        
        int[] velocity = radar.getMonsterVelocity();
        int dx = velocity[0] - 5;
        int dy = velocity[1] - 5;
        assertEquals(-3 , dx);
        assertEquals(3 , dy);
    }
        
}
