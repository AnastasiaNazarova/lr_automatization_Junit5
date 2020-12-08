import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DynamicCalculatorTest {
    Calculator calculator = new Calculator();
    Path addNumbersFile = Paths.get("src", "test", "resources", "addNumbers.csv");
    Path diffNumbersFile = Paths.get("src", "test", "resources", "diffNumbers.csv");
    Path mulNumbersFile = Paths.get("src", "test", "resources", "mulNumbers.csv");
    Path divNumbersFile = Paths.get("src", "test", "resources", "divNumbers.csv");
    Path xorNumbersFile = Paths.get("src", "test", "resources", "xorNumbers.csv");

    @TestFactory
    Stream<DynamicTest> addFactoryTest() throws IOException {
        Path path = this.addNumbersFile;
        Calculator calculator1 = this.calculator;
        calculator1.getClass();
        return DynamicUtils.generateTests(path, "%s plus %s must be equal to %s", calculator1::Add);
   }

    @TestFactory
    Stream<DynamicTest> subFactoryTest() throws IOException {
        Path path = this.diffNumbersFile;
        Calculator calculator1 = this.calculator;
        calculator1.getClass();
        return DynamicUtils.generateTests(path, "%s minus %s must be equal to %s", calculator1::Sub);
    }

    @TestFactory
    Stream<DynamicTest> divFactoryTest() throws IOException {
        Path path = this.divNumbersFile;
        Calculator calculator1 = this.calculator;
        calculator1.getClass();
        return DynamicUtils.generateTests(path, "%s divided by %s must be equal to %s", calculator1::Divide);
    }

    @TestFactory
    Stream<DynamicTest> mulFactoryTest() throws IOException {
        Path path = this.mulNumbersFile;
        Calculator calculator1 = this.calculator;
        calculator1.getClass();
        return DynamicUtils.generateTests(path, "%s multiply by %s must be equal to %s", calculator1::Multiple);
    }

    @TestFactory
    Stream<DynamicTest> xorFactoryTest() throws IOException {
        Path path = this.xorNumbersFile;
        Calculator calculator1 = this.calculator;
        calculator1.getClass();
        return DynamicUtils.generateTests(path, "%s xor by %s must be equal to %s", calculator1::Xor);
    }
}