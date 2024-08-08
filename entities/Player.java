package entities;
public class Player {
private Integer life=5;

public int getLife(){
    return life;
}

public void damage(){
    life--;
}

public void setLife(int number){
life=number;
}
}
