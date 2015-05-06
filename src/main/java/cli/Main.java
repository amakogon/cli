package cli;

import cli.command.HelpCommand;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("cli.xml");

        CommandSet<Command> commandSet = (CommandSet<Command>) context.getBean("commandSet");
        HelpCommand helpCommand = (HelpCommand) context.getBean("helpCommand");

        CLI<Command> cli = new CLI<Command>(Iterables.concat(ImmutableList.of(helpCommand), commandSet));
        cli.startInteractiveMode();
    }
}
