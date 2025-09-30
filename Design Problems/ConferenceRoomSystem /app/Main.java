package app;

import command.CommandHandler;
import service.BookingSystem;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BookingSystem sys = BookingSystem.getInstance(); // initialize singleton services
        // create command handler (uses system services via BookingSystem.getInstance())
        CommandHandler handler = new CommandHandler();

        Scanner sc;
        if (args.length > 0) sc = new Scanner(new File(args[0]));
        else sc = new Scanner(System.in);

        System.out.println("Flipkart Conference Room Booking - ready for commands. Type 'help' for syntax.");
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) break;
            try {
                handler.handle(line);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("Exiting app.");
    }
}
