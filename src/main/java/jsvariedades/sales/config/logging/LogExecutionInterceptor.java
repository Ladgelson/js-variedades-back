package jsvariedades.sales.config.logging;

import net.logstash.logback.argument.StructuredArgument;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static net.logstash.logback.argument.StructuredArguments.kv;
import static org.slf4j.LoggerFactory.getLogger;

@Aspect
@Component
public class LogExecutionInterceptor {

    public static final String OPEN_BRACE = "{";

    public static final String CLOSE_BRACE = "}";

    public static final String OPEN_CLOSE_BRACES = OPEN_BRACE + CLOSE_BRACE;

    public static final String SPACE = " ";

    private static final String LOG_ARGUMENT_REPLACEMENT = OPEN_CLOSE_BRACES + SPACE;

    public static final String STAGE = "stage";

    public static final String METHOD = "m";

    public static final String START = "start";

    public static final String FINISH = "finish";

    @Autowired
    private LogArgumentMapper mapper;

    @Around("@annotation(execution)")
    public Object proceed(ProceedingJoinPoint joinPoint, LogExecution execution) throws Throwable {
        var logger = getLogger(joinPoint.getTarget().getClass());

        var arguments = buildMessageArguments(joinPoint);

        log(logger, execution.value(), Stream.concat(arguments.stream(), Stream.of(kv(STAGE, START))).toArray());

        var result = joinPoint.proceed();

        log(logger, execution.value(), Stream.concat(arguments.stream(), Stream.of(kv(STAGE, FINISH))).toArray());

        return result;
    }

    private List<StructuredArgument> buildMessageArguments(ProceedingJoinPoint joinPoint) {
        var result = new ArrayList<StructuredArgument>();

        result.add(kv(METHOD, joinPoint.getSignature().getName()));
        result.addAll(buildMessageArgumentsByParameters(joinPoint));

        return result;
    }

    private List<StructuredArgument> buildMessageArgumentsByParameters(ProceedingJoinPoint joinPoint){
        if (!(joinPoint.getSignature() instanceof MethodSignature)){
            return Collections.emptyList();
        }

        var signature = (MethodSignature) joinPoint.getSignature();

        var result = new ArrayList<StructuredArgument>();

        var annotations = signature.getMethod().getParameterAnnotations();

        for (var i = 0; i < signature.getParameterNames().length; i++){
            var name = signature.getParameterNames()[i];
            var argument = joinPoint.getArgs()[i];

            mapper.map(name, argument, annotations[i]).ifPresent(result::add);
        }

        return result;
    }

    private void log(Logger logger, Level level, Object... args) {
        var template = templateReplacement(args.length);

        switch (level) {
            case DEBUG:
                logger.debug(template, args);
                break;
            case ERROR:
                logger.error(template, args);
                break;
            case INFO:
                logger.info(template, args);
                break;
            case TRACE:
                logger.trace(template, args);
                break;
            case WARN:
                logger.warn(template, args);
                break;
        }
    }

    public static String templateReplacement(int quantity){
        return LOG_ARGUMENT_REPLACEMENT.repeat(quantity).trim();
    }
}
