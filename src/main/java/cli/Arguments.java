package cli;

import com.google.common.base.Objects;

import java.util.Map;
import java.util.NoSuchElementException;

public class Arguments {
    private final Map<String, String> arguments;

    public Arguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }

    public int size() {
        return arguments.size();
    }

    public String get(String key){
        checkRequiredArgument(key);
        return arguments.get(key);
    }

    public String get(String key, String defaultValue) {
        String value = arguments.get(key);
        return Objects.firstNonNull(value, defaultValue);
    }

    private void checkRequiredArgument(String key){
        if(!arguments.containsKey(key)) {
            throw new NoSuchElementException("Missing required argument: " + key);
        }
    }
}
