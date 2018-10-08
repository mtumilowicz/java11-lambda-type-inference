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

//    @Test(expected = IllegalArgumentException.class)
//    public void inference_annotation() {
//        Predicate<String> isLowercase = (@Annotation var str) -> str.equals(str.toLowerCase());
//        isLowercase.test(null);
//    }
}
