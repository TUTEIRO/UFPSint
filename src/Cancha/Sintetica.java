package Cancha;

import jello.annotation.Association;
import jello.annotation.Expose;
import jello.annotation.KeyElement;
import jello.annotation.Required;
import jello.model.JelloEntity;
import jello.rest.IllegalRequestResource;
import jello.security.Accessible;
import jello.security.Role;
import jello.ux.Validation;

import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import Reserva.ReservarCancha;


@PersistenceCapable
@Accessible(Role.ALL)
public class Sintetica extends JelloEntity {

	private static final long serialVersionUID = -6090670267384247075L;
	
	@Expose @Required  @KeyElement 
	public String nombreCancha;
	
	@Expose @Required
	public String Direccion;
	
	@Validation(email=true)
	@Expose @Required
	public String Email;
	
	@Expose @Required @Validation(min=0,max=100000)
	public Double Precio;
	
	@Expose 
	public String Telefono;
	
	@Expose @NotPersistent @Association(mappedBy="nombreCancha") 
	public List<ReservarCancha> reservas;
	
	@Override
	protected JelloEntity beforeSave() throws IllegalRequestResource {
		// TODO Auto-generated method stub
		return this;
	}
	
	



}
