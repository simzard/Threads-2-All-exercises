/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg2_ex1a;

import java.io.*;
import java.net.URL;

/**
 *
 * @author simon
 */
public class ImageLoader implements Runnable {

    int byteSum;
    String url;
    
    public int getByteSum() {
        return byteSum;
    }
    
    public ImageLoader(String url) {
        this.url = url;
        
    }
    
    protected byte[] getBytesFromURL(String url) {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
            
        } catch (IOException ex){
            System.out.println(ex);
        }
        return bis.toByteArray();
        
    }

    @Override
    public void run() {
        byte[] bytes = getBytesFromURL(url);
        for (int i = 0; i < bytes.length; i++ )
            byteSum += bytes[i];
    }

}
