/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.command;

import dominio.Votaciones;

/**
 *
 * @author luise
 */
public class CommandVotar2 implements Command{

    public void execute(Votaciones v) {
        v.votar2();
    }
}