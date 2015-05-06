package cli.command;

import cli.Arguments;
import cli.Command;

public class ExitCommand implements Command{
    @Override
    public void execute(Arguments arguments) throws Exception {
        System.exit(0);
    }

    @Override
    public String getPattern() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Exits the command line interface";
    }
}
