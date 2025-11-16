/*

Copyright 2025 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e12;

/**
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification. Provide also the RI and AF.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).

  /** The elements of the queque */
  private int[] elements;

  /** The index of the first queque element in {@link elements} 
   * (-1 if the queque is empty)
  */
  private int top;

  /** The index of the next free position in {@link elements} 
   * (0 if the queque is empty)
  */
  private int bottom;

  /**
   * Creates a new bounded queue with the given capacity.
   *
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if (capacity <= 0) throw new IllegalArgumentException("Capacity cn't be negative");
    elements = new int[capacity];
    top = -1;
    bottom = 0;
  }

  /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.
   */
  public void enqueue(int x) {
    if (bottom == top) throw new IllegalStateException("Queque is full");
    if (top == -1) top = 0;
    elements[bottom] = x;
    bottom = (bottom + 1) % elements.length;
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() {
    if (top == -1) throw new IllegalStateException("Queque is empty");
    int x = elements[top];
    top = (top + 1) % elements.length;
    if (top == bottom) {
      top = -1;
      bottom = 0;
    } 
    return x;
  }

  @Override
  public String toString() {
    if (top == -1) return "BoundedIntQueue: []";
    StringBuilder sb = new StringBuilder("BoundedQueue: [");
    int i = top, n = 0;
    while (n < ((bottom - top + elements.length) % elements.length) - 1) {
      sb.append(elements[i] + ", ");
      i = (i + 1) % elements.length;
      n++;
    }
    sb.append( elements[i] + " ]");
    return sb.toString();
  }
}
