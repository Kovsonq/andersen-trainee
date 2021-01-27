package part1.gofpatterns.Structural.Adapter.solution;

public class Client {
    public static void main(String[] args) {

        Client client = new Client();

        LegacyRectangular legacyRectangular =new LegacyRectangular();

        LegacyRectangleAdapter adapter = new LegacyRectangleAdapter(legacyRectangular);

        client.calculateRectangleSize(adapter);

    }


    public void calculateRectangleSize(Rectangular rectangular){
        System.out.println("Rec size: " + rectangular.determineSize());
    }
}
