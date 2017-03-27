import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ComposanteRGB {


	public static void main(String[] args) {
		boolean fin = false;
		Scanner sc = new Scanner(System.in);
		while (!fin) {
			System.out.println(
					"Veuillez choisir une question: \n1. Créer 3 images correspondant aux composantes rouge, vert et bleu\n2. Créer un fichier image qui correspond aux niveaux de gris de l'image initiale\n3. Créer un fichier image qui correspond au négatif de l'image initiale\n4. Créer un fichier image qui correspond à l'image initiale avec une taille divisée par deux\n5. Quitter le programme\n");

			int choix = sc.nextInt();
			switch (choix) {
			// QUESTION 1
			case 1:
				boolean finQ1 = false;
				while (!finQ1) {
					System.out.println(
							"Veuillez saisir un fichier: \n\t- arbreASCII\n\t- lenaASCII\nTapez Q pour Quitter\n");
					String fichier = sc.nextLine();
					switch (fichier) {
					case "arbreASCII":
						questionUn(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ1 = true;
						break;
					case "lenaASCII":
						questionUn(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ1 = true;
						break;
					case "Q":
						finQ1 = true;
					default:
						System.out.println("Vous devez choisir un deux fichier précédents");
					}
				}
				break;
			// QUESTION 2
			case 2:
				boolean finQ2 = false;
				while(!finQ2){
					System.out.println(
							"Veuillez saisir un fichier: \n\t- arbreASCII\n\t- lenaASCII\nTapez Q pour Quitter\n");
					String fichier = sc.nextLine();
					switch (fichier) {
					case "arbreASCII":
						questionDeux(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ2 = true;
						break;
					case "lenaASCII":
						questionDeux(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ2 = true;
						break;
					case "Q":
						finQ2 = true;
					default:
						System.out.println("Vous devez choisir un deux fichiers précédents");
					}
				}
				break;
			// QUESTION 3
			case 3:
				boolean finQ3 = false;
				while(!finQ3){
					System.out.println(
							"Veuillez saisir un fichier: \n\t- arbreASCII (Si vous l'avez généré)\n\t- lenaASCII (Si vous l'avez généré)\n\t- barbaraAscii\n\t- singem\nTapez Q pour Quitter\n");
					String fichier = sc.nextLine();
					switch (fichier) {
					case "arbreASCII":
						questionTrois(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ3 = true;
						break;
					case "lenaASCII":
						questionTrois(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ3 = true;
						break;
					case "barbaraAscii":
						questionTrois(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ3 = true;
						break;
					case "singem":
						questionTrois(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ3 = true;
						break;
					case "Q":
						finQ3 = true;
					default:
						System.out.println("Vous devez choisir un des fichiers précédents");
					}
				}
				break;
			// QUESTION 4
			case 4:
				boolean finQ4 = false;
				while(!finQ4){
					System.out.println(
							"Veuillez saisir un fichier: \n\t- arbreASCII\n\t- lenaASCII\nTapez Q pour Quitter\n");
					String fichier = sc.nextLine();
					switch (fichier) {
					case "arbreASCII":
						questionQuatre(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ4 = true;
						break;
					case "lenaASCII":
						questionQuatre(fichier);
						System.out.println("Les fichiers ont bien été créés");
						finQ4 = true;
						break;
					case "Q":
						finQ3 = true;
					default:
						System.out.println("Vous devez choisir un des fichiers précédents");
					}
				}
				break;
			// QUITTER
			case 5:
				fin = true;
				break;
			default:
				System.out.println("Vous devez choisir un chiffre en 1 et 5");
				break;
			}
		}

		sc.close();
	}

	public static void questionUn(final String nomFich) {
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(nomFich + ".ppm"));
			BufferedWriter fichierRed = new BufferedWriter(new FileWriter(nomFich + "Red.ppm"));
			BufferedWriter fichierGreen = new BufferedWriter(new FileWriter(nomFich + "Green.ppm"));
			BufferedWriter fichierBlue = new BufferedWriter(new FileWriter(nomFich + "Blue.ppm"));

			// P?
			String entete = fichier.readLine();
			// commentaire
			String com = fichier.readLine();
			// taille
			String taille = fichier.readLine();

			// couleur
			String couleur = fichier.readLine();

			fichierRed.write(entete + "\n" + com + "\n" + taille + "\n" + couleur + "\n");
			fichierGreen.write(entete + "\n" + com + "\n" + taille + "\n" + couleur + "\n");
			fichierBlue.write(entete + "\n" + com + "\n" + taille + "\n" + couleur + "\n");
			
			while ((ligne = fichier.readLine()) != null) {

				// Lecture d'un pixel
				String red = ligne;
				String green = fichier.readLine();
				String blue = fichier.readLine();

				// QUESTION 1
				fichierBlue.write(0 + "\n");
				fichierBlue.write(0 + "\n");
				fichierBlue.write(blue + "\n");

				fichierRed.write(red + "\n");
				fichierRed.write(0 + "\n");
				fichierRed.write(0 + "\n");

				fichierGreen.write(0 + "\n");
				fichierGreen.write(green + "\n");
				fichierGreen.write(0 + "\n");
			}
				
			fichier.close();
			fichierRed.close();
			fichierGreen.close();
			fichierBlue.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void questionDeux(String nomFich) {
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(nomFich + ".ppm"));
			BufferedWriter fichierGris = new BufferedWriter(new FileWriter(nomFich + "Gris.pgm"));

			// P?
			String entete = fichier.readLine();
			// commentaire
			String com = fichier.readLine();
			// taille
			String taille = fichier.readLine();
			// ARBRE : largeur 410, hauteur 310

			// couleur
			String couleur = fichier.readLine();

			fichierGris.write("P2\n" + com + "\n" + taille + "\n" + couleur + "\n");

			while ((ligne = fichier.readLine()) != null) {

				// Lecture d'un pixel
				String red = ligne;
				String green = fichier.readLine();
				String blue = fichier.readLine();

				// QUESTION 2: fonctionne pour l'image lenaACSII mais par pour
				// arbreASCII
				double gris = 0.299 * Integer.parseInt(red) + 0.587 * Integer.parseInt(green)
						+ 0.114 * Integer.parseInt(blue);
				fichierGris.write(Integer.toString((int) gris) + "\n");

			}

			fichier.close();
			fichierGris.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void questionTrois(String nomFich) {
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(nomFich + ".pgm"));
			BufferedWriter fichierNegatif = new BufferedWriter(new FileWriter(nomFich + "Negatif.pgm"));

			// P?
			String entete = fichier.readLine();
			// commentaire
			String com = fichier.readLine();
			// taille
			String taille = fichier.readLine();

			// couleur
			String couleur = fichier.readLine();

			fichierNegatif.write("P2\n" + com + "\n" + taille + "\n" + couleur + "\n");

			while ((ligne = fichier.readLine()) != null) {

				// QUESTION 3
				int negatif = Integer.parseInt(couleur) - Integer.parseInt(ligne);
				fichierNegatif.write(negatif + "\n");

			}

			fichier.close();
			fichierNegatif.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void questionQuatre(String nomFich) {
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(nomFich + ".ppm"));
			BufferedWriter fichierDivise2 = new BufferedWriter(new FileWriter(nomFich + "Divise2.ppm"));

			// P?
			String entete = fichier.readLine();
			// commentaire
			String com = fichier.readLine();
			// taille
			String taille = fichier.readLine();
			String[] splited = taille.split("\\s+");
			String largeur = splited[0];
			String hauteur = splited[1];
			// ARBRE : largeur 410, hauteur 310

			// couleur
			String couleur = fichier.readLine();

			fichierDivise2.write(entete + "\n" + com + "\n" + Integer.parseInt(largeur) / 2 + " "
					+ Integer.parseInt(hauteur) / 2 + "\n" + couleur + "\n");

			Pixel[][] tab = new Pixel[Integer.parseInt(hauteur)][Integer.parseInt(largeur)];
			
			// Seulement utilisable quand on a une image en couleur
			int cptr = 0;
			int ite = 0;
			while ((ligne = fichier.readLine()) != null) {

				// Lecture d'un pixel
				String red = ligne;
				String green = fichier.readLine();
				String blue = fichier.readLine();

				// CREATION MATRICE DE PIXEL POUR QUESTION 4
				tab[ite][cptr] = new Pixel(Integer.parseInt(red), Integer.parseInt(green), Integer.parseInt(blue));

				if (cptr < Integer.parseInt(largeur) - 1) {
					cptr++;

				} else {
					ite++;
					cptr = 0;
				}
			}

			// QUESTION 4
			// APRES AVOIR REMPLI LA MATRICE PIXEL, ON ECRIT LE FICHIER DIVISE2
			for (int i = 0; i < tab.length - 1; i++) {
				for (int j = 0; j < tab[i].length; j++) {
					Pixel pHG = tab[i][j];
					Pixel pBG = tab[i + 1][j];
					Pixel pHD = tab[i][j + 1];
					Pixel pBD = tab[i + 1][j + 1];

					int newRed = (pHG.red + pBD.red + pBG.red + pHD.red) / 4;
					int newGreen = (pHG.green + pBD.green + pBG.green + pHD.green) / 4;
					int newBlue = (pHG.blue + pBD.blue + pBG.blue + pHD.blue) / 4;

					fichierDivise2.write(newRed + "\n");
					fichierDivise2.write(newGreen + "\n");
					fichierDivise2.write(newBlue + "\n");

					if (j < Integer.parseInt(largeur) - 1) {
						j++;
					}
				}
				i++;
			}

			fichier.close();
			fichierDivise2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
