package app;
import java.util.Scanner;
import java.util.Random;
import entities.*;

public class Game{

public static void main(String[] argd){
    Scanner sc = new Scanner(System.in);
    Random rd= new Random();
    
    //objeto no qual o jogo vai rodar
    HangMan hang = new HangMan(new Player());
    
    //categorias:
    //frutas
    Categoria frutas = new Categoria("Frutas");
    frutas.newWord("banana");
    frutas.newWord("abacaxi");
    frutas.newWord("laranja");
    //animais
    Categoria animais = new Categoria("Animais");
    animais.newWord("lobo");
    animais.newWord("cachorro");
    animais.newWord("aguia");
    //Fast food
    Categoria fastFood = new Categoria("Fast Food");
    fastFood.newWord("pizza");
    fastFood.newWord("hamburguer");
    fastFood.newWord("tacos");
    //adicionando as categorias a lista do hang
    hang.addWord(frutas);
    hang.addWord(animais);
    hang.addWord(fastFood);

    //obtendo numero aleatorio dentre os itens da lista
    int numero1 = rd.nextInt(hang.numeroDeCategorias());
    int numero2 = rd.nextInt(hang.getNumeroDePalavras(numero1));

    hang.partida(numero1, numero2, sc);

     sc.close();

    }
}