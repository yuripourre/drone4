

import br.com.luvia.Luvia;
import br.com.luvia.core.context.ApplicationGL;
import examples.dji.DJICameraExample;

public class DJISimulator extends Luvia {

	private static final long serialVersionUID = 1839555598038534716L;

	public DJISimulator() {
		super(1280, 720); //720p
	}

	public static void main(String[] args) {
		DJISimulator example = new DJISimulator();
		example.init();
	}

	@Override
	public ApplicationGL startApplication() {
		initialSetup("../");
		return new DJICameraExample(w, h);
	}

}
