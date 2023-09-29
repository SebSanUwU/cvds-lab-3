package edu.eci.cvds.patterns.archetype;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            try{
                System.out.println( "Hello "+ args[0]+" "+ args[1]+"!");
            }catch (Exception e){
                System.out.println( "Hello "+ args[0]+"!");
            }
        }catch (Exception e){
            System.out.println( "Hello World!");
        }
    }
}
