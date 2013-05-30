/*
    ErrorMessage class
    Programmer: Ka Son Chan KaSonChan@my.unt.edu
    Class: CSCE 3650, Spring 2013
    Due: April 10, 2013
    cse01.cse.unt.edu
    This class prints error messages.
*/

public class ErrorMessage {

  public static void print (String message) {
    System . out . println ("***** Error: " + message + " *****");
    System . exit (0);
  }

  public static void print (int position, String message) {
    System . out . println ("");
    for (int i = 0; i < position; i++) 
      System . out . print (" ");
    System . out . println ("^");
    print (message);
  }

}
