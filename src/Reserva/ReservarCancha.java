package Reserva;

import jello.model.JelloEntity;
import jello.rest.IllegalRequestResource;
import java.util.Date;
import jello.security.Accessible;
import jello.security.Role;
import jello.annotation.Expose;
import jello.annotation.KeyElement;
import jello.annotation.ReadOnly;
import jello.annotation.Reference;
import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.PersistenceCapable;

import Cancha.Sintetica;

@PersistenceCapable
@Accessible( retrieve = Role.ALL,
create = Role.ALL,
update = Role.ALL,
query = Role.ALL,
delete = Role.ADMIN )
public class ReservarCancha extends JelloEntity {

	private static final long serialVersionUID = -4680922950779216810L;
	String id = "RES-";
	Integer idNum = 0;
	
	@Expose @KeyElement @ReadOnly
	public String idReserva = id+idNum;
	
	@Expose
	public String Cedula;

	@Expose
	public Date Fecha;

	@Expose @Reference (Sintetica.class) 
	public Key nombreCancha;

	@Override
	protected JelloEntity beforeSave() throws IllegalRequestResource {
		idNum = idNum + 1;
		return this;
	}



}
