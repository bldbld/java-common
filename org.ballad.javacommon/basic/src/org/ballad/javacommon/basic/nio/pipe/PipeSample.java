package org.ballad.javacommon.basic.nio.pipe;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeSample {

	public static void main(String[] args) {
		Pipe pipe;
		try {
			// SINK
			pipe = Pipe.open();
			Pipe.SinkChannel sinkChannel = pipe.sink();
			String newData = "New String to write to file..." + System.currentTimeMillis();
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();
			while (buf.hasRemaining()) {
				sinkChannel.write(buf);
			}
			
			// SOURCE
			Pipe.SourceChannel sourceChannel = pipe.source();
			ByteBuffer bufsource = ByteBuffer.allocate(48);
			int bytesRead = sourceChannel.read(bufsource);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
