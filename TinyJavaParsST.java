/*
    TinyJavaParsST.java
    Programmer: Ka Son Chan KaSonChan@my.unt.edu
    Class: CSCE 3650, Spring 2013
    Due: April 10, 2013
    cse01.cse.unt.edu
    This program is a parser for TinyJava which contsructs the symbol table from the source program declarations.
*/

import java.util.*;
import java_cup . runtime . *;

public class TinyJavaParsST {

  public static void main (String args []) throws java.io.IOException {
    System . out . println ("Source Program");
    System . out . println ("--------------");
    System . out . println ();

    try 
    {
      SymbolFactory symbolFactory = new ComplexSymbolFactory ();
      TinyJavaParserST parser = new TinyJavaParserST (new TinyJavaLexer (System . in, symbolFactory));
      java_cup .runtime . Symbol parserValue = parser . parse ();

      System . out . println();
      System . out . println("##### SYMBOL TABLE #####");

      SymbolTable classes = new SymbolTable();
      classes = (SymbolTable) parserValue.value;
      classes . PrintTables();
    }
    catch (Exception e) {
      System . out . println ("Error in invoking parser/lexer");
    }
  }
}
