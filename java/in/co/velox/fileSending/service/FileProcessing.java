package in.co.velox.fileSending.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class FileProcessing implements FileService {

	public void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
    	 byte[] buf = new byte[(int) numBytes];
         int val = raf.read(buf);
         if (val != -1) {
             bw.write(buf);
         }
    }
    
 
    public long processData(String pathname,String byteValue,String destF) throws IOException{
    	
//    	 RandomAccessFile raf = new RandomAccessFile("D:\\ScanPlusTSS_Setup(WIN)-PROD.msi", "r");
    	 RandomAccessFile raf = new RandomAccessFile(pathname, "r");

         long sourceSize = raf.length();
         
//         long byteOfPackets = 103597280;
         long byteOfPackets =Long.parseLong(byteValue);
	       System.out.println("Inside DAO byte value"+byteOfPackets);
//         String destinationFolder = "D:\\tssSlice\\";
         String destinationFolder = destF;
         
         if (!new File(destinationFolder).exists()) {
             new File(destinationFolder).mkdirs();
         }

         long noOfPackets = 0;
         long selectedFileSize = raf.length();
         //long totalPakcketsToSend = sourceSize/;
         while (sourceSize >= byteOfPackets) {

             sourceSize = sourceSize - byteOfPackets;
             noOfPackets++;
             System.out.println(sourceSize + ":" + byteOfPackets);
         }
        
//         if (sourceSize % byteOfPackets != 0) {
//             noOfPackets++;
//         }
       
         long numSplits = noOfPackets; //from user input, extract it from args      
         long bytesPerSplit = byteOfPackets;
         long remainingBytes = selectedFileSize % byteOfPackets;
         System.out.println("Total " + noOfPackets+"  each packet of "+byteOfPackets+" bytes  with last packet " +remainingBytes );
         long maxReadBufferSize = byteOfPackets; //8KB
         for (int destIx = 1; destIx <= numSplits; destIx++) {
             BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(destinationFolder + "sptss_cache_" + destIx + ".dat"));
             if (bytesPerSplit > maxReadBufferSize) {
                 long numReads = bytesPerSplit / maxReadBufferSize;
                 long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                 for (int i = 0; i < numReads; i++) {
                     readWrite(raf, bw, maxReadBufferSize);
                 }
                 if (numRemainingRead > 0) {
                     readWrite(raf, bw, numRemainingRead);
                 }
             } else {
                 readWrite(raf, bw, bytesPerSplit);
             }
             bw.close();
         }
         if (remainingBytes > 0) {
             BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(destinationFolder + "sptss_cache_" + (numSplits + 1) + ".dat"));
             readWrite(raf, bw, remainingBytes);
             bw.close();
         }
         raf.close();
         
         
         return noOfPackets;
         
    }

}
