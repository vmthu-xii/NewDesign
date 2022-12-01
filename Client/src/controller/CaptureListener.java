package controller;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Client;

import view.features.*;

public class CaptureListener implements ActionListener, MouseListener{
	
	public BufferedImage image = null;
	public int count = 0;
	
	private CaptureDesign captureDesign;
	
	public CaptureListener(CaptureDesign captureDesign)
	{
		this.captureDesign = captureDesign;
	}
	
	public class mouseClicked {
		public mouseClicked(MouseEvent e) {
			JFrame jf=new JFrame("Screenshot");
			jf.setVisible(true);
			jf.setSize(new Dimension(200,70));
			jf.setVisible(true);
			jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Client.client == null) {
			JOptionPane.showMessageDialog(null, "Not connected to the server");
			return;
		}
		
		String click = e.getActionCommand();
		
		if ("CAPTURE".equals(click)){
			try {
				Client.out.write(click);
				Client.out.newLine();
				Client.out.flush();
			} catch (IOException e2) {
				e2.printStackTrace();
			}			
			try {
				image = ImageIO.read(Client.client.getInputStream());
				if(image != null) {
					int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB
	                        : image.getType();
					BufferedImage rimg = resizeImage(image, type, 520, 280);
		            ImageIcon icon = new ImageIcon(rimg);
		            this.captureDesign.lbImage.setIcon(icon);
		            JOptionPane.showMessageDialog(null, "Screenshot successfully!");
				}else {
					//System.out.println("[capture] receive: " + image); // msg from client
					
					JOptionPane.showMessageDialog(null, "Screenshot fail");
				}
			}catch(IOException e2){
				
			}
		}
		
		else if ("SAVE".equals(click)) {
			if(image == null) {
				JOptionPane.showMessageDialog(null, "No pictures to save!");
			}
			else {
				count += 1;
				try {
					ImageIO.write(image , "png", new File("D:\\Screenshot\\" + count + ".png"));
					JOptionPane.showMessageDialog(null, "Saved successfully!\nYou can find " + count + ".png in D:\\Screenshot");
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "Create D:\\Screenshot to save the image!");
					e2.printStackTrace();
				}
			}
				
		}
	}
		
		
	private static BufferedImage resizeImage(BufferedImage originalImage, int type,Integer img_width, Integer img_height)
	{
		BufferedImage resizedImage = new BufferedImage(img_width, img_height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, img_width, img_height, null);
		g.dispose();
		return resizedImage;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO click vao anh 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
}
