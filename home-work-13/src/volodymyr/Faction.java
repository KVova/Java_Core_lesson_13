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

		System.out.println("��'� ��������? ");
		String firstName = scan.nextLine();

		System.out.println("������� ��������? ");
		String lastName = scan.nextLine();

		System.out.println("³� ��������? ");
		int age = scan.nextInt();

		System.out.println("���� ��������? ");
		double height = scan.nextDouble();

		System.out.println("���� ��������? ");
		double weight = scan.nextDouble();

		System.out.println("������� �������� ���/�? ");
		boolean giveGrafter = scan.hasNextBoolean();

		try {
			Representative MP = new Representative(weight, height, firstName, lastName, age, giveGrafter);
			faction.add(MP);
		} catch (Exception ex) {
			System.out.println("����� ������� ��� � � �������!");
		}

		System.out.println("������� " + firstName + " " + lastName + " ������� � �������.");
	}

	public void removeReprsentative() {
		Scanner scan = new Scanner(System.in);

		System.out.println("��'� ��������? ");
		String firstName = scan.nextLine();

		System.out.println("������� ��������? ");
		String lastName = scan.nextLine();

		System.out.println("³� ��������? ");
		int age = scan.nextInt();

		Iterator<Representative> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Representative MP = iterator.next();
			if (MP.getFirstName().equalsIgnoreCase(firstName) && MP.getLastName().equalsIgnoreCase(lastName)
					&& MP.getAge() == age) {
				iterator.remove();

				System.out.println("������� " + firstName + " " + lastName + " ��������� � �������.");
			}
		}
		System.out.println("������ �������� �� ��������.");
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
		return "[������� : ����� ������� : " + factionName + "]";
	}
}