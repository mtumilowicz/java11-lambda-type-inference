import lombok.NonNull;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Created by mtumilowicz on 2018-10-08.
 */
public class LambdaLocalTypeInferenceTest {

    @Test
    public void explicit() {
        Predicate<String> isLowercase = (String str) -> str.equals(str.toLowerCase());
        
        assertTrue(isLowercase.test("abc"));
    }

    @Test
    public void implicit() {
        Predicate<String> isLowercase = str -> str.equals(str.toLowerCase());
        assertTrue(isLowercase.test("abc"));
    }

    @Test
    public void inference() {
        Predicate<String> isLowercase = (var str) -> str.equals(str.toLowerCase());
        assertTrue(isLowercase.test("abc"));
    }

    @Test
    public void type_annotation_noException() {
        Predicate<String> isLowercase = (@NonNull String str) -> str.equals(str.toLowerCase());
        assertTrue(isLowercase.test("abc"));
    }

    @Test
    public void inference_annotation_noException() {
        Predicate<String> isLowercase = (@NonNull var str) -> str.equals(str.toLowerCase());
        assertTrue(isLowercase.test("abc"));
    }

    @Test(expected = NullPointerException.class)
    public void type_annotation_exception() {
        Predicate<String> isLowercase = (@NonNull String str) -> str.equals(str.toLowerCase());
        isLowercase.test(null);
    }

    @Test(expected = NullPointerException.class)
    public void inference_annotation_exception() {
        Predicate<String> isLowercase = (@NonNull var str) -> str.equals(str.toLowerCase());
        isLowercase.test(null);
    }
}
