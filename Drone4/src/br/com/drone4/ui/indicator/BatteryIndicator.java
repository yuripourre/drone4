package br.com.drone4.ui.indicator;

import java.awt.Color;

import br.com.drone4.sensor.battery.BatterySensor;
import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.Layer;

public class BatteryIndicator extends Layer implements Drawable {

  public static int MAXIMUM = 100;
  public static int MINIMUM = 0;

  private BatterySensor battery;

  public BatteryIndicator(int x, int y, BatterySensor battery) {
    super(x, y, 30, 64);

    this.battery = battery;
  }

  @Override
  public void draw(Graphic g) {
    g.setColor(Color.GREEN);

    int connectorSize = h / 12;
    int offset = 2;

    g.drawRect(x + w / 3, y, w / 3, connectorSize);
    g.drawRect(x, y + connectorSize, w, h - connectorSize);

    drawFill(g, connectorSize, offset);

    g.setColor(Color.WHITE);
    g.setFontSize(12f);
    g.drawStringShadow(x, y - h / 2, w, h / 2, Integer.toString((int) battery.getLevel()) + "%");
  }

  private void drawFill(Graphic g, int connectorSize, int offset) {
    double percent = battery.getLevel() / battery.getScale();

    int division = ((h - connectorSize - offset * 2) / 4);

    int startFill = y + connectorSize + offset;
    int fillOffset = division + offset - 1;

    if (percent > 0.75) {
      g.fillRect(x + offset, startFill, w - offset - 1, division);
    }

    if (percent > 0.50) {
      g.fillRect(x + offset, startFill + fillOffset, w - offset - 1, division);
    }

    if (percent > 0.25) {
      g.fillRect(x + offset, startFill + fillOffset * 2, w - offset - 1, division);
    }

    if (percent > 0) {
      g.fillRect(x + offset, startFill + fillOffset * 3, w - offset - 1, division + 1);
    }

    if (percent == 0) {
      g.setColor(Color.RED);
      g.drawLine(x + offset, startFill + fillOffset * 3 + division, x + w - offset, startFill
          + fillOffset * 3 + division);
    }
  }

}
