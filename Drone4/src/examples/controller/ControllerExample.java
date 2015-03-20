package examples.controller;

import java.awt.Color;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.ImageLayer;
import examples.controller.model.RangeRadius;

public class ControllerExample extends Application {

	private ImageLayer background;
	
	private RangeRadius leftRadius;
	private RangeRadius rightRadius;
	
	public ControllerExample(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		background = new ImageLayer("control/controller_cut.jpg");
		
		leftRadius = new RangeRadius(36, 110);
		rightRadius = new RangeRadius(282, 110);
		
		loading = 100;
	}

	@Override
	public void draw(Graphic g) {
		background.draw(g);
		
		leftRadius.draw(g);
		rightRadius.draw(g);
		
		g.setColor(Color.WHITE);
		g.drawShadow(40, 40, Float.toString(leftRadius.getSensitivityX()));
		g.drawShadow(40, 80, Float.toString(leftRadius.getSensitivityY()));
		
		g.drawShadow(240, 40, Float.toString(rightRadius.getSensitivityX()));
		g.drawShadow(240, 80, Float.toString(rightRadius.getSensitivityY()));
	}
	
	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		
		leftRadius.updateMouse(event);
		rightRadius.updateMouse(event);
		
		return null;
		
	}

}
