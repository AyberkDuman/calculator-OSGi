package converterServiceNumTR;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//this class convert word to number for "turkish words"

public class ConverterServiceNumTR {
	
	// kullanacagýmýz kelimeleri tanýmlarý.
	
		final static List<String> allowedStrings = Arrays.asList("and", "sýfýr", "bir", "iki", "üç", "dört", "beþ",
				"altý", "yedi", "sekiz", "dokuz", "on", "on bir", "on iki", "on üç", "on dört", "on beþ", "on altý",
				"on yedi", "on sekiz", "on dokuz", "yirmi", "otuz", "kýrk", "elli", "altmýþ", "yetmiþ", "seksen",
				"doksan", "yüz", "bin", "milyon", "milyar", "trilyon");
		
	
		// converter class, input'u words'e ayýrýp replaceTextualNumbers yollar.
		
		public static String convertWordsToNumber(String inputText) {
			

			
			List<String> words = new LinkedList<String>(cleanText(inputText));

			words = replaceTextualNumbers(words);
			

			// put spaces back in and return the string. Should be the same as input
			// text except from textual numbers
			return wordListToString(words);
			}
		
		// Does the replacement of textual numbers, processing each word at a time
		// and grouping them before doing the conversion
		private static List<String> replaceTextualNumbers(List<String> words) {

		// holds each group of textual numbers being processed together.
		// exmp: "one" or "five hundred and two"
		List<String> processingList = new LinkedList<String>();

			int i = 0;
			while (i < words.size() || !processingList.isEmpty()) {

			// caters for sentences only containing one word (that is a number)
			String word = "";
			if (i < words.size()) {
				word = words.get(i);
			}

			// strip word of all punctuation to make it easier to process
			String wordStripped = word.replaceAll("[^a-zA-Z\\sðüþýöçÐÜÞÝÖÇ]", "").toLowerCase();

			// 2nd condition: skip "and" words by themselves and at start of num
			if (allowedStrings.contains(wordStripped) && !(processingList.size() == 0 && wordStripped.equals("and"))) {
				words.remove(i); // remove from main list, will process later
				processingList.add(word);
			} else if (processingList.size() > 0) {
			// found end of group of textual words to process

			//if "and" is the last word, add it back in to original list
			String lastProcessedWord = processingList.get(processingList.size() - 1);
			if (lastProcessedWord.equals("and")) {
				words.add(i, "and");
				processingList.remove(processingList.size() - 1);
				}

			// main logic here, does the actual conversion
			String wordAsDigits = String.valueOf(convertWordsToNum(processingList));
						
			wordAsDigits = retainPunctuation(processingList, wordAsDigits);
			words.add(i, String.valueOf(wordAsDigits));

				processingList.clear();
				i += 2;
				} else {
					i++;
				}
			}

			return words;
		}
		
		//Retain punctuation at the start and end of a textual number.

		private static String retainPunctuation(List<String> processingList, String wordAsDigits) {

			String lastWord = processingList.get(processingList.size() - 1);
			char lastChar = lastWord.trim().charAt(lastWord.length() - 1);
			if (!Character.isLetter(lastChar)) {
				wordAsDigits += lastChar;
			}

			String firstWord = processingList.get(0);
			char firstChar = firstWord.trim().charAt(0);
			if (!Character.isLetter(firstChar)) {
				wordAsDigits = firstChar + wordAsDigits;
			}

			return wordAsDigits;
		}
		
		// Splits up hyphenated textual words. e.g. twenty-two -> twenty two

		private static List<String> cleanText(String sentence) {
			List<String> words = new LinkedList<String>(Arrays.asList(sentence.split(" ")));

			// remove hyphenated textual numbers
			for (int i = 0; i < words.size(); i++) {
				String str = words.get(i);
				if (str.contains("-")) {
					List<String> splitWords = Arrays.asList(str.split("-"));

					// just check the first word is a textual number. Caters for
					// "twenty-five," without having to strip the comma
					if (splitWords.size() > 1 && allowedStrings.contains(splitWords.get(0))) {
						words.remove(i);
						words.addAll(i, splitWords);
					}
				}

			}

			return words;
		}
		
		// Creates string including spaces from a list of words

