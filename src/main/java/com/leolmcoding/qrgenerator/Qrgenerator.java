package com.leolmcoding.qrgenerator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Qrgenerator {

	    // Function to create the QR code
	    public static void createQR(String data, String path,
	                                String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap,
	                                int height, int width)
	        throws WriterException, IOException
	    {
	 
	        BitMatrix matrix = new MultiFormatWriter().encode(
	            new String(data.getBytes(charset), charset),
	            BarcodeFormat.QR_CODE, width, height);
	        Path p = FileSystems.getDefault().getPath(path);
	        
	        MatrixToImageWriter.writeToPath(matrix,
	            path.substring(path.lastIndexOf('.') + 1),
	            p);
	    }
	   
	    // Driver code
	    public static void main(String[] args)
	        throws WriterException, IOException,
	               NotFoundException
	    {
	    	//this code is based on g4g code,but its updated to run on new vesion of zxing!
	    	//https://www.geeksforgeeks.org/how-to-generate-and-read-qr-code-with-java-using-zxing-library/?ref=gcse
	        // The data that the QR code will contain
	        String data = "https://www.google.com";
	        // The path where the image will get saved
	        String path = "demo.png";
	 
	        // Encoding charset
	        String charset = "UTF-8";
	 
	        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
	            = new HashMap<EncodeHintType,
	                          ErrorCorrectionLevel>();
	 
	        hashMap.put(EncodeHintType.ERROR_CORRECTION,
	                    ErrorCorrectionLevel.L);
	 
	        // Create the QR code and save
	        // in the specified folder
	        // as a jpg file
	        createQR(data, path, charset, hashMap, 200, 200);
	        System.out.println("QR Code Generated!!! ");
	    }

}
