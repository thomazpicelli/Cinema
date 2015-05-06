package com.br.lp2.cinema.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public interface Command {
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao);
}
