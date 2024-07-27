package teste;
import java.util.Scanner;
import java.util.Random;

public class JogoDaForca{

public static void main(String[] argd){
    Scanner sc = new Scanner(System.in);
    Random rd= new Random();

     int dice= rd.nextInt(3);
     String[] palavra = {"sucesso","abacaxi","banana","java","pizza","peixe","passaro"};
  

    String escolhido= palavra[dice];
    char[] misterio = new char[escolhido.length()];
    char[] palavraChar;
    palavraChar= new char[escolhido.length()];
     boolean partida= true;
     int vida =5;
     
     //instanciação dos valores
     for(int i=0; i<escolhido.length();i++){
       misterio[i]='_';
       palavraChar[i]= escolhido.charAt(i);
      }
      
      
      while(partida){
        
        int cont=0;
        boolean letraAchada=false;

      graphic(escolhido.length(),misterio);
      System.out.println(" ");
      System.out.printf("\ndigite uma letra \tvida:%d ",vida);
      
      
      char letra = sc.nextLine().charAt(0);
      
        System.out.println(" ");
      //checando se a letra esta na palavra
        for(int i=0;i<palavraChar.length;i++){

            if(letra==palavraChar[i]){
                misterio[i]=letra;
                letraAchada=true;
            }
          }

          if(letraAchada==false){
            vida--;
          }

       //checando se ambos tem a mesmas letras
          for(int i=0;i<palavraChar.length;i++){
            if(misterio[i]==palavraChar[i]){
             cont++;

            }
          }

          if(vida==0){
            System.out.println("\nVoce perdeu");
            partida=false;
          } else if(cont==misterio.length){
            System.out.println("\nparabens voce Ganhou, a palavra era "+escolhido);
          partida=false;
          }
       

    }

     sc.close();

    }
   //ilustra a palavra misteriosa
    public static void graphic(int a,char[]b){

        for(int y=0;y<a;y++){

            System.out.print(b[y]);


        }

    }

}