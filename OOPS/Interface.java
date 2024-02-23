package OOPS;

public class Interface {
    public static void main(String args[]){
        // Queen q1 = new Queen();
        // q1.moves();

        // king k1 = new king();
        // k1.moves();
        
        // rook r1 = new rook();
        // r1.moves();
        omnivore o = new omnivore();
        o.eatsgrass();
        o.eatsmeat();
    }
}
interface chessplayer {
    // Interface is used for the complete abstraction process here only the idea is given not a single implementation takes place
    void moves();
}
class Queen implements chessplayer{
    // here by default the access will be of default type so will use public keyword so as in it recognizes the interface
    public void moves() { 
        System.out.println("Queen moves up down right left and diagonal in all the directions");
    }
}

class king implements chessplayer{
    public void moves() {
        System.out.println("King moves up down right left diagonal upto 1 unit");
    }
}

class rook implements chessplayer {
    public void moves() {
        System.out.println("Rook moves up down right and left in all the directions");
    }
}

// Here starts the example of the multiple inheritance

interface herbivore {
    void eatsgrass();
}

interface carnivore {
    void eatsmeat();
}

class omnivore implements herbivore, carnivore {
    public void eatsgrass() {
        System.out.println("Omnivores eats grass");
    }
     public void eatsmeat() {
        System.out.println("and also eats the meat");
     }
}
