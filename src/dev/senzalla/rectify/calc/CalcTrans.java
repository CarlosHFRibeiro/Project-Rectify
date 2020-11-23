/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.senzalla.rectify.calc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class CalcTrans {

    private final List<Double> react = new ArrayList<>();// Pares Metanol, Impares Metilato


    public String getReact(int i) {
        return String.format("%.3f", react.get(i));
    }

    private double setAcidez(int acidez) {
        double tblConversaoTrans = 0;
        switch (acidez) {
            case 0:
                tblConversaoTrans = 220.32;
                break;
            case 1:
                tblConversaoTrans = 228.81;
                break;
            case 2:
                tblConversaoTrans = 235.06;
                break;
            case 3:
                tblConversaoTrans = 241.32;
                break;
            case 4:
                tblConversaoTrans = 247.57;
                break;
            case 5:
                tblConversaoTrans = 253.83;
                break;
            case 6:
                tblConversaoTrans = 260.09;
                break;
            case 7:
                tblConversaoTrans = 266.34;
                break;
            case 8:
                tblConversaoTrans = 272.6;
                break;
            case 9:
                tblConversaoTrans = 278.85;
                break;
            case 10:
                tblConversaoTrans = 285.11;
                break;
            case 11:
                tblConversaoTrans = 291.36;
                break;
            case 12:
                tblConversaoTrans = 297.62;
                break;
            case 13:
                tblConversaoTrans = 303.87;
                break;
            case 14:
                tblConversaoTrans = 310.13;
                break;
            case 15:
                tblConversaoTrans = 316.38;
                break;
            case 16:
                tblConversaoTrans = 322.64;
                break;
            case 17:
                tblConversaoTrans = 328.89;
                break;
            case 18:
                tblConversaoTrans = 335.15;
                break;
            case 19:
                tblConversaoTrans = 341.4;
                break;
            case 20:
                tblConversaoTrans = 347.66;
                break;
            case 21:
                tblConversaoTrans = 353.91;
                break;
            case 22:
                tblConversaoTrans = 360.17;
                break;
            case 23:
                tblConversaoTrans = 366.43;
                break;
            case 24:
                tblConversaoTrans = 372.68;
                break;
            case 25:
                tblConversaoTrans = 378.94;
                break;
            case 26:
                tblConversaoTrans = 385.19;
                break;
            case 27:
                tblConversaoTrans = 391.45;
                break;
            case 28:
                tblConversaoTrans = 397.7;
                break;
            case 29:
                tblConversaoTrans = 403.96;
                break;
            case 30:
                tblConversaoTrans = 410.21;
                break;
            case 31:
                tblConversaoTrans = 416.47;
                break;
            case 32:
                tblConversaoTrans = 422.72;
                break;
            case 33:
                tblConversaoTrans = 428.98;
                break;
            case 34:
                tblConversaoTrans = 435.23;
                break;
            case 35:
                tblConversaoTrans = 441.49;
                break;
            case 36:
                tblConversaoTrans = 447.74;
                break;
            case 37:
                tblConversaoTrans = 454.0;
                break;
            case 38:
                tblConversaoTrans = 460.26;
                break;
            case 39:
                tblConversaoTrans = 466.51;
                break;
            case 40:
                tblConversaoTrans = 472.77;
                break;
        }
        return tblConversaoTrans;
    }

    public void calcular(int selectedIndex, double liters) {
        react.add((liters * 15 / 100) * 70 / 100);
        react.add((liters * 15 / 100) * 30 / 100);
        double template = 10500;
        react.add((liters * (setAcidez(selectedIndex) * 100 / template) / 100) * 70 / 100);
        react.add((liters * (setAcidez(selectedIndex) * 100 / template) / 100) * 30 / 100);
    }
}
