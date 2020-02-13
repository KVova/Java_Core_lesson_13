package volodymyr;

import java.util.Scanner;

public class Application {

	public static void menu() {
		System.out.println("Введіть 1 щоб додати фракцію");
		System.out.println("Введіть 2 щоб видалити конкретну фракцію");
		System.out.println("Введіть 3 щоб вивести усі фракції");
		System.out.println("Введіть 4 щоб очистити конкретну фракцію");
		System.out.println("Введіть 5 щоб вивести конкретну фракцію");
		System.out.println("Введіть 6 щоб додати депутата в фракцію");
		System.out.println("Введіть 7 щоб видалити депутата з фракції");
		System.out.println("Введіть 8 щоб вивести список хабарників ");
		System.out.println("Введіть 9 щоб вивести найбільшого хабарника ");
	}

	public static void main(String[] args) {
		Faction faction;
		VerhovnaRada Verhovna = VerhovnaRada.getInstance();

		Scanner scan = new Scanner(System.in);

		while (true) {
			menu();

			switch (scan.next()) {
			case "1": {
				Verhovna.addFaction();
				break;
			}
			case "2": {
				Verhovna.removeFaction();
				break;
			}
			case "3": {
				Verhovna.displayAllFaction();
				break;
			}
			case "4": {
				Verhovna.removeRepresentativeFromSingleFaction();
				break;
			}
			case "5": {
				Verhovna.displayFaction();
				break;
			}
			case "6": {
				Verhovna.addRepresentativeToSingleFaction();
				break;
			}
			case "7": {
				Verhovna.removeRepresentativeFromSingleFaction();
				break;
			}
			case "8": {
				Verhovna.displayAllGrafterInFaction();
				break;
			}
			case "9": {
				Verhovna.displayMostGrafterInFaction();
				break;
			}
			}
			System.out.println();
		}

	}

}