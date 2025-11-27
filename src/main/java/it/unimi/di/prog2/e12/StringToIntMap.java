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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A map from {@link String} to {@link Integer}.
 *
 * <p>A <em>map</em> is a collection that associates keys to values. In this case, the keys are
 * strings and the values are integers. The map cannot contain duplicate keys, which means that each
 * key can be associated to at most one value.
 */
public class StringToIntMap {

  // EXERCISE: provide an implementation (including the equals, hashCode, and toString
  // methods). Provide also the RI and AF.

  // Note: do not use the Map in Java Collections, the point is to implement it from scratch!

  /** A list containing the map keys */
  private final List<String> keys;

  /** A list containing the map values */
  private final List<Integer> values;

  /*-
   * AF: 
   * 
   * -AF(keys, values) = a map where keys.get(i) is associated with values.get(i) for each i in [0, key.size())
   * 
   * RI:
   * 
   * -keys != NULL and daoesn't contains NULL
   * -values != NLL and doeasn't contains NULL
   * -keys.size() = values.size()
   * 
   */

  /** Creates a new empty map. */
  public StringToIntMap() {
    keys = new ArrayList<>();
    values = new ArrayList<>();
  }

  /**
   * Returns the size of this map.
   *
   * @return the number of key-value mappings in this map.
   */
  public int size() {
    return keys.size();
  }

  /**
   * Returns if this map is empty.
   *
   * @return {@code true} iff this map contains no key-value mappings.
   */
  public boolean isEmpty() {
    return keys.isEmpty();
  }
  
  /**
   * Returns the index of of a string in the list of Strings in inccreasing order
   * @param lista the not {@code null} list of Strings in increasing order
   * @param valore the not {@code null} String value to search
   * @return the index of the string
   */
  private static int Search(final List<String> lista, final String valore) {
    int lo = 0;
    int hi = lista.size() - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int res = valore.compareTo(lista.get(mid));
      if (res < 0) hi = mid -1;
      else if (res > 0) lo = mid +1;
      else return mid;
    }
    return -lo - 1;
  }

  /**
   * Returns if this map contains the specified key.
   *
   * @param key the key to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code key}.
   */
  public boolean containsKey(String key) {
    return Search(keys, key) >= 0;
  }

  /**
   * Returns if this map contains the specified value.
   *
   * @param value the value to search for.
   * @return {@code true} iff this map contains a key-value mappings with the given {@code value}.
   */
  public boolean containsValue(int value) {
    return values.indexOf(value) != -1;
  }

  /**
   * Returns the value to which the specified key is mapped.
   *
   * @param key the key whose associated value is to be returned.
   * @return the value to which the specified key is mapped.
   * @throws NoSuchElementException if this map contains no mapping for the key, or the key is
   *     {@code null}.
   */
  public int get(String key) throws NoSuchElementException {
    if (key == null) throw new NoSuchElementException("key is null");
    int i = Search(keys, key);
    if (i < 0) throw new NoSuchElementException("The key is not in the map");
    return values.get(i);
  }

  /**
   * Associates in this map the new key with the specified value.
   *
   * @param key the key with which the specified value is to be associated.
   * @param value the value to be associated with the specified key.
   * @throws IllegalArgumentException if the map already contain a mapping for the key.
   * @throws NullPointerException if the key is {@code null}.
   */
  public void put(String key, int value) {
    if (key == null) throw new NullPointerException("Key cannot be null");
    if (containsKey(key)) throw new IllegalArgumentException("The key is already been used");
    int i = Search(keys, key);
    keys.add(-i - 1, key);
    values.add(-i - 1, value);
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   *
   * @param key the key whose mapping is to be removed from the map.
   * @return {@code true} iff this map contained a mapping for the specified key, and hence is
   *     modified by this operation.
   */
  public boolean remove(String key) {
    if (key == null) return false;
    int i = Search(keys, key);
    if (i < 0) return false;
    keys.remove(i);
    values.remove(i);
    return true;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    keys.clear();
    values.clear();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof StringToIntMap other)) return false;
    return keys.equals(other.keys) && values.equals(other.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keys, values);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StringToIntMap: {");
    for (int i = 0; i < keys.size(); i++) {
      sb.append(keys.get(i) + ":" + values.get(i));
      if (i < keys.size() - 1) sb.append(", "); 
    }
    sb.append("}");
    return sb.toString();
  }
}
