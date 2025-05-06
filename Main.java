import java.util.Scanner;

public class MatriceStringhe {
    private String[][] matrice;

    public MatriceStringhe(String[][] matrice) {
        this.matrice = matrice;
    }

    public void stampaMatrice() {
        for (String[] riga : matrice) {
            for (String parola : riga) {
                System.out.print(parola + " ");
            }
            System.out.println();
        }
    }

    public int contaParole() {
        int count = 0;
        for (String[] riga : matrice) {
            for (String parola : riga) {
                count++;
            }
        }
        return count;
    }

    public int calcolaLunghezzaTotale() {
        int lunghezzaTotale = 0;
        for (String[] riga : matrice) {
            for (String parola : riga) {
                lunghezzaTotale += parola.length();
            }
        }
        return lunghezzaTotale;
    }

    public String cercaParola(String parola) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                if (matrice[i][j].equals(parola)) {
                    return "Parola trovata in posizione: (" + i + ", " + j + ")";
                }
            }
        }
        return "Parola non trovata.";
    }

    public int contaParoleInizianoCon(char carattere) {
        int count = 0;
        for (String[] riga : matrice) {
            for (String parola : riga) {
                if (parola.charAt(0) == carattere) {
                    count++;
                }
            }
        }
        return count;
    }

    public int contaParoleContengono(char lettera) {
        int count = 0;
        for (String[] riga : matrice) {
            for (String parola : riga) {
                if (parola.indexOf(lettera) != -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int contaPalindromi() {
        int count = 0;
        for (String[] riga : matrice) {
            for (String parola : riga ) {
                if (isPalindrome(parola)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String parola) {
        String reversed = new StringBuilder(parola).reverse().toString();
        return parola.equals(reversed);
    }

    public String trovaParolaPiuLunga() {
        String parolaPiuLunga = "";
        for (String[] riga : matrice) {
            for (String parola : riga) {
                if (parola.length() > parolaPiuLunga.length()) {
                    parolaPiuLunga = parola;
                }
            }
        }
        return parolaPiuLunga;
    }

    public String trovaParolaPiuCorta() {
        String parolaPiuCorta = matrice[0][0];
        for (String[] riga : matrice) {
            for (String parola : riga) {
                if (parola.length() < parolaPiuCorta.length()) {
                    parolaPiuCorta = parola;
                }
            }
        }
        return parolaPiuCorta;
    }

    public int contaVocali() {
        int count = 0;
        for (String[] riga : matrice) {
            for (String parola : riga) {
                count += countVowels(parola);
            }
        }
        return count;
    }

    private int countVowels(String parola) {
        int count = 0;
        for (char c : parola.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public void sostituisciLettera(char vecchia, char nuova) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = matrice[i][j].replace(vecchia, nuova);
            }
        }
    }

    public static void main(String[] args) {
        String[][] matrice = {
            {"cane", "gatto", "pesce"},
            {"cavallo", "topo", "elefante"},
            {"leone", "tigre", "orso"},
            {"panda", "koala", "foca"},
            {"delfino", "scoiattolo", "farfalla"}
        };

        MatriceStringhe ms = new MatriceStringhe(matrice);
        ms.stampaMatrice();
        System.out.println("Numero totale di parole: " + ms.contaParole());
        System.out.println("Lunghezza totale delle stringhe: " + ms.calcolaLunghezzaTotale());
        System.out.println(ms.cercaParola("gatto"));
        System.out.println("Parole che iniziano con 'c': " + ms.contaParoleInizianoCon('c'));
        System.out.println("Parole che contengono 'a': " + ms.contaParoleContengono('a'));
        System.out.println("Numero di palindromi: " + ms.contaPalindromi());
        System.out.println("Parola più lunga: " + ms.trovaParolaPiuLunga());
        System.out.println("Parola più corta: " + ms.trovaParolaPiuCorta());
        System.out.println("Numero totale di vocali: " + ms.contaVocali());
        ms.sostituisciLettera('a', 'o');
        System.out.println("Matrice dopo la sostituzione:");
        ms.stampaMatrice();
    }
}
