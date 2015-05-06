package cli;

import cli.util.FileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI<T extends Command> {
    private BufferedReader reader;
    private CommandSet<T> commands;

    public CLI(Iterable<T> commands) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.commands = new CommandSet<T>(commands);
    }

    public void startInteractiveMode() throws IOException {
        while (true) {
            System.out.print(FileHelper.getCurrentDirectory() + ">");
            String line = reader.readLine();

            if (line == null) {
                System.out.println();
                break;
            }

            if (line.length() > 0) {
                String command = line.trim();
                execute(command);
                System.out.println();
            }
        }
    }

    public void execute(String input) {
        try {
            CommandMatch match = commands.findMatch(input);
            match.getCommand().execute(match.getArguments());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
