package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class IOImpl implements IO {
	private File file;
	
	public IOImpl() {}
	
	@Override
	public void setString(String fileName) {
		this.file = new File(fileName);
	}
	
	@Override
	public BufferedImage load() {
		BufferedImage buff = null;
		try {
			buff = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return buff;
	}
	
}
