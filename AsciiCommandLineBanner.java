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
0.101 05-Sep-2021 Mike O    Add support for truncate.  Add Usage info if missing
                            or incorrect parameters.


*** DONE for Next Release:


*/
public class AsciiCommandLineBanner
{
   public final static String USAGE_HELP =
    //         1         2         3         4         5         6         7         8
    //12345678901234567890123456789012345678901234567890123456789012345678901234567890

      "ASCII Command Line Banner v0.02" + "\n" +
      "Usage:" + "\n" +
      "java -jar AsciiCommandLineBanner.jar [/t:nn] [/w:nn] string1 [string2] [....]"   + "\n" +
      "/t:nn or /T:nn. eg. /T:80 - truncates the output at 80 chars."                   + "\n" +
      "/w:nn or /W:nn. eg. /W:80 - word wraps the output at 80 chars."                  + "\n" +
      "/ or \\ can be used as parameter prefixes."                                      + "\n" +
      "If /w is used then /t cannot be used, and vica versa."                           + "\n" +
      ""                                                                                + "\n" +
      "Examples:"                                                                       + "\n" +
      ""                                                                                + "\n" +
      "java -jar AsciiCommandLineBanner.jar Moose's Sofware Valley"                     + "\n" +
      "-> displays \"Moose's\" banner, and then below this \"Sofware\" banner, and "    + "\n" +
      "   then a \"Valley\" banner below that."                                         + "\n" +
      ""                                                                                + "\n" +
      "java -jar AsciiCommandLineBanner.jar \"Moose's Sofware Valley\""                 + "\n" +
      "-> displays \"Moose's Sofware Valley\" banner.  If output device has limited "   + "\n" +
      "   width, then banner will wrap horribly."                                       + "\n" +
      ""                                                                                + "\n" +
      "java -jar AsciiCommandLineBanner.jar /t:80 \"Moose's Sofware Valley\""           + "\n" +
      "-> displays \"Moose's Sofware Valley\" banner and truncates output at 80 chars." + "\n" +
      ""                                                                                + "\n" +
      "java -jar AsciiCommandLineBanner.jar /w:80 \"Moose's Sofware Valley\""           + "\n" +
      "-> displays \"Moose's Sofware Valley\" banner and word wrap output at 80 chars." + "\n";


   public static void main (String[] args)
   {
      boolean truncate = false;
      boolean wordwrap = false;
      int truncateCol  = 0;
      int workwrapCol  = 0;

      args = new String[1];
      args[0] = "Moose's Software Valey";

      if (args.length == 0)
      {
         System.out.println (USAGE_HELP);
      }

      for (int k = 0; k < args.length; k++)
      {
         if ((args[k].toUpperCase().startsWith ("\\T") == true) || (args[k].toUpperCase().startsWith ("/T") == true) )
         {
            //String paramStr   = args[k].replace (":", " ");
            String[] strArray = args[k].split(":");

            if (strArray.length == 2)
            {
               try
               {
                  truncateCol = Integer.parseInt (strArray[1]);
               }
               catch (IllegalArgumentException err)
               {
                  System.out.println (err.toString() );
                  System.out.println ("ERROR: illegal usage.");
                  System.out.println (USAGE_HELP);
               }
            }
         }
      }

      for (int k = 0; k < args.length; k++)
      {
         if ((args[k].startsWith ("\\") == false) && (args[k].startsWith ("/") == false) )
            System.out.println (AsciiCharacterBitmaps.toString (args[k], 80) );
      }
   }
} // public class ASCIICommandLineBanner