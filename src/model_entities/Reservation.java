package model_entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model_entities.exception.ExceptionPadrao;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores--------------------------------------------------------
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout)throws ExceptionPadrao {
		
		if(checkin.before(checkout)) {
			this.roomNumber = roomNumber;
			this.checkin = checkin;
			this.checkout = checkout;
		}else {
			throw new ExceptionPadrao("Data do checkin não pode ser posterior a do checkout");
		}
		
	}

	// Getters and setters-------------------------------------------------
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	// metodos--------------------------------------------------------------

	// o método getTime() devolve a data em milissegundos
	// TimeUnit.Days.convert() vai converter o numero de milissegundos em dias.
	public long duration() {
		long dias_em_milisegundos = (this.checkout.getTime() - this.checkin.getTime());
		return TimeUnit.DAYS.convert(dias_em_milisegundos, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout) throws ExceptionPadrao{
		Date hoje = new Date();
		if (checkin.before(hoje) || checkout.before(hoje)) {
			throw new ExceptionPadrao("Datas invalidas pois são anteriores ao dia de hoje!");
		}
		if (!checkout.after(checkin)) {
			throw new ExceptionPadrao("Data de entrada é posterior a da saída!");

		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Quarto n° " + this.roomNumber + " , entrada:  " + sdf.format(this.checkin) + " , saida:    "
				+ sdf.format(this.checkout) + " , total de dias: " + duration();
	}

}
