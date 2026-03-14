package br.com.ajf.game.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

/**
 * The Class ResourceLoader.
 */
public final class ResourceLoader
{
    
	
    /**
     * Instantiates a new resource loader.
     */
    public ResourceLoader()
	{
		super();
	}

    /**
     * Load.
     *
     * @param filepath the filepath
     * @return the input stream
     */
    public InputStream load(final String filepath)
    {
        try
        {
            if(!(filepath == null || filepath.isEmpty()))
            {
            	return new FileInputStream(filepath);
            }
        }
        catch (Exception exception)
        {
           exception.printStackTrace();
        }
    return null;
    }
    /**
     * Load.
     *
     * @param clazz the clazz
     * @param respath the respath
     * @return the input stream
     */
    public InputStream load(final Class<?> clazz,final String respath)
    {
        try
        {
            if(!(respath == null || respath.isEmpty()))
            {
                return clazz.getResourceAsStream(respath);
            }
        }
        catch (Exception exception)
        {
           exception.printStackTrace();
        }
    return null;
    }
    
	/**
     * Load.
     *
     * @param clazz the clazz
     * @param filepath the filepath
     * @param respath the respath
     * @return the input stream
     */
    public InputStream load(final Class<?> clazz,final String filepath,final String respath)
    {
        try
        {
            if(!(respath == null || respath.isEmpty()))
            {
                return clazz.getResourceAsStream(respath);
            }
            else
            {
            	return new FileInputStream(filepath);
            }
        }
        catch (Exception exception)
        {
           exception.printStackTrace();
        }
    return null;
    }
    
    /**
     * Read.
     *
     * @param filename the filename
     * @return the string
     */
    public String read(final String filename)
   	{
   	   final StringBuilder text = new StringBuilder();
   	   
   	   try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
   	   { 
   	      while(reader.ready())
   	      {
   	           text.append(reader.readLine()).append("\n");
   	      }   
   	      
   	      reader.close();
   	   }
   	   catch(Exception e)
   	   { 
   		   e.printStackTrace();
   	   }
   	   return text.toString();
   	}	
}