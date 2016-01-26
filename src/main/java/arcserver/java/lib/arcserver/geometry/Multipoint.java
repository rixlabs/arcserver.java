package arcserver.java.lib.arcserver.geometry;

public class Multipoint extends Geometry{

	private static String geometryType = "esriGeometryMultipoint";
	
	public Multipoint(){
		super(geometryType);
	}
	
	public String getGeometryType() {
		return geometryType;
	}
}
