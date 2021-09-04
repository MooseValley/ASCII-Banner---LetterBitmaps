/*
 Author: Mike O'Malley
 Source File: AsciiCommandLineBanner.java
 Description: Generates a ASCII Character Banner to the console window.
              Useful for running during batch processing so you can easily jump to
              selected sections / headings in the log files.

Example use:
java.exe -jar AsciiCommandLineBanner.jar "Moose Valley"

 *   *                                   *   *
 ** **                                   *   *
 * * *   ***    ***    ****  *****       *   *    *    *      *      *****  *   *
 *   *  *   *  *   *  *      *           *   *   * *   *      *      *      *   *
 *   *  *   *  *   *   ***   ***         *   *  *****  *      *      ***     * *
 *   *  *   *  *   *      *  *            * *   *   *  *      *      *        *
 *   *   ***    ***   ****   *****         *    *   *  *****  *****  *****    *


Ammendment History
Ver   Date        Author    Details
----- ----------- --------  ----------------------------------------------------
0.100 04-Sep-2021 Mike O    Created.


*** DONE for Next Release:


*/
public class AsciiCommandLineBanner
{
   public static void main (String[] args)
   {
      for (int k = 0; k < args.length; k++)
      {
         System.out.println (AsciiCharacterBitmaps.toString (args[k]) );
      }
   }
} // public class ASCIICommandLineBanner