package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model_entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("entrada: ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("saida: ");
		Date checkout = sdf.parse(sc.next());
		
		
		//No if vamos usar um metodo .after que testa se uma data é posterior a outra
		//Vamos colocar um ! para inverter a logica
		if(!checkout.after(checkin)) {
			System.out.println("Data de entrada é posterior a da saída!");
		}else {
			Reservation reserva = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println("");
			System.out.println("----------------------------------");
			System.out.println("Alterar reserva: ");
			
			System.out.print("entrada: ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("saida: ");
			checkout = sdf.parse(sc.next());
			
			//vê a data de hoje e testa para ver se as datas da reserva são posteriores
			Date hoje = new Date();
			if(checkin.before(hoje) || checkout.before(hoje)) {
				System.out.println("Datas invalidas pois são anteriores ao dia de hoje!");
			}else if(!checkout.after(checkin)) {
				System.out.println("Data de entrada é posterior a da saída!");
			}else {
				reserva.updateDates(checkin, checkout);
				System.out.println(reserva);
			}
		}
		
		
		sc.close();
		

	}

}
