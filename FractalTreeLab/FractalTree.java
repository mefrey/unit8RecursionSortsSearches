import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class FractalTree extends JFrame
{

    public FractalTree(){
        super("FractalTree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.green);
        drawBranches(g,250,400,(double)270,8);
    }

    public void drawBranches(Graphics g, int x1, int y1, double angle, int repeat) {
        if (repeat == 1) 
        {
        } 
        else 
        {
            int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * 10.0 * repeat);
            int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * 10.0 * repeat);
            g.drawLine(x1, y1, x2, y2);
            //the different angle is on purpose to make it look like it's being
            //blown to the right
            drawBranches(g, x2, y2, angle + 40, repeat - 1);
            drawBranches(g, x2, y2, angle - 20, repeat - 1);
        }
    }

    public static void main(String[] args)
    {
        new FractalTree();
    }

}