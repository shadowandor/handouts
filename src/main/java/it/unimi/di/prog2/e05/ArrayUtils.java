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

/** Classe di metodi di utilità per array. */
public class ArrayUtils {

  /** costruttore privato */
  private ArrayUtils() {}

  /*
   * Specify and implement a method that given a sorted array of integers and a
   * value, returns the index of the value if it is present in the array.
   *
   * Hint: https://research.google/blog/extra-extra-read-all-about-it-nearly-all-binary-searches-and-mergesorts-are-broken/
   */

   /**
   * Restituisce l'indice di {@code value} se è presente in {@code a},
   * altrimenti restituisce -1.
   *
   * @param a array di interi ordinato in modo crescente
   * @param value valore da cercare
   * @return indice del valore se trovato, altrimenti -1
   */
  public static int binarySearch(int[] a, int value) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high) {
      // calcolo medio “sicuro” per evitare overflow
      int mid = low + ((high - low) >>> 1);

      if (a[mid] < value) {
        low = mid + 1;
      } else if (a[mid] > value) {
        high = mid - 1;
      } else {
        return mid; // trovato
      }
    }

    // non trovato
    return -1;
  }
}
