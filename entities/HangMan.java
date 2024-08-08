package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangMan {

private Player player;
private List<Categoria> words = new ArrayList<>();

public HangMan(Player player){
 this.player=player;
}

//adição e remoção
public void addWord(Categoria categoria){
words.add(categoria);
}

public void removeWord(Categoria categoria){
    words.remove(categoria);
}


//numeros
public int numeroDeCategorias(){
  return words.size();
}
public int getNumeroDePalavras(int number){
  return words.get(number).getWordQtt();
}


//ilustração
public void showPartida(int num, char[] arr){
                  System.out.println("\n///////////////");
                  System.out.println("vida: " +player.getLife());
for(int i=0;i<num;i++){
    System.out.print(arr[i]);
}
                  System.out.println("\n\n///////////////\n");
}


//partida
public void partida(int x,int y,Scanner sc){
  String palavra =  words.get(x).getWord(y);
  String categoria = words.get(x).getCategoria();
  int tamanho = palavra.length();
  
  //palavra virou um conjunto de letras
  char[] palavraChar = palavra.toCharArray();
  //palavra so que censurada
  char[] misterio = new char[tamanho];
  //boolean da partida
  boolean partida=true;
  
  //inicialização  da palavra escondida
  for(int i=0;i<tamanho;i++){
    misterio[i]='_';
  }
  while(partida){
    int counter =0;
    boolean achou=false;
    showPartida(tamanho,misterio);
    System.out.println("Categoria: "+categoria);
    System.out.println("digite uma letra");
    char letra = sc.next().toLowerCase().charAt(0);
    //checando se a palavra contem essa letra
       for(int i=0;i<tamanho;i++){ 
          if(palavraChar[i]==letra){ misterio[i]=letra; achou=true;}
          if(misterio[i]==palavraChar[i]){counter++;}
       }
        
       //causa dano no jogador caso a palavra não seja encontrada
       if(achou==false){ player.damage();}
       //proposta de chute
       if(player.getLife()==3){
        System.out.println("Gostaria de chutar a palavra?(s/n) \nAVISO: voce perdera TODAS as suas vidas se errar");
        sc.nextLine();
        String tentativa = sc.nextLine();

             if(tentativa.equals("s")){
              System.out.println("Digite a palavra");
              tentativa=sc.nextLine().toLowerCase();
                 if(tentativa.equals(palavra)){partida=false; System.out.println("parabens voce ganhou\npalvra: "+palavra);}
                 else{player.setLife(0);}
             }
       }
       //se todas as letras forem encontrandas a partida acaba
       if(counter==tamanho){partida=false; System.out.println("parabens voce ganhou\npalvra: "+palavra); }
       //se a vida do jogar for zero a partida acaba
       if(player.getLife()<=0){partida=false; System.out.println("Voce perdeu a palavra era "+palavra);}
  }

}

}
