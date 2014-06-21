package XmlSerlvet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkcode
 */
@WebServlet("/checkcode")
public class checkcode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 120;
		int height = 30;
		//1. create a picture in cache
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2. background color
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);
		//3. border
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0,0,width-1,height-1);
		//4. write content of checkcode
		
		graphics.setFont(new Font("Arial",Font.BOLD,17));
		graphics.setColor(Color.RED);
		String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		int x = 10;
		int y = 20;
		Graphics2D graphics2d = (Graphics2D) graphics;
		for(int i = 0; i < 4; i++){
			//rotate
			
			double angle = random.nextInt(60) - 30;
			double theta = angle * 2 * Math.PI / 360;
			int index = random.nextInt(content.length());
			char letter = content.charAt(index);
			graphics2d.rotate(theta, x, y);
			graphics.drawString(letter+"", x, y);
			graphics2d.rotate(-theta,x, y);
			x += 30;
		}
		int x1,x2,y1,y2;
		graphics.setColor(Color.lightGray);
		for(int i = 0; i < 20;i++){
			x1 = random.nextInt(width);
			x2 = random.nextInt(width);
			y1 = random.nextInt(height);
			y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
