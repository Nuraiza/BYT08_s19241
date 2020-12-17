import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;

	public void load(Properties props) throws ConfigurationException {

		// In this exercise the method load was too big and it was hard to understand
		// it, so I extracted from it 3
		// other new methods, so this way it is much clearer

		loadInterval(props);

		loadDuration(props);

		loadDeparture(props);
	}

	
	
	
	private void loadDeparture(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		departure = value;
	}

	
	
	private void loadDuration(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		duration = value;
	}

	
	
	private void loadInterval(Properties props) throws ConfigurationException {
	    String valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		interval = value;
	}
}
