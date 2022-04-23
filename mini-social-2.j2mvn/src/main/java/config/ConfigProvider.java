package config;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ConfigProvider {
	private final Map<String, String> configMap = new HashMap<String, String>();

	public ConfigProvider() {
	}

	// which will get a the configuration value inside
	// from the internal map associated with the key
	

	public String get(String key) {
		String value = null;
		for (Entry<String, String> pairEntry : configMap.entrySet()) {
			if (pairEntry.getKey().equals(key)) {
				value = pairEntry.getValue();
			}
		}
		return value;
	}

	// which will set a new configuration value inside the internal map
	public void set(String key, String value) {
		configMap.put(key, value);

	}

	// which will delete the configuration value inside the internal map
	public void remove(String key) {
		configMap.remove(key);
	}

}
//                                                       set(key, value)-----------v
//                                                                                 v                          
//                                               Constructor{input:[String key + String value]}--->>>>>------v
//                                                                                                           v
//                remove(aKey\ElementOfTheMap)                                                               v
//                          v                                                                                v
//           | Map  |---------->[key_+_value]----------------------------------------------------------------
//           |config|       ^                              
//                          ^
//             get(theValueOfTheKey)         
//               
//
////////////////////////////////
//what benefits come from completely hiding the map 
//collection from the outside? --> no access directly 
//name at least 1 abstraction (decoupling) idea that you've remarked during
//the execution of this task? --> we are using methods to get access to an (abstract)object(hashMap)
