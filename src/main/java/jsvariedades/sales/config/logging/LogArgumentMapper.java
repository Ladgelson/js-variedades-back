package jsvariedades.sales.config.logging;

import net.logstash.logback.argument.StructuredArgument;
import org.slf4j.Logger;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static net.logstash.logback.argument.StructuredArguments.kv;
import static org.slf4j.LoggerFactory.getLogger;

public class LogArgumentMapper {
    private static final Logger LOGGER = getLogger(LogArgumentMapper.class);

    public static final String METHOD = "m";

    public static final String STAGE = "stage";

    public static final String TYPE = "type";

    public static final String FINISH = "finish";

    public static final String MASKED_VALUE = "***";

    private final List<Class> skipped = new ArrayList<>();

    private final Map<Class, LogArgumentTypeMapping> mappings = new HashMap<>();

    public Optional<StructuredArgument> map(String name, Object argument, Annotation... annotations){
        var type = nonNull(argument) ? argument.getClass() : null;

        if (skipped.contains(type)){
            LOGGER.trace("since this type is skipped, we will return empty string", kv(TYPE, type), kv(METHOD, "map"), kv(STAGE, FINISH));
            return empty();
        }

        if (Stream.of(annotations).anyMatch(LogHidden.class::isInstance)){
            return Optional.of(kv(name, MASKED_VALUE));
        }

        if (!mappings.containsKey(type)){
            LOGGER.trace("since we dont have a mapping for type, we will return toString representation", kv(TYPE, type), kv(METHOD, "map"), kv(STAGE, FINISH));
            return Optional.of(kv(name, argument));
        }

        var mapping = mappings.get(type);
        return Optional.of(kv(name, mapping.get(argument)));
    }
}
