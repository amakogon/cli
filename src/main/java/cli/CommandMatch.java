package cli;

import com.google.common.collect.ImmutableMap;

public class CommandMatch {
    private final Command command;
    private final String input;

    public CommandMatch(Command command, String input) {
        this.command = command;
        this.input = input;
    }

    public Command getCommand() {
        return command;
    }

    public String getInput() {
        return input;
    }

    public Arguments getArguments() {
        return parseInput(input, command.getPattern());
    }

    private Arguments parseInput(String input, String pattern) {
        ImmutableMap.Builder<String, String> args = ImmutableMap.builder();
        String[] inputWords = input.split(" ");
        String[] patternWords = pattern.split(" ");
        for (int i = 0; i < inputWords.length && i < patternWords.length; i++) {
            if (!inputWords[i].equals(patternWords[i])) {
                args.put(patternWords[i].substring(1, patternWords[i].length() - 1), inputWords[i]);
            }
        }

        return new Arguments(args.build());
    }
}
