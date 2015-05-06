package cli;

public interface Command {

    void execute(Arguments arguments) throws Exception;

    String getPattern();

    String getDescription();
}
