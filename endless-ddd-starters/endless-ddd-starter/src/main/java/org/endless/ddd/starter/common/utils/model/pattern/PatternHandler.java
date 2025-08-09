package org.endless.ddd.starter.common.utils.model.pattern;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PatternHandler
 * <p>
 * create 2025/08/09 03:42
 * <p>
 * update 2025/08/09 03:42
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
public final class PatternHandler {

    public final String index;

    public final Pattern pattern;

    public final Function<Matcher, String> handler;

    public PatternHandler(String index, String regex, Function<Matcher, String> handler) {
        this.index = index;
        this.pattern = Pattern.compile(regex);
        this.handler = handler;
    }
}
