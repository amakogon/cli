package cli;

import com.google.common.collect.ImmutableList;

import java.util.Iterator;
import java.util.List;

public class CommandSet<T extends Command> implements Iterable<T>{
    private final List<T> commands;

    public CommandSet(Iterable<T>  commands) {
        this.commands = ImmutableList.copyOf(commands);
    }

    public CommandMatch findMatch(String input){
        for(Command command : commands) {
            String pattern = getMatchPattern(command.getPattern());
            if (input.matches(pattern)) {
                return new CommandMatch(command, input);
            }
        }
        throw new IllegalArgumentException(String.format("Unknown command - %s", input));
    }

    private String getMatchPattern(String pattern) {
        String mandatoryPart = pattern.replaceAll("(\\s+?)\\[.+?\\]", "($1.+?(\\\\s|\\$))*");
        return mandatoryPart.replaceAll("<.+?>", ".+?");
    }

    @Override
    public Iterator<T> iterator() {
        return commands.iterator();
    }
}
