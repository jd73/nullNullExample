import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import org.springframework.boot.ApplicationPid

import java.nio.charset.Charset

final String LOGGING_PATTERN = '%clr(%d{yyyy-MM-dd HH:mm:ss.SSSXX}){faint} ' + // Date
        '%clr(%-5p) ' + // Log level
        '%clr(%-40.40logger{39}){cyan} %clr(:){faint} ' + // Logger
        '%m%n%wex' // Message

if (!System.getProperty("PID")) {
    System.setProperty("PID", (new ApplicationPid()).toString())
}

// Mimic Spring Boot logging configuration.
conversionRule 'clr', org.springframework.boot.logging.logback.ColorConverter
conversionRule 'wex', org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

List appenders = ["FILE"]
String logFileDirectory = './log'
Boolean needConsoleAppender = true

appenders.add('CONSOLE')

if (needConsoleAppender) {
    appender('CONSOLE', ConsoleAppender) {
        encoder(PatternLayoutEncoder) {
            charset = Charset.forName('UTF-8')
            pattern = LOGGING_PATTERN
        }
    }
}

appender("FILE", FileAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName('UTF-8')
        pattern = LOGGING_PATTERN
    }
    file = "${logFileDirectory}/example-api.log"
}

root(INFO, appenders)
