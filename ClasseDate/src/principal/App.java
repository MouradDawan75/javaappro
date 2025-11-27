package principal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		/*
		 * Avant Java 8: 
		 * 
		 * package:
		 * java.util.Date
		 * 
		 * Classes liées à la manipulation de dates récupérées depuis une base de données
		 * 
		 * packages:
		 * java.sql
		 * java.sql.time
		 * java.sql.timestamp
		 * 
		 * A partir de java: ajout du package java.time: LocalDate, LocalTime, LocalDateTime
		 
		 */
		
		System.out.println(">>>> LocalDate:");
		
		LocalDate ld1 = LocalDate.now();
		System.out.println("LocalDate.now(): "+ld1);
		
		LocalDate ld2 = LocalDate.of(2020, 11, 15);
		System.out.println("LocalDate.of(): "+ld2);
		
		LocalDate ld3 = LocalDate.parse("2015-02-15");
		System.out.println("LocalDate.parse(): "+ld3);
		
		System.out.println(">>>> LocalTime:");
		
		LocalTime lt1 = LocalTime.now();
		System.out.println("LocalTime.now(): "+lt1);
		
		LocalTime lt2 = LocalTime.of(15,56,45); //possibilté d'ajouter les nanos secondes
		System.out.println("LocalTime.of(): "+lt2);
		
		LocalTime lt3 = LocalTime.parse("15:45");
		System.out.println("LocalTime.parse(): "+lt3);
		
		System.out.println(">>>> LocalDateTime:");
		
		LocalDateTime ldt1 = LocalDateTime.now();
		System.out.println("LocalDateTime.now(): "+ldt1);
		
		LocalDateTime ldt2 = LocalDateTime.of(2015, 11, 12, 15, 44, 35);
		System.out.println("LocalDateTime.of(): "+ldt2);
		
		LocalDateTime ldt3 = LocalDateTime.parse("2020-10-12T15:25:35");
		System.out.println("LocalDateTime.parse(): "+ldt3);
		
		System.out.println(ld1.plusDays(2));
		System.out.println(ld2.minusMonths(2));
		
		//Un ensemble d'enum est fournit: pour les mois et les jours
		
		DayOfWeek dof = DayOfWeek.FRIDAY;
		System.out.println(dof);
		
		Month mois = Month.DECEMBER;
		System.out.println(mois);
		
		LocalDateTime ldtime = LocalDateTime.of(2015, Month.FEBRUARY, 2, 15, 32,44);
		
		//Fuseau horaire: ZoneId
		
		//Liste des fuseaux horaires
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		
		ZoneId myZone = ZoneId.of("Europe/Paris");
		
		//Appliquer un fuseau à une date
		
		ZonedDateTime zdt = ZonedDateTime.of(ldt1, myZone);
		
		//Period: est une différence etre 2 LocalDate
		
		Period period = Period.between(ld1, ld3);
		
		System.out.println("Période: "+period);
		
		System.out.println(period.getDays());
		
		System.out.println(">>>>>>>>>< formattage de dates avec ZoneId:");
		
		
		//choisir un format prédéfini - ZoneId est nécessaire: long, moyen ou court
		
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zdt));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(zdt));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(zdt));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zdt));
		
		
		System.out.println(">>>>>>>>>< formattage de dates sans ZoneId:");
		
		// Soit Choisir un format prédéfinit sans ZoneId:
		LocalDateTime myDate = LocalDateTime.now(); //sans ZoneId
		
		String dateFormattee = myDate.format(DateTimeFormatter.ISO_ORDINAL_DATE);
		System.out.println(dateFormattee);
		
		//Soit appliquer un format personnalisé:
		String myPattern = myDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println(myPattern);
		
		//Formattage: lien doc: https://www.baeldung.com/java-datetimeformatter
		
		
		
		
		
		
		

	}

}
