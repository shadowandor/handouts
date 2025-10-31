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

package it.unimi.di.prog2.e05;

/** Utility class for computing mathematical functions. */
public class MathFunctions {

  /** . */
  private MathFunctions() {}

  /* Specify and implement a method that given a positive number returns an approximation
   * of its square root.
   *
   * Hint: https://en.wikipedia.org/wiki/Bisection_method
   */

   /**
    * prende in input:
    * @param x un double
    * @return un'approssimazione della sua radice
    */
  public static double SquareRoot(double x) {
    if (x<0)
      throw new IllegalArgumentException("Numero non positivo");
    if (x==0||x==1) {
      return x;
    }
    return x;
  }
}
