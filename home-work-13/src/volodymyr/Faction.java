package volodymyr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Faction {

	private String factionName;

	private ArrayList<Representative> faction = new ArrayList<>();

	public Faction(String factionName) {
		super();
		this.factionName = factionName;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public ArrayList<Representative> getFaction() {
		return faction;
	}

	public void setFaction(ArrayList<Representative> faction) {
		this.faction = faction;
	}

	public void addReprsentative() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Ім'я депутата? ");
		String firstName = scan.nextLine();

		System.out.println("Прізвище депутата? ");
		String lastName = scan.nextLine();

		System.out.println("Вік депутата? ");
		int age = scan.nextInt();

		System.out.println("Зріст депутата? ");
		double height = scan.nextDouble();

		System.out.println("Вага депутата? ");
		double weight = scan.nextDouble();

		System.out.println("Депутат хабарник так/ні? ");
		boolean giveGrafter = scan.hasNextBoolean();

		try {
			Representative MP = new Representative(weight, height, firstName, lastName, age, giveGrafter);
			faction.add(MP);
		} catch (Exception ex) {
			System.out.println("Такий депутат уже є у фракції!");
		}

		System.out.println("Депутат " + firstName + " " + lastName + " доданий у фракцію.");
	}

	public void removeReprsentative() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Ім'я депутата? ");
		String firstName = scan.nextLine();

		System.out.println("Прізвище депутата? ");
		String lastName = scan.nextLine();

		System.out.println("Вік депутата? ");
		int age = scan.nextInt();

		Iterator<Representative> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Representative MP = iterator.next();
			if (MP.getFirstName().equalsIgnoreCase(firstName) && MP.getLastName().equalsIgnoreCase(lastName)
					&& MP.getAge() == age) {
				iterator.remove();

				System.out.println("Депутат " + firstName + " " + lastName + " видалений з фракції.");
			}
		}
		System.out.println("Даного депутата не знайдено.");
	}

	public void displayAllGrafters() {

		Iterator<Representative> iterator = faction.iterator();
		while (faction.iterator().hasNext()) {
			Representative displayGraftersMP = iterator.next();
			if (displayGraftersMP.isGrafter()) {
				System.out.println(displayGraftersMP);
			}
		}
	}

	public Representative displayMostGrafter() {
		return Collections.max(faction, new RepresentativeSizeOfGrafterComperator());
	}

	public void displayAllRepresentativs() {
		Iterator<Representative> iterator = faction.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void clearFaction() {
		faction.clear();
	}

	@Override
	public String toString() {
		return "[Фракція : Назва фракції : " + factionName + "]";
	}
}