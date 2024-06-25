package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número quarto: ");
		int number = sc.nextInt();
		System.out.print("Entre com a data Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Entre com a data Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) { //Se checkOut não for depois de checkIn faça
			System.out.println("Erro na reserva: Data Check-Out deve ser maior que data de Check-In. ");

		} 
		else { 
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: "); 
			System.out.print("Entre com a data Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.updateDates(checkIn, checkOut);
			if ( erro != null) { 
				System.out.println("Erro na reserva: " + erro);
			}
			System.out.println("Reserva: " + reserva);
		}
		
		
		sc.close();
	}
}

/*Número quarto: 8021
Entre com a data Check-in (dd/MM/yyyy): 23/09/2024
Entre com a data Check-out (dd/MM/yyyy): 26/09/2024
Reserva: Quarto: 8021, Check-In: 23/09/2024, Check-Out: 26/09/2024, 3 noites

Entre com a data para atualizar a reserva: 
Entre com a data Check-in (dd/MM/yyyy): 24/09/2024
Entre com a data Check-out (dd/MM/yyyy): 29/09/2024
*/

/*Número quarto: 8021
Entre com a data Check-in (dd/MM/yyyy): 23/09/2024
Entre com a data Check-out (dd/MM/yyyy): 26/09/2024
Reserva: Quarto: 8021, Check-In: 23/09/2024, Check-Out: 26/09/2024, 3 noites

Entre com a data para atualizar a reserva: 
Entre com a data Check-in (dd/MM/yyyy): 24/09/2015
Entre com a data Check-out (dd/MM/yyyy): 29/09/2015
Erro na reserva: Erro na reserva: Datas de atualização devem ser datas futuras
Reserva: Quarto: 8021, Check-In: 23/09/2024, Check-Out: 26/09/2024, 3 noites
*/
