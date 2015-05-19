package br.com.drone4.sensor.camera;

import java.awt.image.BufferedImage;

import br.com.etyllica.motion.filter.image.SimpleFishEyeCorrectionFilter;

public class AngularLensCamera extends StandardCamera implements Camera {

  private boolean filtered = false;

  private SimpleFishEyeCorrectionFilter filter;

  public AngularLensCamera(double x, double y, double z) {
    super(x, y, z);

    filter = new SimpleFishEyeCorrectionFilter(5);
  }

  @Override
  public void setBufferedImage(BufferedImage bufferedImage) {
    this.bufferedImage = bufferedImage;
    filtered = false;
  }

  @Override
  public BufferedImage getBufferedImage() {

    if (!filtered) {

      bufferedImage = filter.process(bufferedImage);

      filtered = true;
    }

    return bufferedImage;
  }

}
