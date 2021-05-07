import java.awt. *;

import javax.swing. *;

public class Window {

        public static final int rasterGroesse = 30;
        public static final int breiteFenster = rasterGroesse * 30;
	public static final int hoeheFenster = rasterGroesse * 30;
	public Window(int width, int height, String title) {
		JFrame frame = new JFrame(title);
		//frame.add(game);
		//Fenster init
		frame.setMinimumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
                
		//Fenster bearbeiten
		frame. getContentPane (). setBackground (new Color (99, 9, 92));
		
		Insets i = frame.getInsets();
                frame. setSize (breiteFenster, hoeheFenster + i.top);
		JComponent hintergrund = new JComponent ()
                {
                     /**
                     * Zeichnet das Hintergrundmuster.
                     */
                    public void paintComponent (Graphics g)
                    {
                        g. setColor (Color. white);
                        for (int i = 1; i <= hoeheFenster / (rasterGroesse * 2); i++)
                        {
                            g. drawLine (0, hoeheFenster / 2 + i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 + i * rasterGroesse);
                            g. drawLine (0, hoeheFenster / 2 - i * rasterGroesse, breiteFenster - 1, hoeheFenster / 2 - i * rasterGroesse);
                        }
                        for (int i = 1; i <= breiteFenster / (rasterGroesse * 2); i++)
                        {
                            g. drawLine (breiteFenster / 2 + i * rasterGroesse, 0, breiteFenster / 2 + i * rasterGroesse, hoeheFenster - 1);
                            g. drawLine (breiteFenster / 2 - i * rasterGroesse, 0, breiteFenster / 2 - i * rasterGroesse, hoeheFenster - 1);
                        }
                        g. setColor (Color. white);
                        g. drawLine (0, hoeheFenster / 2, breiteFenster - 1, hoeheFenster / 2);
                        g. drawLine (breiteFenster / 2, 0, breiteFenster / 2, hoeheFenster - 1);
                    }
                };
                hintergrund. setVisible (true);
                hintergrund. setSize (breiteFenster, hoeheFenster);
                hintergrund. setLocation (0, 0);
                frame. add (hintergrund);
            }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Game game = new Game();
		new Window(breiteFenster, hoeheFenster, "Labyrinth");
	}

}