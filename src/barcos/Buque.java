package barcos;

public class Buque extends NaveConDanioTotal {

    public Buque(Vector mov, Vector pos, Vector orient) {
        super(mov, pos, orient, 4);
        System.out.println("Buque");
    }

    @Override
    public boolean estaDestruido() {
        return this.estaDaniado();
    }

}