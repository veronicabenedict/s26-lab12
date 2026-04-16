package edu.cmu.Weather;

public class Weather {
    public enum Scale {
        INCHES, MILLIMETERS
    }

    private WeatherService weatherService;
    // private boolean inches; -- not clear what exactly the scale is for the user
    // instead an enum wil allow to be more specific for user
    private Scale scale;

    /**
     * Sets the length scale for rainfall.
     *
     * @param scale the scale to set
     */
    public void setLengthScale(Scale scale) {
        this.scale = scale;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount. If the measurement is in inches, it CONVERTS the value FROM MM TO INCHES and returns it.
     *         If the measurement is not in inches, it returns the value in millimeters AS IS
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (scale == Scale.INCHES) {
            return wsRainfall / 25.4;
        } else {
            return wsRainfall;
        }
    }
}
