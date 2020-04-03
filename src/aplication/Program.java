package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model_entities.Reservation;
import model_entities.exception.ExceptionPadrao;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("entrada: ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("saida: ");
			Date checkout = sdf.parse(sc.next());

			Reservation reserva = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reserva);

			System.out.println("");
			System.out.println("----------------------------------");
			System.out.println("Alterar reserva: ");
			System.out.print("entrada: ");
			checkin = sdf.parse(sc.next());
			System.out.print("saida: ");
			checkout = sdf.parse(sc.next());

			reserva.updateDates(checkin, checkout);
			System.out.println(reserva);
		} 
		catch (ParseException e) {
			System.out.println("erro -> " + e);
		}
		catch (ExceptionPadrao e) {
			System.out.println("erro -> " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("erro -> " + e);
		}

		sc.close();

	}

}
