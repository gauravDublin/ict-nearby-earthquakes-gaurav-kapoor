package info.earthquake.helper;

import info.earthquake.config.ConsoleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@PropertySource("classpath:log4j.properties")
public class ConsoleService {

    private final String propertyNewLine = System.lineSeparator();
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleConfig consoleConfig;

    @Autowired
    public ConsoleService(ConsoleConfig consoleConfig) {
        this.consoleConfig = consoleConfig;
    }

    public void printWelcomeMessage() {
        printMessageToConsole(consoleConfig.getWelcomeMessage() + propertyNewLine);
    }

    public void printWaitingMessage() {
        printMessageToConsole(consoleConfig.getWaitingMessage() + propertyNewLine);
    }
    /**
     *
     * @param message to be printed using System.out.println
     */
    public void printMessageToConsole(String message) {
        System.out.println(message);
    }

    public Double isDoubleEntered() {
        String doubleString = "";
        Double doubleValue = 0.0;

        boolean correctChoiceMade = true;
        while(correctChoiceMade){
            doubleString = scanner.next();
            try {
                doubleValue = Double.valueOf(doubleString);
                correctChoiceMade = false;
            } catch(NumberFormatException numberException) {
                printMessageToConsole(consoleConfig.getPropInvalidDouble());
            }
        }
        return doubleValue;
    }
}
