package com.company.dsa.tests;

import com.company.dsa.queue.ArrayQueue;
import com.company.dsa.queue.LinkedQueue;
import com.company.dsa.queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class QueueTests {

    private Queue<Integer> queue;

    @BeforeEach
    public void before() {
        // ToDo Select correct implementation
        //queue = new ArrayQueue<>();
        queue = new LinkedQueue<>();
    }

    @Test
    public void enqueue_Should_AddElementToTail_When_QueueEmpty() {
        // Act
        queue.enqueue(1);
        // Assert
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void enqueue_Should_AddElementToTail_When_QueueNotEmpty() {
        // Arrange
        queue.enqueue(1);
        // Act
        queue.enqueue(2);
        // Assert
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void dequeue_Should_ThrowException_When_QueueEmpty() {
        // Act, Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    public void dequeue_Should_RemoveHead_When_QueueNotEmpty() {
        // Arrange
        queue.enqueue(1);
        queue.enqueue(2);
        // Act, Assert
        Assertions.assertEquals(1, queue.dequeue());
    }

    @Test
    public void peek_Should_ThrowException_When_QueueEmpty() {
        // Act, Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    public void peek_Should_ReturnHead_When_QueueHasOneElement() {
        // Arrange
        queue.enqueue(1);
        // Act, Assert
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void peek_Should_ReturnHead_When_QueueHasMultipleElements() {
        // Arrange
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        // Act, Assert
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void size_Should_ReturnZero_When_QueueEmpty() {
        // Act, Assert
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    public void size_Should_ReturnProperSize_When_QueueNotEmpty() {
        // Arrange
        queue.enqueue(1);
        queue.enqueue(2);
        // Act, Assert
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void isEmpty_Should_ReturnTrue_When_QueueEmpty() {
        // Act, Assert
        Assertions.assertTrue(queue.isEmpty());
    }


    @Test
    public void isEmpty_Should_ReturnFalse_When_QueueNotEmpty() {
        // Arrange
        queue.enqueue(1);
        // Act, Assert
        Assertions.assertFalse(queue.isEmpty());
    }
}
