package cli.command;

import cli.Arguments;
import cli.Command;
import cli.CommandSet;

public class HelpCommand implements Command {

    private final CommandSet<Command> commands;

    public HelpCommand(CommandSet<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Arguments arguments) throws Exception {
        for (Command command : commands) {
            System.out.println(String.format("%s - %s", command.getPattern(), command.getDescription()));
        }
    }

    @Override
    public String getPattern() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Prints usage information or description of a command";
    }
}
