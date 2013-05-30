/*
    SymbolTable.java
    Programmer: Ka Son Chan KaSonChan@my.unt.edu
    Class: CSCE 3650, Spring 2013
    Due: April 10, 2013
    cse01.cse.unt.edu
*/

import java.util.*;

public class SymbolTable
{
    // SymbolTableEntry class
    private class SymbolTableEntry 
    {
        private String id;
        private String envName;
        private String category;
        private String type;
        private SymbolTableEntry nextEntry;
        private SymbolTableEntry nextEnv;

        public SymbolTableEntry()
        {
            id = "";
            envName = "";
            category = "";
            type = "";
            nextEntry = null;
            nextEnv = null;
        }

        // Constructor of SymbolTableEntry class
        public SymbolTableEntry(String iid, String ienvName, String icategory, String itype)
        {
            id = iid;
            envName = ienvName;
            category = icategory;
            type = itype;
            nextEntry = null;
            nextEnv = null;
        }
    }

    private SymbolTableEntry envHead;

    // Constructor of SymbolTable class
    public SymbolTable()
    {
        envHead = null;
    }

    public void InsertEnv(String envName)
    {
        SymbolTableEntry tempEntry = envHead;
        SymbolTableEntry newEntry = new SymbolTableEntry("", envName, "", "");
        
        // If table is empty
        if(envHead == null)
        {
            envHead = newEntry;
        }
        // else if the table is not empty
        else
        {
            while(tempEntry.nextEnv != null)
            {
                if((tempEntry.envName).equals(envName))
                        return;
                tempEntry = tempEntry.nextEnv;
            }

            tempEntry.nextEnv = newEntry;
        }
    }

    public void InsertEntry(String id, String envName, String category, String type)
    {
        SymbolTableEntry tempEntry = envHead;
        SymbolTableEntry currEntry = envHead;
        SymbolTableEntry newEntry = new SymbolTableEntry(id, envName, category, type);

        // If table is empty
        if(envHead == null)
        {
            return;
        }
        // Else if table is not empty
        else
        {
            while(tempEntry != null)
            {
                if((tempEntry.envName).equals(envName))
                {
                    // If env is empty
                    if(tempEntry.nextEntry == null)
                        tempEntry.nextEntry = newEntry;         
                    // Else if env is not empty
                    else
                    {
                        currEntry = tempEntry.nextEntry;

                        while(currEntry.nextEntry != null)
                        {
                            currEntry = currEntry.nextEntry;
                        }
                        
                        currEntry.nextEntry = newEntry;
                    }
                }

                tempEntry = tempEntry.nextEnv;
            }
        }
    }

    public void PrintHeader(String blockName)
    {
        // Print the header
        System . out . println ("");
        System . out . println ("Identifier Table for " + blockName);
        System . out . print ("---------------------");        
        for (int i = 0; i < blockName . length (); i++) 
            System . out . print ("-");
        System . out . println ("");
        System . out . println ("");

        System . out . print ("Id");
        System . out . print ("\t\t");
        System . out . print ("Category");
        System . out . print ("\t\t");
        System . out . println ("Type");

        System . out . print ("--");
        System . out . print ("\t\t");
        System . out . print ("--------");
        System . out . print ("\t\t");
        System . out . println ("----");
    }

    public void PrintTables()
    {
        SymbolTableEntry tempEntry = envHead;
        SymbolTableEntry currEntry = envHead;

        // If envhead is empty
        if(envHead == null)
        {
            ;
        }
        // Else if envhead is not empty
        else
        {            
            while(tempEntry != null)
            {
                PrintHeader(tempEntry.envName);

                currEntry = tempEntry.nextEntry;

                if(currEntry == null)
                    ; // System.out.println(tempEntry.envName + " is empty!");
                else
                {
                    while(currEntry != null)
                    {
                        System.out.println(currEntry.id + "\t\t" + currEntry.category + "\t\t" + currEntry.type);
                        
                        currEntry = currEntry.nextEntry;
                    }
                    currEntry = tempEntry.nextEntry;
                }
                tempEntry = tempEntry.nextEnv;
            }
        }
    }

    public Boolean FoundEntry(String id)
    {
        SymbolTableEntry tempEntry = envHead;
        SymbolTableEntry currEntry = envHead;

        // If envhead is empty
        if(envHead == null)
        {
            return false;
            // System.out.println("Table is emtpy!");
        }
        // Else if envhead is not empty
        else
        {            
            while(tempEntry != null)
            {
                currEntry = tempEntry.nextEntry;

                if(currEntry == null)
                    ;
                else
                {
                    while(currEntry != null)
                    {
                        if((currEntry.id).equals(id))
                            return true;                     
                        currEntry = currEntry.nextEntry;
                    }
                    currEntry = tempEntry.nextEntry;
                }

                tempEntry = tempEntry.nextEnv;
            }
        }

        return false;
    }
}