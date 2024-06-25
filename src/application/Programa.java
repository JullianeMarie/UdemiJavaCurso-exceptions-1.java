package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args)  { // Retiro throws pois agora vou tratar a exceção e não será mais propagada
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número quarto: ");
			int number = sc.nextInt();
			System.out.print("Entre com a data Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: "); 
			System.out.print("Entre com a data Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e){ 
			System.out.println("Data formato inválido");
		}
		catch (IllegalArgumentException e) {
			//Bloco para capturar a exceção.
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
/*
	Número quarto: 8021
	Entre com a data Check-in (dd/MM/yyyy): 25/09/2024
	Entre com a data Check-out (dd/MM/yyyy): 29/09/2024
	Reserva: Quarto: 8021, Check-In: 25/09/2024, Check-Out: 29/09/2024, 4 noites
	
	Entre com a data para atualizar a reserva: 
	Entre com a data Check-in (dd/MM/yyyy): 28/09/2015
	Entre com a data Check-out (dd/MM/yyyy): 02/10/2015
	Erro na reserva: Datas de atualização devem ser datas futuras
*/

