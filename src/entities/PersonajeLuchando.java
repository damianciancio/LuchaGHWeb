package entities;

public class PersonajeLuchando {

	public enum PersonajeState { NORMAL, SIN_VIDA, SIN_ENERGIA }

	private Personaje p;
	private int vidaActual;
	private int energiaActual;
	
	public PersonajeLuchando(Personaje p)
	{
		/*
		 * recibe como parametro el personaje y setea los valores iniciales
		 */
		this.setP(p);
		this.setEnergiaActual(this.getP().getEnergia());
		this.setVidaActual(this.getP().getVida());
	}
	
	public PersonajeState getEstado()
	{
		if(this.getVidaActual()<=0)
		{
			return PersonajeState.SIN_VIDA;
		}
		else
			if(this.getEnergiaActual()<=0)
			{
				return PersonajeState.SIN_ENERGIA;
			}
			else return PersonajeState.NORMAL;
	}
	
	public Personaje getP() {
		return p;
	}
	public void setP(Personaje p) {
		this.p = p;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	public int getEnergiaActual() {
		return energiaActual;
	}
	public void setEnergiaActual(int energiaActual) {
		this.energiaActual = energiaActual;
	}
	
	
	//Revisar despues
	public boolean atacar(PersonajeLuchando pAtacado, int cantPtos) throws Exception
	{
		if (this.getEnergiaActual() < cantPtos){
			throw new Exception("No posee suficientes puntos para realizar el ataque");
		}
		
		boolean ataqueExitoso = this.getP().atacar(pAtacado.getP(), cantPtos);
		this.restarEnergia(cantPtos);
		
		if(ataqueExitoso){
			pAtacado.restarVida(cantPtos);
		}
		
		return ataqueExitoso;
	}
	
	public void restarVida(int cantPtos)
	{
		this.setVidaActual(this.getVidaActual()-cantPtos);
		
	}
	public void restarEnergia(int cantPtos)
	{
		this.setEnergiaActual(this.getEnergiaActual()-cantPtos);
		
	}

	public void defender() {
		/*
		 * aumenta la vida y la energia segun la formula dedel tp
		 */
		this.setVidaActual(this.getVidaActual()+(this.getP().getDefensa()*this.getP().getVida())/250);
		this.setEnergiaActual(this.getEnergiaActual()+(this.getP().getDefensa()*this.getP().getEnergia()/100));

		if (getVidaActual() > p.getVida()) setVidaActual(p.getVida());
		if (getEnergiaActual() > p.getEnergia()) setEnergiaActual(p.getEnergia());
	}
}
	
