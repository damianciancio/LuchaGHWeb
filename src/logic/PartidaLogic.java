package logic;

import java.util.Random;

import data.LuchaAdapter;
import util.*;
import entities.*;

public class PartidaLogic {
	public boolean PartidaVigente;
	
	private PersonajeLuchando p1;
	private PersonajeLuchando p2;
	private PersonajeLuchando turnoDe;
	private PersonajeLuchando esperando;
	private String logPelea;
	
	public String getLogPelea()
	{
		return logPelea;
	}

	public PersonajeLuchando getP1() {
		return p1;
	}
	public void setP1(PersonajeLuchando p1) {
		this.p1 = p1;
	}
	public PersonajeLuchando getP2() {
		return p2;
	}
	public void setP2(PersonajeLuchando p2) {
		this.p2 = p2;
	}
	public PersonajeLuchando getTurnoDe() {
		return turnoDe;
	}
	public void setTurnoDe(PersonajeLuchando turnoDe) {
		this.turnoDe = turnoDe;
	}

	public PartidaLogic() {
		PartidaVigente = false;
		logPelea = "";
	}
	
	public void comenzarPelea(Personaje pj1, Personaje pj2) throws PersonajeNoEncontradoException, PersonajeInvalidoException {
		if (pj1 == null || pj2 == null)
			throw new PersonajeNoEncontradoException("Elija ambos personajes");
		if (pj1.equals(pj2))
			throw new PersonajeInvalidoException("Elija personajes distintos");
		
		p1 = new PersonajeLuchando(pj1);
		p2 = new PersonajeLuchando(pj2);
		

		if(new Random().nextDouble()>0.5)
		{
			turnoDe = p1;
			esperando = p2;
		}
		else
		{
			turnoDe = p2;
			esperando = p1;
		}
		
		PartidaVigente = true;

		logPelea = "Pelea entre "+turnoDe.getP().getNombre()+" y "+esperando.getP().getNombre()+".\n\n";
	}

	
	public boolean atacar(int cantPtos) throws Exception, ErrorConexionException
	{
		int ptosPrevios = esperando.getVidaActual();
		boolean ataqueExitoso = turnoDe.atacar(esperando, cantPtos);
		if(ataqueExitoso)
		{
			logPelea = logPelea  + turnoDe.getP().getNombre()+ " ha quitado " + String.valueOf(ptosPrevios - esperando.getVidaActual())+ " de vida a "+esperando.getP().getNombre()+ "\r\n";
		}
		else
		{
			logPelea = logPelea + esperando.getP().getNombre() + " ha esquivado el ataque. "+ turnoDe.getP().getNombre()+" segui participando.\r\n"; 
		}
		cambiarDeTurno();
		
		return ataqueExitoso;
	}
	
	public void defender() throws Exception, ErrorConexionException
	{
		int ptosAnterioresVida = turnoDe.getVidaActual();
		int ptosAnterioresEnergia = turnoDe.getEnergiaActual();
		turnoDe.defender();
		logPelea = logPelea + turnoDe.getP().getNombre()+ " ha recuperado "
				+String.valueOf(turnoDe.getVidaActual()-ptosAnterioresVida)+" puntos de vida y "
				+String.valueOf(turnoDe.getEnergiaActual()-ptosAnterioresEnergia)+ " de energía.\r\n"; 
		cambiarDeTurno();
	}
	
	private void cambiarDeTurno() throws ErrorConexionException, Exception
	{
		//agrego funcionalidad de terminar la partida
		if(esperando.getVidaActual()<=0)
		{
			terminarPartida();
		}
		else
		{
			if (turnoDe == p1) {
				turnoDe = p2;
				esperando = p1;
			}
			else {
				turnoDe = p1;
				esperando = p2;
			}
		}
	}
	
	public void terminarPartida() throws ErrorConexionException, Exception
	{
		//guardo la victoria
		LuchaAdapter la = new LuchaAdapter();
		la.guardar(turnoDe.getP(), esperando.getP());
		
		PartidaVigente = false;
		logPelea = logPelea + "El personaje"+ turnoDe.getP().getNombre() +" ha ganado.\r\n\r\n\r\n";
		
	}
	public boolean isPartidaVigente() {
		return PartidaVigente;
	}
	public void setPartidaVigente(boolean partidaVigente) {
		PartidaVigente = partidaVigente;
	}
	
	
	
}
