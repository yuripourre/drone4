import examples.drone4.indoor.IndoorEnvironment;
import examples.drone4.outdoor.AutonomousCleanEnvironment;
import examples.drone4.outdoor.CleanEnvironment;
import examples.drone4.outdoor.RemoteEnvironment;
import examples.drone4.outdoor.SportsEnvironment;
import br.com.etyllica.core.loader.JoystickLoader;
import br.com.luvia.Luvia;
import br.com.luvia.core.context.ApplicationGL;


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

    //Init joystick
    JoystickLoader.getInstance().init(5);

    //return new SportsEnvironment(w, h);
    //return new CleanEnvironment(w, h);
    //return new RemoteEnvironment(w, h);

    return new AutonomousCleanEnvironment(w, h);

  }

}
