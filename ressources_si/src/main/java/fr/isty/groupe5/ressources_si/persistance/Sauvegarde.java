package fr.isty.groupe5.ressources_si.persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sauvegarde {

	public static void enregistrer(Object objet, String nomFichier) {
		final File fichier = new File(nomFichier);
		try (final FileOutputStream fo = new FileOutputStream(fichier);
				final ObjectOutputStream oo = new ObjectOutputStream(fo)) {
			oo.writeObject(objet);
		} catch (final IOException e) {
			e.printStackTrace();
			System.err.println("Erreur d'accès au fichier de sauvegarde");
		}
	}

	public static Object charger(String nomFichier) {
		final File fichier = new File(nomFichier);
		try (FileInputStream fi = new FileInputStream(fichier); ObjectInputStream oi = new ObjectInputStream(fi)) {
			return oi.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Erreur d'accès au fichier de sauvegarde");
		}
		return null;
	}

	public static void supprimer(String nomFichier) {
		final File fichier = new File(nomFichier);
		fichier.delete();
	}

}
