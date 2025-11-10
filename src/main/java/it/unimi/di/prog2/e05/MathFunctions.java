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
   * Extracts (if possible) the square root of the given number.
   *
   * <ul>
   *   <li><b>Requires:</b> {@literal ( x \geq 0 )}.
   *   <li><b>Modifies:</b> nothing.
   *   <li><b>Effects:</b> returns {@literal \( y : | y^2 - x | < 10^{-3} \)}.
   * </ul>
   * 
   * @param x the number ti operate with
   * 
   * @return the square root of {@code x}
   */
  public static double SquareRoot(double x) {
    if (x<0)
      throw new IllegalArgumentException("Numero non positivo");
    //Casi base
    if (x==0||x==1) {
      return x;
    }
    //Altro
    double low = 0;
    double high = (x < 1) ? 1 : x;
    double mid = 0;

    while (true) {
      mid = (low + high) / 2.0;
      double quadrato = mid * mid;
      double diff = quadrato - x;

      if (Math.abs(diff) < 1e-3) {
        break;  //Evita che si generino errori dovuti alla sensibilià del programma
      }


      if (diff > 0) {
        high = mid;
      }else{
        low = mid;
      }
    }
    return mid;
  }
}
