/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.calc;

import dev.senzalla.rectify.entitys.AnalyzeTruck;

/**
 * @author Bomsalvez
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcTransport {

    public static int calcLitter(AnalyzeTruck analyzeTruck, int burden) {
        return (int) (burden / analyzeTruck.getDensityTruck());
    }

    public static int calcBurden(AnalyzeTruck analyzeTruck, int liter) {
        return (int) (analyzeTruck.getDensityTruck() * liter);
    }

}
