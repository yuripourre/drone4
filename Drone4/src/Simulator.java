import br.com.drone4.examples.indoor.IndoorEnvironment;
import br.com.drone4.examples.outdoor.CleanEnvironment;
import br.com.drone4.examples.outdoor.SportsEnvironment;
import br.com.luvia.Luvia;
import br.com.luvia.core.ApplicationGL;


public class Simulator extends Luvia {

	private static final long serialVersionUID = 7739713774644387495L;

	public Simulator() {
		super(1024,576);
	}

	// Main program
	public static void main(String[] args) {

		Simulator luvmotion = new Simulator();
				
		luvmotion.init();

	}
	
	@Override
	public ApplicationGL startApplication() {
		
		initialSetup("../");
		
		return new SportsEnvironment(w, h);
		//return new CleanEnvironment(w, h);
		
	}

}
