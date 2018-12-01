package fingurprint.getFP;

import com.musicg.fingerprint.FingerprintManager;
import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.fingerprint.FingerprintSimilarityComputer;
import com.musicg.wave.Wave;

import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

public class Main {

	public static void main(String[] args) throws JavaLayerException {
		// TODO Auto-generated method stub
		String pathOfFiles = "C:/Users/VWin7/Documents/MySongsProjectFiles/Songs/";

		String fileOne = "paradise1";
		String fileTwo = "paradise2";
		String fileThree = "Pizza1";
		String fileFour = "Pizza2";

		String part1 = "paradise1 - Part1";
		String part2 = "paradise1 - Part2";
		String part3 = "paradise1 - Part3";

		String mp3Formate = ".mp3";
		String wavFormate = ".wav";
		
		//full songs convert
		new Converter().convert(pathOfFiles + fileOne + mp3Formate, pathOfFiles + fileOne + wavFormate);
		System.out.println(fileOne + wavFormate + " is created.");
		new Converter().convert(pathOfFiles + fileTwo + mp3Formate, pathOfFiles + fileTwo + wavFormate);
		System.out.println(fileTwo + wavFormate + " is created.");
		new Converter().convert(pathOfFiles + fileThree + mp3Formate, pathOfFiles + fileThree + wavFormate);
		System.out.println(fileThree + wavFormate + " is created.");
		new Converter().convert(pathOfFiles + fileFour + mp3Formate, pathOfFiles + fileFour + wavFormate);
		System.out.println(fileFour + wavFormate + " is created.");
		
		//song clips convert
		new Converter().convert(pathOfFiles + part1 + mp3Formate, pathOfFiles + part1 + wavFormate);
		System.out.println(part1 + wavFormate + " is created.");
		new Converter().convert(pathOfFiles + part2 + mp3Formate, pathOfFiles + part2 + wavFormate);
		System.out.println(part2 + wavFormate + " is created.");
		new Converter().convert(pathOfFiles + part3 + mp3Formate, pathOfFiles + part3 + wavFormate);
		System.out.println(part3 + wavFormate + " is created.");
		
		//full songs fingerprint
		byte[] firstFingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + fileOne + wavFormate));
		System.out.println("Fingurprint of " + fileOne + wavFormate + " is created.");
		byte[] secondFingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + fileTwo + wavFormate));
		System.out.println("Fingurprint of " + fileTwo + wavFormate + " is created.");
		byte[] thirdFingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + fileThree + wavFormate));
		System.out.println("Fingurprint of " + fileThree + wavFormate + " is created.");
		byte[] fourthFingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + fileFour + wavFormate));
		System.out.println("Fingurprint of " + fileFour + wavFormate + " is created.");
		
		//song clips fingerprint
		byte[] p1FingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + part1 + wavFormate));
		System.out.println("Fingurprint of " + part1 + wavFormate + " is created.");
		byte[] p2FingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + part2 + wavFormate));
		System.out.println("Fingurprint of " + part2 + wavFormate + " is created.");
		byte[] p3FingerPrint = new FingerprintManager().extractFingerprint(new Wave(pathOfFiles + part3 + wavFormate));
		System.out.println("Fingurprint of " + part3 + wavFormate + " is created.");
		
		//full songs compare
		FingerprintSimilarity oneFingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, secondFingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileOne + wavFormate + " and " + fileTwo + wavFormate + " is " + oneFingerprintSimilarity.getScore());
		FingerprintSimilarity twoFingerprintSimilarity = new FingerprintSimilarityComputer(thirdFingerPrint, fourthFingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileThree + wavFormate + " and " + fileFour + wavFormate + " is " + twoFingerprintSimilarity.getScore());
		FingerprintSimilarity threeFingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, fourthFingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileOne + wavFormate + " and " + fileFour + wavFormate + " is " + threeFingerprintSimilarity.getScore());
		
		//clips and songs compare
		FingerprintSimilarity p1s1FingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, p1FingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileOne + wavFormate + " and " + part1 + wavFormate + " is " + p1s1FingerprintSimilarity.getScore());
		FingerprintSimilarity p2s1FingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, p2FingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileThree + wavFormate + " and " + part2 + wavFormate + " is " + p2s1FingerprintSimilarity.getScore());
		FingerprintSimilarity p3s1FingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, p3FingerPrint)
				.getFingerprintsSimilarity();
		System.out.println(
				"Similarity score of " + fileOne + wavFormate + " and " + part3 + wavFormate + " is " + p3s1FingerprintSimilarity.getScore());

	}

}
