package src.com.dcv.feb.day53;

public enum LogType {
	ERROR, INFO, WARNING;

	public String getCode() {
		switch (this) {
			case ERROR:
				return "ERR";
			case INFO:
				return "INFO";
			case WARNING:
				return "WARN";
		}
		return "Unknown";
	}
}
