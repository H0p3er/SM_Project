package dto.productAttribute;

public class CPUDTO implements Product_AttributeDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8586413792483383459L;
	private int cpu_id;
    private String cpu_collection;
    private String cpu_socket;
    private int cpu_cores;
    private int cpu_threads;
    private String cpu_speed_ghz;
	public int getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}
	public String getCpu_collection() {
		return cpu_collection;
	}
	public void setCpu_collection(String cpu_collection) {
		this.cpu_collection = cpu_collection;
	}
	public String getCpu_socket() {
		return cpu_socket;
	}
	public void setCpu_socket(String cpu_socket) {
		this.cpu_socket = cpu_socket;
	}
	public int getCpu_cores() {
		return cpu_cores;
	}
	public void setCpu_cores(int cpu_cores) {
		this.cpu_cores = cpu_cores;
	}
	public int getCpu_threads() {
		return cpu_threads;
	}
	public void setCpu_threads(int cpu_threads) {
		this.cpu_threads = cpu_threads;
	}
	public String getCpu_speed_ghz() {
		return cpu_speed_ghz;
	}
	public void setCpu_speed_ghz(String cpu_speed_ghz) {
		this.cpu_speed_ghz = cpu_speed_ghz;
	}
	
}
