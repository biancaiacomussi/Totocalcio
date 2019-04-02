package it.polito.tdp.toto;

public class Espandi {
	
	public void espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN()) ; //ha dimensione massima pari alla dim max del pronostico
		espandi(p, parziale, 0) ;
	}
	
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato ...
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		//all'inizio devo passare una schedina vuota
		//metodo privato
		
		//il problema da risolvere è il pronostico, cioè quello che ha dato l'utente
		//riceve la schedina che è soluzione parziale a cui sono arrivata
		//e il livello a cui sono arrivata
		
		// parziale contiene già  (livello) valori 
		//		nelle posizioni 0...livello-1
		// io devo determinare parziale[livello]
		//		(cioè la livello+1 esima riga)
		// sulla base della previsione in pronostico[livello]
		
		
		
		//mi fermo al livello in cui il pronostico è stato esaurito
		
		if(livello==p.getN()) { //la soluzione parziale è la soluzione totale, non devo più aggiungere elementi alla schedina
			System.out.println(parziale) ;
			return ;
		}
		
		
		Previsione prev = p.get(livello) ; //previsioni che devo considerare
		//la previsione è un insieme
		
		// prova le varie alternative
		for(Risultato r: prev.getValori()) { //itero sul set per ogni risultato
			// provo ad aggiungere 'r' alla soluzione parziale
			parziale.add(r);
			
			espandi(p, parziale, livello+1) ; //espando la stessa schedina parziale
			
			// backtrack
			parziale.removeLast(); //dopo che ho aggiunto un elemento devo togliere
			//la soluzione parziale deve essere come era prima
			
			
		}
		
	}
	

}
