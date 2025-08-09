package org.endless.ddd.starter.common.utils.exception.database.recognizer;

import lombok.Builder;
import org.endless.ddd.starter.common.utils.model.pattern.PatternHandler;

import java.util.List;
import java.util.function.Predicate;

/**
 * DatabaseRecognizer
 * <p>
 * create 2025/08/09 03:40
 * <p>
 * update 2025/08/09 03:40
 *
 * @author Deng Haozhi
 * @since 1.0.0
 */
@Builder
public record DatabaseRecognizer(Predicate<String> recognizer, List<PatternHandler> patterns) {

}
