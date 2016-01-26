package arcserver.java.lib.arcserver.geometry;

public class Polyline extends Geometry{

	private static String geometryType = "esriGeometryPolyline";
	
	public Polyline(){
		super(geometryType);
	}
	
	public String getGeometryType() {
		return geometryType;
	}
}
