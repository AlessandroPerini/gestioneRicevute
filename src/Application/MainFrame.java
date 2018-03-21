
package Application;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * Frame principale dell'applicazione,
 */
public class MainFrame extends JFrame{

    public MainFrame(String t) throws HeadlessException {
    
        super(t);
        setSize(700, 560);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