		private static String wordListToString(List<String> list) {
			StringBuilder result = new StringBuilder("");
			for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
				if (i == 0 && str != null) {
					result.append(list.get(i));
				} else if (str != null) {
					result.append(" " + list.get(i));
				}
			}

			return result.toString();
		}
		
		/**
		 * Logic for taking a textual number string and converting it into a number
		 * e.g. twenty five -> 25
		 * 
		 * This relies on there only being one textual number being processed. Steps
		 * prior to this deal with breaking a paragraph down into individual textual
		 * numbers, which could consist of a number of words.
		 */
		
		private static long convertWordsToNum(List<String> words) {
			long finalResult = 0;
			long intermediateResult = 0;
			for (String str : words) {
				// clean up string for easier processing
				str = str.toLowerCase().replaceAll("[^a-zA-Z\\sðüþýöçÐÜÞÝÖÇ]", "");
				if (str.equalsIgnoreCase("sýfýr")) {
					intermediateResult += 0;
				} else if (str.equalsIgnoreCase("bir")) {
					intermediateResult += 1;
				} else if (str.equalsIgnoreCase("iki")) {
					intermediateResult += 2;
				} else if (str.equalsIgnoreCase("üç")) {
					intermediateResult += 3;
				} else if (str.equalsIgnoreCase("dört")) {
					intermediateResult += 4;
				} else if (str.equalsIgnoreCase("beþ")) {
					intermediateResult += 5;
				} else if (str.equalsIgnoreCase("altý")) {
					intermediateResult += 6;
				} else if (str.equalsIgnoreCase("yedi")) {
					intermediateResult += 7;
				} else if (str.equalsIgnoreCase("sekiz")) {
					intermediateResult += 8;
				} else if (str.equalsIgnoreCase("dokuz")) {
					intermediateResult += 9;
				} else if (str.equalsIgnoreCase("on")) {
					intermediateResult += 10;
				} else if (str.equalsIgnoreCase("on bir")) {
					intermediateResult += 11;
				} else if (str.equalsIgnoreCase("on iki")) {
					intermediateResult += 12;
				} else if (str.equalsIgnoreCase("on üç")) {
					intermediateResult += 13;
				} else if (str.equalsIgnoreCase("on dört")) {
					intermediateResult += 14;
				} else if (str.equalsIgnoreCase("on beþ")) {
					intermediateResult += 15;
				} else if (str.equalsIgnoreCase("on altý")) {
					intermediateResult += 16;
				} else if (str.equalsIgnoreCase("on yedi")) {
					intermediateResult += 17;
				} else if (str.equalsIgnoreCase("on sekiz")) {
					intermediateResult += 18;
				} else if (str.equalsIgnoreCase("on dokuz")) {
					intermediateResult += 19;
				} else if (str.equalsIgnoreCase("yirmi")) {
					intermediateResult += 20;
				} else if (str.equalsIgnoreCase("otuz")) {
					intermediateResult += 30;
				} else if (str.equalsIgnoreCase("kýrk")) {
					intermediateResult += 40;
				} else if (str.equalsIgnoreCase("elli")) {
					intermediateResult += 50;
				} else if (str.equalsIgnoreCase("altmýþ")) {
					intermediateResult += 60;
				} else if (str.equalsIgnoreCase("yetmiþ")) {
					intermediateResult += 70;
				} else if (str.equalsIgnoreCase("seksen")) {
					intermediateResult += 80;
				} else if (str.equalsIgnoreCase("doksan")) {
					intermediateResult += 90;
				} else if (str.equalsIgnoreCase("yüz")) {
					intermediateResult *= 100;
				} else if (str.equalsIgnoreCase("bin")) {
					intermediateResult *= 1000;
					finalResult += intermediateResult;
					intermediateResult = 0;
				} else if (str.equalsIgnoreCase("milyon")) {
					intermediateResult *= 1000000;
					finalResult += intermediateResult;
					intermediateResult = 0;
				} else if (str.equalsIgnoreCase("milyar")) {
					intermediateResult *= 1000000000;
					finalResult += intermediateResult;
					intermediateResult = 0;
				} else if (str.equalsIgnoreCase("trilyon")) {
					intermediateResult *= 1000000000000L;
					finalResult += intermediateResult;
					intermediateResult = 0;
				}
			}

			finalResult += intermediateResult;
			intermediateResult = 0;
			return finalResult;
		}

}
