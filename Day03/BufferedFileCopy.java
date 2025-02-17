import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Change to your source file
        String bufferedDestFile = "buffered_copy.txt";
        String unbufferedDestFile = "unbuffered_copy.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDestFile);
        System.out.println("Buffered Stream Copy Time: " + bufferedTime + " nanoseconds");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, unbufferedDestFile);
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime + " nanoseconds");
    }

    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}