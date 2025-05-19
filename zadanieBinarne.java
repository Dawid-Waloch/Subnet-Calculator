import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    String[] pustaMaska = {"00000000", "00000000", "00000000", "00000000"};
	    String[] maska = pustaMaska.clone();
	    int[] liczby = new int[4];
	    String[] liczbyBinarnie = new String[4];
	    String[] liczbyBinarniePoPorownaniu = new String[4];
	    int[] liczbyPoPorownaniu = new int[4];
	    String[] napisyDodawane = new String[4];
	    int[] liczbyDodawane = new int[4];
	    int dlugoscMaski = 0;
	    int liczbaBitow = 0;
	    
	    for(int i=0;i<4;i++) {
	        while(liczby[i] <= 0 || liczby[i] > 255) {
	            System.out.print("Podaj "+(i+1)+ " oktet: ");
	            liczby[i] = scan.nextInt();
	        }
	    }
	    
	    for(int i=0;i < 4;i++) {
	        liczbyBinarnie[i] = Integer.toBinaryString(liczby[i]);
	        
	        while(liczbyBinarnie[i].length() < 8) {
	            liczbyBinarnie[i] = "0" + liczbyBinarnie[i];
	        }
	    }
	    
	    while(dlugoscMaski <= 0 || dlugoscMaski > 32) {
		    System.out.print("Podaj dlugosc maski: ");
		    dlugoscMaski = scan.nextInt();
		}
		
		int liczbaPodsieci = 100;
		while((dlugoscMaski-liczbaPodsieci) <= 0) {
    		System.out.print("Podaj liczbę podsieci: ");
    		liczbaPodsieci = scan.nextInt();
		}
		
		
		if(liczbaPodsieci == 2) {
		    liczbaBitow = 1;
		} else {
		    liczbaBitow = Integer.toBinaryString(liczbaPodsieci).length();
		}
		
		int licznik = 0;
		for(int i=0; i < 4; i++) {
		    StringBuilder tmpNapis = new StringBuilder(pustaMaska[i]);
		    for(int j=0; j < 8;j++) {
		        if(licznik < dlugoscMaski) {
		            tmpNapis.setCharAt(j, '1');
		            licznik++;
		        }
		    }
		    maska[i] = tmpNapis.toString();
		}
		
		System.out.println("Maska:");
		
		for(int i = 0;i < 4;i++) {
		    System.out.print(maska[i]+" ");
		}
		
		System.out.println("");
		
		for(int i=0; i < 4; i++) {
		    StringBuilder tmpNapis = new StringBuilder(pustaMaska[i]);
		    for(int j=0; j < 8;j++) {
		        if(maska[i].charAt(j) == '1' && liczbyBinarnie[i].charAt(j) == '1') {
		            tmpNapis.setCharAt(j,'1');
		        }
		    }
		    liczbyBinarniePoPorownaniu[i] = tmpNapis.toString();
		}
		
		System.out.println("liczbyBinarnie");
		for( int i=0;i<4;i++) {
		    System.out.print(liczbyBinarniePoPorownaniu[i]+" ");
		}
		
		System.out.println("");
		
		int calkowitaDlugoscMaski = dlugoscMaski+liczbaBitow;
		
		
		licznik = 0;
		for(int i=0; i < 4; i++) {
		    StringBuilder tmpNapis = new StringBuilder(pustaMaska[i]);
		    for(int j=0; j < 8;j++) {
		        if(licznik < calkowitaDlugoscMaski) {
		            tmpNapis.setCharAt(j, '1');
		            licznik++;
		        } 
		    }
		    napisyDodawane[i] = tmpNapis.toString();
		}
		
		for(int i=0; i < 4; i++) {
		    StringBuilder tmpNapis = new StringBuilder(pustaMaska[i]);
		    for(int j=0; j < 8;j++) {
		        if(napisyDodawane[i].charAt(j) == '1') {
		            tmpNapis.setCharAt(j, '0');
		        } else {
		            tmpNapis.setCharAt(j, '1');
		        }
		    }
		    napisyDodawane[i] = tmpNapis.toString();
		}
		
		System.out.println("NapisyDodawane: ");
		
		for( int i=0;i<4;i++) {
		    System.out.print(napisyDodawane[i]+" ");
		}
		
		for(int i=0;i < 4;i++) {
		    liczbyDodawane[i] = Integer.parseInt(napisyDodawane[i],2);
		}
		
		for(int i=0;i < 4;i++) {
		    liczbyPoPorownaniu[i] = Integer.parseInt(liczbyBinarniePoPorownaniu[i],2);
		}
		
		System.out.println("");
		System.out.println("LiczbyDodawane: ");
		
		for(int i = 0;i < 4;i++) {
		    System.out.print(liczbyDodawane[i]+" ");
		}
		
		System.out.println("");
		
		for(int i = 0; i < liczbaPodsieci; i++) {
		    for(int j = 0; j < 4; j++) {
		        System.out.print(liczbyPoPorownaniu[j]+" ");
		    }
		    System.out.println("");
		    
		    for(int j = 0; j < 4; j++) {
		        int licznikKontrolny = liczbyPoPorownaniu[j] + liczbyDodawane[j];
		        if(licznikKontrolny > 255) {
		            liczbyPoPorownaniu[j-1] += 1;
		            liczbyPoPorownaniu[j] = (licznikKontrolny-256);
		        } else {
		            liczbyPoPorownaniu[j] += liczbyDodawane[j];
		        }
		        System.out.print(liczbyPoPorownaniu[j]+" ");
		        
		        if(j == 3) {
		            licznikKontrolny = liczbyPoPorownaniu[j] + 1;
    		        if(licznikKontrolny > 255) {
    		            liczbyPoPorownaniu[j-1] += 1;
    		            liczbyPoPorownaniu[j] = (licznikKontrolny-256);
    		        } else {
    		            liczbyPoPorownaniu[j] += 1;
    		        }
		        }
		    }
		    
		    System.out.println("");
		    System.out.println("");
		}
	    
	}
}
