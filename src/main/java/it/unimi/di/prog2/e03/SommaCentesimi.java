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

package it.unimi.di.prog2.e03;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * Classe per la somma di centesimi
 */
public class SommaCentesimi {
    /**.*/
    private SommaCentesimi() {}
    /**
     * Metodo che restituisce la somma di n centesimi passati da riga di comando
     * @param args n centesimi da sommare
     */
    public static void main(String[] args) {
        BigDecimal total = BigDecimal.ZERO;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break; // se riga vuota, termina
            try {
                BigDecimal valore = new BigDecimal(line);
                total = total.add(valore);
            } catch (NumberFormatException e) {
                System.out.println("Formato non valido: " + line);
            }
        }
        System.out.println(total);
        sc.close();
    }
}
