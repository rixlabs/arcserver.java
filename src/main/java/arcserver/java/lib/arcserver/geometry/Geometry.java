package arcserver.java.lib.arcserver.geometry;

public class Geometry {

	private transient String geometryType;
	
	

	public Geometry(String geometryType) {
		this.geometryType = geometryType;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	

	
}
