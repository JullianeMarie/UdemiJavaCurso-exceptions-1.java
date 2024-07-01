package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExcepetion;

public class Reserva {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// Intancio static pois não preciso instanciar um novo SimpleDateFormat.
	// Para cada objeto Reserva que a aplicação tiver.

	public Reserva(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExcepetion {
		if (!checkOut.after(checkIn)) {
			throw new DomainExcepetion("Erro na reserva: Data Check-Out deve ser maior que data de Check-In. ");
		} 
		/* Inicio a lógica de verificar se a data de check-in é menor que a data de checkout
		 * no escopo dos métodos pois é de boa prática(Programação Defensiva).
		 */
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long Duracao() { // Tipo long para milessegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte milessegundos para dia.

	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainExcepetion { 
		// Volta a ser void pois lançará uma exceção ao invés de retornar um erro.
		// throws DomainExcepetion para o método lançar exceção.
	
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainExcepetion("Erro na reserva: Datas de atualização devem ser datas futuras");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainExcepetion("Erro na reserva: Data Check-Out deve ser maior que data de Check-In. ");
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto: " + roomNumber + ", ");
		sb.append("Check-In: " + sdf.format(checkIn) + ", ");
		sb.append("Check-Out: " + sdf.format(checkOut) + ", ");
		sb.append(Duracao() + " noites");
		return sb.toString();
	}

}
