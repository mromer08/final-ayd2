package com.usac.ayd2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FinalExampleTest {
    private static final String INPUT_DATA = "hola,mundo,java";
    private static final String USER_NAME = "Manuel";
    private static final String USER_EMAIL = "manuel@test.com";
    
    private static final String NAME_VALIDATION_ERROR = "Name cannot be empty";
    private static final String EMAIL_VALIDATION_ERROR = "Invalid email";

    private static final String UNKNOW_SHAPE = "Shape";
    private static final String CIRCLE_SHAPE = "circle";
    private static final String RECTANGLE_SHAPE = "rectangle";
    private static final String TRIANGLE_SHAPE = "triangle";

    private static final double DIMENSION_1 = 1;
    private static final double DIMENSION_2 = 2;

    private static final double CIRCLE_AREA = Math.PI;
    private static final double RECTANGLE_AREA = DIMENSION_1 * DIMENSION_2;
    private static final double TRIANGLE_AREA = DIMENSION_1 * DIMENSION_2 / 2;
    
    @Test
    void processDataShouldPrintResult() {
        FinalExample finalExample = new FinalExample();
        finalExample.processData(INPUT_DATA);
    }

    @Test
    void createUserShouldReturnUserCreated() {
        FinalExample finalExample = new FinalExample();
        String userCreated = finalExample.createUser(USER_NAME, USER_EMAIL, null, null, null, null);
        assertEquals("User created: " + USER_NAME, userCreated);
    }

    @Test
    void createUserShouldApplyNameValidations(){
        FinalExample finalExample = new FinalExample();
        String userCreatedWithNullName = finalExample.createUser(null, null, null, null, null, null);
        String userCreatedWithEmptyName = finalExample.createUser("", null, null, null, null, null);

        assertAll(
            () -> assertEquals(NAME_VALIDATION_ERROR, userCreatedWithNullName),
            () -> assertEquals(NAME_VALIDATION_ERROR, userCreatedWithEmptyName)
        );
    }

    @Test
    void createUserShouldApplyEmailValidations(){
        FinalExample finalExample = new FinalExample();
        String userCreatedWithNullEmail = finalExample.createUser(USER_NAME, null, null, null, null, null);
        String userCreatedWithEmptyEmail = finalExample.createUser(USER_NAME, "", null, null, null, null);

        assertAll(
            () -> assertEquals(EMAIL_VALIDATION_ERROR, userCreatedWithNullEmail),
            () -> assertEquals(EMAIL_VALIDATION_ERROR, userCreatedWithEmptyEmail)
        );
    }
    
    @Test
    void calculateAreaShouldReturnErrorWhenUnknowShape() {
        FinalExample finalExample = new FinalExample();
        

        assertThrows(IllegalArgumentException.class,
                    () -> finalExample.calculateArea(UNKNOW_SHAPE, null));
    }

    @Test
    void calculateAreaShouldReturnShapeAreaCorrectly() {
        FinalExample finalExample = new FinalExample();
        double circleArea = finalExample.calculateArea(CIRCLE_SHAPE,DIMENSION_1);
        double rectangleArea = finalExample.calculateArea(RECTANGLE_SHAPE, DIMENSION_1, DIMENSION_2);
        double triangleArea = finalExample.calculateArea(TRIANGLE_SHAPE,DIMENSION_1, DIMENSION_2);

        assertAll(
            () -> assertEquals(CIRCLE_AREA, circleArea),
            () -> assertEquals(RECTANGLE_AREA, rectangleArea),
            () -> assertEquals(TRIANGLE_AREA, triangleArea)
        );
        
    }
}
