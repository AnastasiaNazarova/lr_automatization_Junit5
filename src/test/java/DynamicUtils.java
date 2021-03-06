
import org.junit.jupiter.api.DynamicTest;
        import org.junit.jupiter.api.function.Executable;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.Optional;
        import java.util.stream.Stream;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertThrows;
        import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicUtils {

    private DynamicUtils() {
    }

    public static Stream<DynamicTest> generateTests(Path csvFile, String format,
                                                    BiFunction<String, String, String> testMethod) throws IOException {
        return Files.lines(csvFile)
                .skip(1) // skip header
                .map(DynamicUtils::split)
                .map(nums -> {
                    String first = nums[0];
                    String  second = nums[1];

                    if (nums[2] != null) {
                        String expectedResult = nums[2];
                        String testDescription = String.format(format, first, second, expectedResult);
                        Executable doAssertion = () -> assertEquals(
                                expectedResult,
                                testMethod.apply(first, second),
                                testDescription
                        );
                        return dynamicTest(testDescription, doAssertion);
                    } else {
                        String errMsg = nums[2];
                        String testDescription = String.format(format, first, second, errMsg);
                        Executable doAssertion = () -> assertThrows(
                                Exception.class,
                                () -> testMethod.apply(first, second)
                        );
                        return dynamicTest(testDescription, doAssertion);
                    }
                });
    }

    private static String[] split(String line) {
        return line.split(",");
    }

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u) throws Exception;
    }


}
