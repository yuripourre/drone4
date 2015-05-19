import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;
import examples.controller.ControllerExample;


public class Controller extends EtyllicaFrame {

  private static final long serialVersionUID = 7739713774644387495L;

  public Controller() {
    super(435,301);
  }

  // Main program
  public static void main(String[] args) {
    Controller control = new Controller();
    control.init();
  }

  @Override
  public Application startApplication() {
    initialSetup("../");

    return new ControllerExample(w, h);
  }

}
