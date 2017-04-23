package it.polito.tdp.anagrammi.model;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammiDao;
public class Model {
	
	private List<String> permutations = null; // permutations è la soluzione 
		
	public Model(){
			permutations = new ArrayList<String>();
		}

		public List<String> findPermutations(String word) {
			recursivePermutations(word, 0);
			return permutations;
		}
                                                        
		private void recursivePermutations(String word, int livello) {
			if (livello == word.length()) {
				permutations.add(word);
				return;
			}

			for (int i = livello; i < word.length(); i++) {

				char[] chars = word.toCharArray();

				// Genero una nuova soluzione
				char temp = chars[livello];
				chars[livello] = chars[i];
				chars[i] = temp;

				// Richiamo la funzione ricorsiva
				recursivePermutations(String.valueOf(chars), livello + 1);

				// Trasformando l'array di chars non Ã¨ necessario fare backtrack.
			}
		}
		
		public boolean isCorrect(String anagramma){
			AnagrammiDao dao = new AnagrammiDao();
			return dao.isCorrect(anagramma);
		}
		
		public static void main(String[] args) {
			Model model = new Model();
			List<String> permutations = model.findPermutations("eat");
			System.out.println(permutations);
		}
	}




