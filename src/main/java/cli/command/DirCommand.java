package cli.command;

import cli.Arguments;
import cli.Command;
import cli.util.FileHelper;

public class DirCommand implements Command {
    @Override
    public void execute(Arguments arguments) throws Exception {
        FileHelper.displayListOfFiles(arguments.get("directory", FileHelper.ROOT));
    }

    @Override
    public String getPattern() {
        return "ls [directory]";
    }

    @Override
    public String getDescription() {
        return "Displays a list of files and subdirectories in a directory.";
    }
}
