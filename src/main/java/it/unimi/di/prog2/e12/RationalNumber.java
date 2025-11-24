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

import java.util.Objects;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification. Provide also the RI and AF.

  /** The numerator */
  public final int numerator;

  /** The denominator */
  public final int denominator;

  /*-
   * AF:
   * 
   *  - AF(numerator, denominator) = numerator/denominator
   * 
   * RI:
   * 
   * - denominator > 0
   * - the gcd between the numerator and denominator ha to be 1
   * 
   */

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   */
  public RationalNumber(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    return new RationalNumber(
      (this.numerator * other.denominator) + (other.numerator * this.denominator),
      this.denominator * other.denominator
      );
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return new RationalNumber(
      this.numerator * other.numerator,
      this.denominator * other.denominator
      );
  }

  @Override
  public boolean equals(Object obj) {

    if (!(obj instanceof RationalNumber other)) return false;
    return numerator == other.numerator && denominator == other.denominator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  @Override
  public String toString() {
    if ( denominator == 1) return Integer.toString(numerator);
    return numerator + "/" + denominator;
  }
}
