import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    String getMsg;
    int getTable;

    public Main() {
        getMsg = JOptionPane.showInputDialog("Add up or Multiply(A/M):").toUpperCase();
        getTable = Integer.parseInt(JOptionPane.showInputDialog("Table size(N x N):"));
    }

    @Override
    public void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        int cellWidth = width/getTable;
        int cellHeight = height/getTable;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);

        for (int i = 1; i <= getTable; i++) {
            for (int j = 1; j <= getTable; j++) {

                g.setColor(Color.white);

                if (i == 1 || j == 1) {
                    g.setColor(Color.gray);
                    g.fillRect(x , y, cellWidth, cellHeight);

                    g.setColor(Color.white);
                    g.drawRect(x , y, cellWidth, cellHeight);

                    g.drawString(""+(j*i-1),x+10,y+20);
                } else {
                    if (getMsg.equals("M")) {
                        g.drawRect(x , y, cellWidth, cellHeight);
                        g.drawString(""+((j-1)*(i-1)),x+10,y+20);
                    } else {
                        g.drawRect(x , y, cellWidth, cellHeight);
                        g.drawString(""+((j-1)+(i-1)),x+10,y+20);
                    }
                }
                x += cellWidth;
            }
            x = 0;
            y += cellHeight;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}