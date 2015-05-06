package cli.command;

import cli.Arguments;
import cli.Command;

public class EchoCommand implements Command {
    @Override
    public void execute(Arguments arguments) throws Exception {
        System.out.println(arguments.get("some-input"));
    }

    @Override
    public String getPattern() {
        return "echo <some-input>";
    }

    @Override
    public String getDescription() {
        return "Echoes whatever is passed";
    }
}
