package com.company.dsa.tests;

import com.company.dsa.stack.ArrayStack;
import com.company.dsa.stack.LinkedStack;
import com.company.dsa.stack.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StackTests {

    private Stack<Integer> stack;

    @BeforeEach
    public void before() {
        // ToDo Select correct implementation
        //stack = new ArrayStack<>();
        stack = new LinkedStack<>();
    }

    @Test
    public void push_Should_AddElementToTheTop_When_StackEmpty() {
        // Act
        stack.push(1);
        // Assert
        Assertions.assertEquals(1, stack.peek());
    }

    @Test
    public void push_Should_AddElementToTheTop_When_StackNotEmpty() {
        // Arrange
        stack.push(1);
        // Act
        stack.push(2);
        // Assert
        Assertions.assertEquals(2, stack.peek());
    }

    @Test
    public void pop_Should_ThrowException_When_StackEmpty() {
        // Act, Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    public void pop_Should_ReturnTop_When_StackNotEmpty() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Act, Assert
        Assertions.assertEquals(3, stack.pop());
    }

    @Test
    public void peek_Should_ThrowException_When_StackEmpty() {
        // Act
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    public void peek_Should_ReturnTop_When_StackNotEmpty() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Act&&Assert
        Assertions.assertEquals(3, stack.peek());
    }

    @Test
    public void size_Should_ReturnZero_When_StackEmpty() {
        // Act&&Assert
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    public void size_Should_ReturnProperValue_When_StackNotEmpty() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Act&&Assert
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    public void isEmpty_Should_ReturnTrue_When_StackEmpty() {
        // Assert
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmpty_Should_ReturnFalse_When_StackNotEmpty() {
        // Act
        stack.push(1);
        // Assert
        Assertions.assertFalse(stack.isEmpty());
    }
}
