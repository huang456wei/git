package thread;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo4 {

	public synchronized void synMethod() {
		for (int i = 0; i < 1000000; i++)
			;
	}

	public void synBlock() {
		synchronized (this) {
			for (int i = 0; i < 1000000; i++)
				;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Demo4 demo = new Demo4();

		long start, diff;
		start = System.currentTimeMillis(); // 获取当前时间(millis)
		demo.synMethod(); // 调用“synchronized方法”
		diff = System.currentTimeMillis() - start; // 获取“时间差值”
		System.out.println("synMethod() : " + diff);

		start = System.currentTimeMillis(); // 获取当前时间(millis)
		demo.synBlock(); // 调用“synchronized方法块”
		diff = System.currentTimeMillis() - start; // 获取“时间差值”
		System.out.println("synBlock()  : " + diff);

		try {
			RandomAccessFile  aFile = new RandomAccessFile("catnav.ftl", "rw");
			FileChannel inChannel=aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				System.out.println("Read " + bytesRead);
				buf.flip();

				while(buf.hasRemaining()){
					System.out.print((char) buf.get());
				}

				buf.clear();
				bytesRead = inChannel.read(buf);
			}

			aFile.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
