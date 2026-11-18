package in.co.velox.fileSending.service;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileService {
	public long processData(String pathname,String byteValue,String destF) throws IOException;
	public void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException;
}
