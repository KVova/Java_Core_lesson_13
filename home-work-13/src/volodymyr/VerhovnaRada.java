package volodymyr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VerhovnaRada {

	private static VerhovnaRada verhovnaRada;
	ArrayList<Faction> newFaction = new ArrayList<>();

	public void addFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть назву фракції: /n");
		String factionName = scan.nextLine();
		Faction newF = new Faction(factionName);
		newFaction.add(newF);
		System.out.println("Створено нову фракцію: " + factionName);

	}

	public void removeFaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть назву фракції для видалення: /n");
		String factionName = scan.nextLine();
		Iterator<Faction> iterator = newFaction.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getFactionName().equals(factionName)) {
				iterator.remove();
				System.out.println("Фракцію " + factionName + " було видалено.");
			}
		}

	}

	public void displayAllFaction() {
		Iterator<Faction> iterator = newFaction.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public Faction repeatCode() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть назву фракції /n");
		String factionName = scan.nextLine().toLowerCase();
		Iterator<Faction> iterator = newFaction.iterator();
		while (iterator.hasNext()) {
			Faction newF = iterator.next();
			if (newF.getFactionName().toLowerCase().equals(factionName)) {
				return newF;
			}
		}
		return null;
	}

	public void displayFaction() {
		try {
			System.out.println(repeatCode().getFaction());
		} catch (Exception ex) {
			System.out.println("Такої фракції не існує! ");
		}
	}

	public void addRepresentativeToSingleFaction() {
		try {
			repeatCode().addReprsentative();
		} catch (Exception ex) {
			System.out.println("Такої фракції не існує! ");
		}
	}

	public void removeRepresentativeFromSingleFaction() {
		try {
			repeatCode().removeReprsentative();
		} catch (Exception ex) {
			System.out.println("Такої фракції не існує! ");
		}
	}

	public void displayAllGrafterInFaction() {
		try {
			repeatCode().displayAllGrafters();
		} catch (Exception ex) {
			System.out.println("Такої фракції не існує! ");
		}
	}

	public void displayMostGrafterInFaction() {
		try {
			repeatCode().displayMostGrafter();
		} catch (Exception ex) {
			System.out.println("Такої фракції не існує! ");
		}
	}

	public void displayAllRepresentativesFromFaction() {
		repeatCode().displayAllRepresentativs();
	}

	@Override
	public String toString() {
		return "VerhovnaRada [newFaction=" + newFaction + "]";
	}

	public static VerhovnaRada getInstance() {
		if (verhovnaRada == null) {
			verhovnaRada = new VerhovnaRada();
		}
		return verhovnaRada;
	}

}