import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Window extends JFrame {
    private int WIDTH = 800;
    private int HEIGHT = 600;

    public Window() {
        setTitle("My landscape");
        setSize(WIDTH,
                HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 0, (float) HEIGHT / 2, Color.BLUE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, WIDTH, HEIGHT / 2 - 100);
        g.setColor(Color.YELLOW);
        gp = new GradientPaint(0, 0, Color.RED, 0, (float) HEIGHT / 2, Color.YELLOW);
        g2.setPaint(gp);
        g2.fillOval(WIDTH / 2 + 100, HEIGHT / 2 - 200, 100, 100);
        // Agua
        g.setColor(Color.decode("#7DBBC3"));
        g.fillRect(0, HEIGHT / 2 - 100, WIDTH, HEIGHT / 2 + 100);
        int width = 100;
        int height = 100;
        BufferedImage textureImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Dibujar un patrón de ondas para el agua
        Graphics2D gTexture = textureImage.createGraphics();
        gTexture.setColor(Color.BLUE);
        gTexture.fillRect(0, 0, width, height);
        gTexture.setColor(Color.CYAN);
        for (int i = 0; i < height; i += 20) {
            gTexture.drawArc(0, i, width, 10, 0, 180);
        }
        gTexture.dispose();
        // Crear la textura
        Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height);
        TexturePaint seaTexture = new TexturePaint(textureImage, rect);
        // Aplicar la textura
        g2.setPaint(seaTexture);
        g2.fillRect(0, HEIGHT / 2 - 100, WIDTH, HEIGHT / 2 + 100); // Esta es el área donde aplicas la textura

        //Dibujar un barco con velas
        g.setColor(Color.BLACK);
        g.fillRect(100, HEIGHT / 2 + 50, 100, 50);
        g.setColor(Color.RED);
        g.fillRect(100, HEIGHT / 2 + 50, 100, 25);
        g.setColor(Color.BLACK);
        g.fillRect(150, HEIGHT / 2 + 25, 10, 25);
        g.setColor(Color.RED);
        g.fillRect(150, HEIGHT / 2 + 25, 10, 12);
        g.setColor(Color.BLACK);
        g.fillRect(100, HEIGHT / 2 + 50, 10, 50);
        g.setColor(Color.RED);
        g.fillRect(100, HEIGHT / 2 + 50, 10, 25);

        //Dibujar isla de tierra del lado derecho
        g.setColor(Color.decode("#8B4513"));
        g.fillOval(WIDTH - 170, HEIGHT / 2, 250, 250);
        // Poner imagen kamehouse.png encima de la isla
        ImageIcon kamehouse = new ImageIcon("src/kamehouse-removebg-preview.png");
        Image image = kamehouse.getImage();
        //Imagen de goku
        g.drawImage(image, WIDTH - 170, HEIGHT / 2 - 100, 200, 250, null);
        ImageIcon goku = new ImageIcon("src/goku-removebg-preview.png");
        Image imageGoku = goku.getImage();
        g.drawImage(imageGoku, WIDTH - 170, HEIGHT / 2 + 100, 100, 100, null);
    }
}
