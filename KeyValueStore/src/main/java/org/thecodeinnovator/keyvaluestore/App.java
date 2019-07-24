package org.thecodeinnovator.keyvaluestore;

import java.io.IOException;
import java.util.Scanner;

import org.thecodeinnovator.keyvaluestore.datastore.CreateKeyValue;
import org.thecodeinnovator.keyvaluestore.datastore.DeleteKeyValue;
import org.thecodeinnovator.keyvaluestore.exceptions.ExistingKeyException;

public class App {
    static void printOptions() {
        System.out.println("");
    }
    public static void main( String[] args ) throws IOException, ExistingKeyException {
        String path = new String("/Users/aravind/Desktop/freshworks/KeyValueStore/file.txt");
        Scanner in = new Scanner(System.in);
        String reply = new String("Y");
        while (reply.equals(new String("Y"))) {
            printOptions();
            int choice = in.nextInt();
            String key;
            switch (choice) {
                case 1: // create
                    System.out.println("Enter Key & Value:");
                    key = in.next();
                    String value = in.next();
                    new CreateKeyValue(path, key, value);
                    break;
                case 2: // delete
                    System.out.println("Enter Key:");
                    key = in.next();
                    new DeleteKeyValue(path, key);
                    break;
                default: System.out.println("Invalid Choice !");
            }
            reply = in.next().substring(0, 0);
        }
        in.close();
    }
}
