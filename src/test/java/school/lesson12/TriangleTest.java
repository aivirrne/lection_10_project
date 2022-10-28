package school.lesson12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private static Triangle triangle1, triangle2, triangle3, triangle4;

    @BeforeAll
    public static void setUpTriangles() {
        triangle1 = new Triangle(2, 3, 4);
        triangle2 = new Triangle(4, 3, 2);
        triangle3 = new Triangle(5, 5, 5);
        triangle4 = new Triangle(5, 5, 8);
    }

    @Test
    public void test1() {
        assertEquals(triangle1.calculateArea(), triangle2.calculateArea());
    }

    @Test
    public void test2() {
        assertTrue(triangle4.calculateArea() == 12);
    }

    @Test
    public void test3() {
        assertFalse(triangle3.calculateArea() < 10);
    }

    //To generate report run mvn site
}