package entities;
import java.util.ArrayList;
import java.util.List;

public class Categoria {

private String categoria;
private List<String> palavras = new ArrayList<>();

public Categoria(String categoria){
    this.categoria=categoria;
}

public void newWord(String word){
palavras.add(word);
}

public String getWord(int index){
    return palavras.get(index);
}

public int getWordQtt(){
    return palavras.size();
}


public String getCategoria(){
    return categoria;
}

}
